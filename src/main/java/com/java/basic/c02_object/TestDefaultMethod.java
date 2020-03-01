package com.java.basic.c02_object;

/**
 * 默认方法的冲突问题
 * 1、当一个类实现了两个接口，这两个接口有方法签名相同的默认方法。
 *      方法签名：修饰符    返回值类型   方法名（形参列表）
 * 如何解决？
 * 1）保留其中一个接口的默认实现
 *      接口名.super.默认方法（...）;
 * 2）完全重写
 *
 * 2、当一个类继承父类，又实现接口，这个类中有与接口的默认方法的方法签名相同方法时
 * 1）默认保留的是父类的
 * 2）可以选择保留接口的默认实现
 *      接口名.super.默认方法（...）;
 * 3）完全重写
 */
public class TestDefaultMethod {
    public static void main(String[] args) {
        MyPerson p = new MyPerson();
        p.run();

        Sub s = new Sub();
        s.run();
    }
}

interface MyRunnable{
    public default void run(){
        System.out.println("Runnable的默认方法");
    }
}


interface MyWalkable{
    public default void run(){
        System.out.println("Walkable的默认方法");
    }
}

class MyPerson implements MyRunnable,MyWalkable{

    /*
    // 保留MyRunnable接口中的默认方法
    @Override
    public void run() {
        MyRunnable.super.run();
    }*/

    /*
    // 保留MyWalkable接口中的默认方法
    @Override
    public void run() {
        MyWalkable.super.run();
    }
     */

    /*
    @Override
    public void run(){
        System.out.println("找第三个");
    }*/

    // 逻辑上不同，语法上可以
    @Override
    public void run(){
        MyRunnable.super.run();
        MyWalkable.super.run();
    }
}

class Father{
    public void run(){
        System.out.println("Father类中的run()方法 ");
    }
}

class Sub extends Father implements MyRunnable{

}

class Dauther extends Father implements MyRunnable{
    /*
    // 手动选择保留接口的默认实现
    public void run(){
        MyRunnable.super.run();
    }*/

    public void run(){
        System.out.println("完全重写");
    }
}