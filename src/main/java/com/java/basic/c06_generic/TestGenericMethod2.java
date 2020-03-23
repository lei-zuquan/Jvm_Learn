package com.java.basic.c06_generic;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:17 下午 2020/3/23
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */


import java.util.ArrayList;
import java.util.List;

/**
 * day22_16泛型形式二：泛型方法
 *
 * 1、声明一个图形抽象父类：Graphic, 有一个抽象方法
 * 2、声明它的一个子类圆Circle
 * 3、声明它的另一个子类矩形Rectangle
 * 4、设计一个工具类GraphicTools，包含一个方法，遍历并打印多个图形的面积
 *
 */

public class TestGenericMethod2 {
    public static void main(String[] args) {
        /**  List<Graphic> list = new ArrayList<>();
        list.add(new Circle(1.2));
        list.add(new Rectangle(1,2));

        GraphicTools.printArea(list);  **/

        List<Circle> list = new ArrayList<>();
        list.add(new Circle(1.2));
        list.add(new Circle(2));

        GraphicTools.printArea(list);

    }
}

class GraphicTools {
    // List<Graphic> list形参，只能接收List<Graphic> list 实参
    // List<Graphic> list形参，不能接收List<Graphic> circles 实参
    /**
    public static void printArea(List<Graphic> list){
        for (Graphic graphic : list) {
            System.out.println(graphic.getArea());
        }
    } */

    public static <T extends Graphic> void printArea(List<T> list){
        for (Graphic graphic : list) {
            System.out.println(graphic.getArea());
        }
    }
}

abstract class Graphic{
    public abstract double getArea();
}

class Circle extends Graphic{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}


class Rectangle extends Graphic {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        return length * width;
    }
}