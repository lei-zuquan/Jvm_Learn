package com.jvm.t11_runtime_optimize;

import java.lang.reflect.Method;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:01 下午 2020/8/19
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 运行期优化 —— 反射优化
public class T04_RunTime_Reflect {
    public static void foo() {
        System.out.println("foo...");
    }

    public static void main(String[] args) throws Exception {
        Method foo = T04_RunTime_Reflect.class.getMethod("foo");
        // 前16次调用效率较低，第17次调用效率较高
        for (int i = 0; i < 16; i++) {
            System.out.printf("%d\t", i);
            foo.invoke(null);
        }
        System.in.read();
    }
}
