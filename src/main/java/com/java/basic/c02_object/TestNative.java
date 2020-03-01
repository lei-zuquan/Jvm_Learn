package com.java.basic.c02_object;

/**
 * native: 原生的，内置的
 * 是一个修饰符，只能修饰方法
 *
 * native修饰的方法，说明不是用Java 语言实现的方法体，而是由C语言等实现的，用C语言实现后，编译为.dll文件，然后由JAVA代码调用
 *
 * 对于使用这个方法的人来说，没有区别，和普通的JAVA方法一样。
 * 该怎么调用怎么调用，子类继承后如果需要重写，就可以重写。
 *
 * 调用方法的规则：
 * 1）静态的用类名，非静态的用对象
 * 2）有形参，传对应个数、类型的实参
 * 3）有返回值就接收，没有返回值就不接收
 *
 */
public class TestNative {

}
