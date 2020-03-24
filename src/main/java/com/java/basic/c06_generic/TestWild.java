package com.java.basic.c06_generic;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:26 下午 2020/3/24
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * day22_17泛型通配符？
 *
 * 类型通配符：
 * ?
 * 当声明一个方法时，这个方法形参是一个泛型类或泛型接口，但是此时又不确定如何指定这个泛型实参
 * 例如：public void test(List list)，这里的List是一个泛型接口，即这里无法确定List的泛型实参
 *
 * 解决方法一：
 *      该方法声明为一个泛型方法
 *      public <T> void Test(List<T> list){}
 *
 * 解决方法二：
 *      public void test2(List<?> list){}
 *
 * 方法一和方法二的区别
 *      1、元素的类型一个按照T，一个按照Object
 *      2、List<T> 不是只读
 *         List<?> 只读
 *
 * 2、可以设置？的上限
 *      ？ extends 上限
 *      ? 的类型必须是上限本身或者上限的子类， ? <= 上限
 *
 * 3、可以设置 ？的下限
 *      ？ super 下限
 *      ？的类型必须是下限本身或下限的父类，即？ >= 下限
 *
 */
public class TestWild {

    public <T> void test1(List<T> list, T t1){
        for (T t : list) {

        }

        list.add(t1); // 只能添加T的对象，或者T的子类
    }

    public void test2(List<?> list, Object obj){
        for (Object object : list) {
            System.out.println(object);
        }

        // list.add(obj);  // 不能添加，这里的？是完全未知的类型，所以你添加什么都有风险
    }

    public static <T extends Graphic> void printArea1(List<T> list){
        for (Graphic graphic : list) {
            System.out.println(graphic.getArea());
        }
    }

    public static void printArea2(List<? extends Graphic> list){
        for (Graphic graphic : list) {
            System.out.println(graphic.getArea());
        }
        // list.add(new Circle(3)); // 错误的，因为这个？可能是矩形，圆形，其他子类类型
    }

    /**
     * 设计一个方法，可以从一个集合src复制到另一个集合dest
     */
    public static <T> void copy(Collection<T> src, Collection<? super T> dest) {
        for (T t : src) {
            dest.add(t);
        }
    }

    public static void main(String[] args) {
        Collection<String> src = new ArrayList<>();
        Collection<Object> dest = new ArrayList<>();
        // src中的元素应该可以放到dest中

        copy(src, dest);
    }

}


























