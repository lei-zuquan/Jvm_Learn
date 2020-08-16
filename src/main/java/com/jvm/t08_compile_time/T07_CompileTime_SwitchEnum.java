package com.jvm.t08_compile_time;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:47 上午 2020/8/16
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 编译期处理(语法糖)——switch-enum
enum Sex {
    MALE, FEMALE;
}

public class T07_CompileTime_SwitchEnum {
    /**
     * 定义一个合成类（仅 jvm 使用，对我们不可见）
     * 用来映射枚举的 ordinal 与数组元素的关系
     * 枚举的 ordinal 表示枚举对象的序号，从 0 开始
     * 即 MALE 的 ordinal()=0, FEMALE 的 ordinal()=1
     */
    static class $MAP {
        // 数组大小即为枚举元素个数，里面存储case用来对比的数字
        static int[] map = new int[2];
        static {
            map[Sex.MALE.ordinal()] = 1;
            map[Sex.FEMALE.ordinal()] = 2;
        }
    }

    public static void foo(Sex sex){
        int x = $MAP.map[sex.ordinal()];
        switch (x) {
            case 1:{
                System.out.println("男");
                break;
            }
            case 2:{
                System.out.println("女");
                break;
            }
        }
    }

    public static void foo1(Sex sex) {
        switch (sex) {
            case MALE:
                System.out.println("男"); break;
            case FEMALE:
                System.out.println("女"); break;
        }
    }
}
