package com.java.basic.c02_object;

/**
 * Ctrl + 1：快带修复
 *
 * 接口和类是同一个级别的概念。
 * Java的数据类型：基本数据类型和引用数据类型
 * 引用数据类型：类、接口、数组、枚举...
 *
 * 1、如何声明一个接口
 * 语法格式：
 * 【修饰符】interface 接口名{
 *
 * }
 *
 * 2、接口的成员有哪些？
 * JDK1.8之前：
 * 1）全局的静态的常量：public static final
 * 2) 公共的抽象的方法：public abstract
 *
 * JDK1.8之后，接口的语法有改动：
 * 增加了两类成员：
 * 1）静态方法：public static, static不可以省略;
 *      通过"接口名.方法"来进行调用；
 *      说明：接口的静态方法不会继承到实现类，不能用接口的实现类的对象来调用
 * 2）默认方法：public default
 *      通过"实现类的对象.方法"进行调用
 *      说明：实现类可以对接口的默认方法进行重写。重写时，不需要加default。
 *
 * 什么情况用静态方法？
 * 因为原来API中,往往会设计为这样：
 *  1）集合的接口：Collection
 *      集合的工具类：Collections
 *  2）文件
 *      文件路径的接口：Path
 *      工具类：Paths
 *  觉得没必要为这个接口再增加一个工具类，干脆把这些方法直接写到接口中，减少.class文件的数量，减少API的类型的数量。
 *
 * 什么情况下用到默认方法？
 * 当这个接口的某个抽象方法，在很多实现类中的实现代码是一样的，那么可以把这个实现挪到接口中，用默认方法进行实现。
 * 如果对该抽象方法不一样的实现的实现类，那么可以对该默认方法进行重写。
 *
 *
 * 说明：接口是没有构造器，代码块，除了全局的静态的常量以外的普通属性等。
 *
 * 3、如何实现接口？
 * 用来被实现的
 * 【修饰符】class 实现类 【extends 父类】 implements 接口们{
 *
 * }
 *
 * 4、接口的特点：
 * 1）实现类在实现接口时，必须实现接口的所有的抽象方法，否则这个实现类就必须是个抽象类
 * 2）一个类可以同时实现多个接口
 * 3）接口不能直接创建对象
 * 4）接口可以与实现类的对象构成多态引用
 * 5）一个类可以同时继承父类，又实现接口，但是要求，继承在前实现在后
 * 6）接口与接口之间支持多继承
 *
 * 理解：
 * 父类：亲生父亲，只有一个
 * 接口：干爹，可以同时有很多个
 *
 */
public class TestDefineAndUseInterface {
    public static void main(String[] args) {
        Flyable f = new Bird();
        f.fly();
    }


}

interface Flyable{
    int MAX_VALUE = 7900000; // 最高速度，超过这个速度，就脱离地球的引力
    int MIN_VALUE = 0; // 最低速度，低于这个就是静止了

    void fly();
}

interface Jumpable{
    void jump();
}

class Animal{

}

class Bird extends Animal implements Flyable, Jumpable{

    @Override
    public void fly() {
        System.out.println("我要飞的更高，飞得更高...");
    }

    @Override
    public void jump() {
        System.out.println("双脚跳");
    }
}


/**
 * 类与类之间：继承extends
 * 类与接口之间：实现implements
 * 接口与接口之间：继承extends
 */

interface A{
    void a();
}

interface B{
    void b();
}

interface C extends A, B{
    void c();
}

class MySubClass implements C{

    @Override
    public void a() {

    }

    @Override
    public void c() {

    }

    @Override
    public void b() {

    }
}