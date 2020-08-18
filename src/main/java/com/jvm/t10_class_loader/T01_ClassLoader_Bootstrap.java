package com.jvm.t10_class_loader;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:20 上午 2020/8/18
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 用启动类加载器 Bootstrap加载类
public class T01_ClassLoader_Bootstrap {
    public static void main(String[] args) throws ClassNotFoundException {
        // forName 可以完成类的加载，也可以类的链接、初始化操作
        Class<?> aClass = Class.forName("com.jvm.t10_class_loader.T01_F");
        System.out.println(aClass.getClassLoader());
    }
}




