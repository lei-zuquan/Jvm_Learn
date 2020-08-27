package com.java.z_exam.design_patterns.c01_singleton;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:16 下午 2020/5/20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 跟01是一个意思
 */
public class Singleton_02 {

    private static final Singleton_02 INSTANCE;

    // 通过静态代码块实现单例的实例化
    static {
        INSTANCE = new Singleton_02();
    }

    // 构造方法私有
    private Singleton_02() {}

    public static Singleton_02 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Singleton_02 singleton01 = Singleton_02.getInstance();
        Singleton_02 singleton02 = Singleton_02.getInstance();

        System.out.println(singleton01 == singleton02);
    }

}
