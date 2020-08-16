package com.jvm.t08_compile_time;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:03 上午 2020/8/16
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 编译期处理(语法糖)——switch-string
public class T06_CompileTime_SwitchString {
    public T06_CompileTime_SwitchString() {

    }

    public static void choose(String str) {
        byte x = -1;
        switch (str.hashCode()) {
            case 99162322: // hello 的 hashCode
                if (str.equals("hello")) {
                    x = 0;
                }
            case 113318802: // word 的 hashCode
                if (str.equals("world")) {
                    x = 1;
                }
        }
        switch (x) {
            case 0:
                System.out.println("h");
                break;
            case 1:
                System.out.println("w");
                break;
        }
    }

    public static void choose1(String str) {
        switch (str) {
            case "hello": {
                System.out.println("h");
                break;
            }
            case "world": {
                System.out.println("w");
                break;
            }
        }
    }


}
