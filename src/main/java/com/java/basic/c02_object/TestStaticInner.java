package com.java.basic.c02_object;

/**
 * 一、静态内部类
 * 1、如何声明？
 * 【修饰符】 class 外部类 【extends 父类】 【implements 父接口们】{
 *     【修饰符】 static class 内部类 【extends 父类】 【implements 父接口位】{
 *
 *     }
 * }
 *
 * 2、成员
 * 类的5大成员都可以
 *      1）属性：静态和非静态的属性
 *      2）方法：静态的和非静态的方法
 *          在抽象的静态内部类中，还可以有抽象方法
 *      3）代码块：静态的和非静态
 *      4）构造器：无参、有参
 *      5）内部类：语法上可以，但是太复杂了，不这么写
 *
 * 3、使用
 *      1) 在静态内部类中不允许使用外部类的非静态的成员
 *      2) 在外部类中，使用静态内部类和使用其他的类一样
 *      3) 在外部类的外面使用静态内部类，不需要外部类的对象
 *      4）在外部类的外面要调用静态内部类的非静态方法，需要静态内部类的对象
 *      5）在外部类的外面要调用静态内部类的静态方法，不需要静态内部类的对象
 *
 */
public class TestStaticInner {

    public static void main(String[] args) {
        // 调用Inner的test() 方法
        // (1)问？是否需要外部类Outer的对象
        // 答：不要，因为Inner是Outer的静态成员
        // (2)问？是否需要内部类Inner的对象
        // 答：要，因为test方法本身不是静态的
        Outer.Inner obj = new Outer.Inner();
        obj.test();
    }
}

class Outer{
    private static int i;
    private int j;

    static class Inner{
        public void test(){
            System.out.println(i); // 直接使用外部类的私有的成员
            //System.out.println(j); // 错误的，static的不能直接使用非静态static
        }
    }
    abstract static class In{

    }

    public Inner getInner(){
        Inner in = new Inner();
        return in;
    }
}


