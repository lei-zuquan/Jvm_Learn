package com.java.basic.c02_object;

/**
 * 四、匿名内部类
 * 1、声明格式
 * 位置：在创建对象的位置
 * 特点：一边声明类一边创建对象，匿名内部类只有唯一的对象
 *
 * new 父类（【实参列表】）{
 *
 * }
 *
 * new 接口（）{
 *
 * }
 *
 * 2、匿名内部类是一种特殊的局部内部类，凡是局部内部类的限制，匿名内部类都有。
 *      1）在匿名内部类中使用外部类的方法的局部变量，需要加final修饰
 *      2）在匿名内部类中使用外部类的非静态的成员变量，要受到所在方法的限制，
 *          所在方法是静态的话，就不能用外部类的非静态的成员变量。
 *
 * 3、字节码
 *      外部类名$数字.class
 *
 * 4、成员
 *      不能有静态成员
 *
 * 5、匿名内部类没有名字也没有修饰符
 *
 */
public class TestNoNameInner {
    public static void main(String[] args) {
        /**
        Object obj = new Object();
        System.out.println(obj.getClass()); // 运行时类型

        Object in = new Object(){

        };
        System.out.println(in.getClass()); // 运行时类型

         */

        /**
        // 创建 MyClass子类的匿名内部类的对象
         // 多态引用
        MyTestClass my = new MyTestClass() {
            @Override
            public void test() {
                System.out.println("子类重写父类的抽象主法");
            }
        };
        my.test();

        MyTestClass my2 = new MyTestClass("java") {
            @Override
            public void test() {
                System.out.println("子类重写父类的抽象主法");
            }
        };
        my2.test();
         */

        // 创建MyInter的实现类的匿名内部类对象
        // 多态引用
        MyInter myInter = new MyInter() {
            @Override
            public void test() {
                System.out.println("实现接口的抽象方法");
            }
        };
    }
}

abstract class MyTestClass{
    private String info;

    public MyTestClass() {
    }

    public MyTestClass(String info) {
        this.info = info;
    }

    public abstract void test();
}

interface MyInter{
    void test();
}
