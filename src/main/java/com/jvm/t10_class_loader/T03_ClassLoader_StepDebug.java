package com.jvm.t10_class_loader;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:36 上午 2020/8/18
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 类加载器 —— 单步调试查看过程
public class T03_ClassLoader_StepDebug {
    public static void main(String[] args) throws ClassNotFoundException {
        // forName 可以完成类的加载，也可以类的链接、初始化操作
        Class<?> aClass = Class.forName("com.jvm.t10_class_loader.T03_H");
        System.out.println(aClass.getClassLoader());
    }
}
