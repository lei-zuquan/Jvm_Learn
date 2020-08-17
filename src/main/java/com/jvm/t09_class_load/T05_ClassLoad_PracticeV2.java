package com.jvm.t09_class_load;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:30 下午 2020/8/17
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 类加载分析 - 练习2
public class T05_ClassLoad_PracticeV2 {
    public static void main(String[] args) {
        //Singleton.test(); // 调用静态方法test，不会触发类的初始化
        Singleton.getInstance(); //
    }
}

class Singleton {
    public static void test() {
        System.out.println("test");
    }

    private Singleton() {}

    // 静态内部类，好处就是可以访问外部类的资源：构造方法，虽然构造方法是私有的，但在静态内部类还是可以访问的
    // 内部类中保证单例
    private static class LazyHolder {
        private static final Singleton SINGLETON = new Singleton();
        static {
            System.out.println("lazy holder init");
        }
    }

    // 第一次调用，getInstance 方法，才会导致内部类加载和初始化其静态成员
    public static Singleton getInstance() {
        return LazyHolder.SINGLETON;
    }
}
