package com.java.basic.c02_object;

/**
 * abstract: 抽象的
 * abstract也是修饰符，它可以修饰：类（包括内部类和外部类）、方法
 *
 * 1、为什么要使用抽象类和抽象方法
 *     当我们在设计父类时，发现某些方法是无法给出具体的实现，具体的实现应该在子类中实现。那么这样的方法，在父类中就可以设计为"抽象方法"
 *     包含抽象方法的类，必须是一个"抽象类"
 *
 * 2、抽象类、抽象方法的语法格式
 * 【权限修饰符】abstract class 类名 【extends 父类】{
 *     【权限修饰符】abstract  返回值类型 方法名（【形参列表】）;
 * }
 *
 * 3、抽象类的特点
 * 1）抽象类不能直接new对象
 * 2) 抽象类就是用来被继承的，那么子类继承抽象类后，必须实现抽象类的抽象方法，否则子类也得是抽象类。
 * 3) 抽象类的变量可以与子类的对象构成多态引用，执行子类重写的方法
 * 4) 抽象类可以和普通类一样，拥有：属性、构造器、代码块、非抽象的方法等成员，这些给子类可以用。
 * 5) 一个类如果有抽象方法，这个类必须是抽象类，但是一个抽象类也可以没有抽象方法，目的就是不能创建对象
 *
 * 需求：
 * 1、设计一个图形类Graphic
 * 2、这个图形类有很多子类：Rectangle矩形、Circle图形、Triangle三角形等
 * 这些图形，有图形名称，图形的面积，图形的周长
 * 既然所有的子类有共同的特征，那么这些共同的特征应该设计到父类图形类Graphic中，因为父类就是代表所有子类共同的部分。
 *
 * 类：一类具有相同特性的事特的抽象描述。
 */
public class TestAbstract {
    public static void main(String[] args) {
        //Graphic graphic = new Graphic();
        //graphic.getArea();
    }
}

abstract class Graphic{
    // 在父类中，是无法给出统一的实现的
    public abstract double getArea();
}

class ttt extends Graphic{

    @Override
    public double getArea() {
        return 0;
    }
}

// 目的：不让你创建它的对象，让你创建它子尖的对象
abstract class Person{
    // ...
}

class Man extends Person{

}
