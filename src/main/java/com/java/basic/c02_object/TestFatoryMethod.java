package com.java.basic.c02_object;

/**
 * 面向对象的开发原则：
 *  1）面向接口编程
 *  2）对修改关闭，对扩展开放
 *
 * 简单工厂模式（了解）：
 *  1）接口
 *  2）一系列的实现类
 *  3）一个工厂类，有一个生产对象的方法
 *
 * 优点：简单
 * 缺点：如果有增加一个产品接口的实现类，需要修改工厂类的代码
 *
 * 工厂方法设计模式（了解）：
 *  1）接口
 *  2）一系列的实现类
 *  3）每一个实现类，会有自己的工厂类
 *
 * 优点：如果增加产品的实现类，那么不需要修改工厂类的代码，只需要增加一个对应的工厂类就可以。
 * 缺点：类太多
 *
 */
public class TestFatoryMethod {
    public static void main(String[] args) {
        // 多态引用，左边是接口的类型，右边赋值的是实现类的对象
        Car c = BMWFactory.getBMW();
        c.run();


    }
}

// 形式一：
// 第一个实现类，单独编写工厂
class BMWFactory{
    public static BMW getBMW(){
        return new BMW();
    }
}

class BenzFactory{
    public static Benz getBenz(){
        return new Benz();
    }
}

// 形式二：
interface CarFactory{
    Car getCar(); // 生产车
}

// 工厂类有很多个，都实现工厂的接口
class BaoMaFactory implements CarFactory{

    @Override
    public Car getCar() {
        return new BMW();
    }
}

class BenChiFactory implements CarFactory{

    @Override
    public Car getCar() {
        return new Benz();
    }
}