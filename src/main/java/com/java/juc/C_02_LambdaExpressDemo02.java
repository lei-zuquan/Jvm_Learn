package com.java.juc;


/**
 * 02_LambdaExpress
 * 03_SaleTicket拆分
 *
 * 稳定的正规军都是使用JAVA语言，python只是在某些方面适合，并不合大型业务系统
 *
 * 1 函数式编程
 *      int age = 23;
 *
 *      y = kx + 1
 *
 *      f(x) = kx + 1;
 *
 */

@FunctionalInterface
// java8 如果只有一个方法，底层会自动加上@FunctionalInterface注解
interface Foo { // 接口定义方法，不含实现;
    // 有且仅有一个方法；类似班级里只有一个班长
    //public void sayHello();

    public int add(int x, int y);

    public default int mul(int x, int y){ // 前面的public 可以省略，default方法可能定义多个
        return x * y;
    }

    public default int mul2(int x, int y){
        return x * y;
    }

    public static int div(int x, int y){ // 静态方法可以定义多个
        return x / y;
    }

    public static int div2(int x, int y){
        return x / y;
    }
}


/**
 * Lambda就是解决匿名内部类代码冗余问题
 *
 * 函数式编程，接口中只能定义一个方法，有且仅有一个方法
 *
 * Lambda表达式口决：
 *
 * 1     拷贝小括号，写死右箭头，落地大括号
 * 2     @FunctionalInterface
 * 3     default
 * 4     static
 *
 */
public class C_02_LambdaExpressDemo02 {

    public static void main(String[] args) { // 尽量不要在main方法中编写业务方法
        /**Foo foo = new Foo() {
            @Override
            public void sayHello() {
                System.out.println("***** hello world");
            }

            @Override
            public int add(int x, int y) {
                return 0;
            }
        };

        foo.sayHello();*/

        // Foo foo = () -> {System.out.println("***** hello world Lambda Express");};
        // foo.sayHello();
        Foo foo = (int x, int y) -> {
            System.out.println("come in add method");
            return x + y;
        };
        System.out.println(foo.add(3,5));
        System.out.println(foo.mul(3,5));

        System.out.println(Foo.div(15,5));
    }

}
