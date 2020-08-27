package com.java.z_exam.design_patterns.c01_singleton;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:08 下午 2020/5/20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用！
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 * Class.forName("")
 * （话说你不用的，你装载它干啥）
 */
public class Singleton_01 {

    private static final Singleton_01 INSTANCE = new Singleton_01();

    // 构造方法私有
    private Singleton_01() {}

    public static Singleton_01 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Singleton_01 singleton01 = Singleton_01.getInstance();
        Singleton_01 singleton02 = Singleton_01.getInstance();

        System.out.println(singleton01 == singleton02);
    }
}
