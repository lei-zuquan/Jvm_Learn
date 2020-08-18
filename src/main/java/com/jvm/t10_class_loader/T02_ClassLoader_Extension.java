package com.jvm.t10_class_loader;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:31 上午 2020/8/18
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 演示 扩展类加载器
 * 在 D:\Program Files\Java\jdk1.8.0_91 下有一个 my.jar
 * 里面也有一个 G 的类，观察到底是哪个类被加载了
 */
// 类加载器 —— 用扩展类加载器 Extension ClassLoader加载类
public class T02_ClassLoader_Extension {
    public static void main(String[] args) throws ClassNotFoundException {
        // forName 可以完成类的加载，也可以类的链接、初始化操作
        Class<?> aClass = Class.forName("com.jvm.t10_class_loader.T02_G");
        System.out.println(aClass.getClassLoader());
    }
}
