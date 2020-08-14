package com.jvm.t07_bytecode;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:51 下午 2020/8/14
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 从字节码角度来分析：构造方法
public class T10_ByteAnalyseInit {

    private String a = "s1";
    {
        b = 20;
    }

    private int b = 10;

    {
        a = "s2";
    }

    public T10_ByteAnalyseInit(String a, int b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        T10_ByteAnalyseInit d = new T10_ByteAnalyseInit("s3", 30);
        System.out.println(d.a);
        System.out.println(d.b);
    }
}
