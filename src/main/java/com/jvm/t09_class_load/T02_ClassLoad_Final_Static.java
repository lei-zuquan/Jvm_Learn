package com.jvm.t09_class_load;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 1:07 下午 2020/8/17
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 类加载分析 - 演示 final 对静态变量的影响
public class T02_ClassLoad_Final_Static {
    // 在准备阶段，仅仅只有分配空间，没有赋值
    static int a;
    // 在准备阶段，仅仅只有分配空间，赋值是在类的构造方法中
    static int b = 10;
    // 在准备阶段，20 属于ConstantValue，final+static 修饰的整型变量 在准备阶段就完成了赋值，编译器对其优化了
    static final int c = 20;
    // 在准备阶段，"hello" 也属于ConstantValue，static+final 修饰的字符串常量 在准备阶段就完成了赋值，编译器对其优化
    static final String d = "hello";
    // 在准备阶段，如果 static 变量是final的，但属于引用类型，那么赋值也会在初始化阶段完成
    static final Object e = new Object();
}