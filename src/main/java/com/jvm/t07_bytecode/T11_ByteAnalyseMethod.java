package com.jvm.t07_bytecode;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:21 下午 2020/8/14
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 从字节码角度来分析：方法调用
public class T11_ByteAnalyseMethod {

    // 构造方法
    public T11_ByteAnalyseMethod() {}
    // 私有成员方法 test1
    private void test1() {}
    // 私有最终方法 test2
    private final void test2() {}
    // 公开成员方法 test3
    public void test3() {}
    // 公开静态方法 test4
    public static void test4() {}

    public static void main(String[] args) {
        T11_ByteAnalyseMethod d = new T11_ByteAnalyseMethod();
        d.test1(); // 通过对象.调用私有成员方法 test1
        d.test2(); // 通过对象.调用私有最终方法 test2
        d.test3(); // 通过对象.调用公开成员方法 test3
        d.test4(); // 通过对象.调用公开静态方法 test4

        T11_ByteAnalyseMethod.test4(); // 通过类.调用私有成员方法 test4
    }
}
