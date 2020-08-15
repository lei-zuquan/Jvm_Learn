package com.jvm.t07_bytecode;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 5:40 下午 2020/8/15
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 从字节码角度分析：finally 出现了 return
public class T17_ByteAnalyseFinallyReturn {
    public static void main(String[] args) {
        int result = test();
        System.out.println(result);
    }

    public static int test() {
        try {
            return 10;
        } finally {
            return 20;
        }
    }
}
