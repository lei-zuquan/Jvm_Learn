package com.java.z_exam.design_patterns.c03_factory_method;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:57 上午 2020/8/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C02_Main {
    public static void main(String[] args) {
        C02_Moveable m = new C02_Plane();
        m.go();

    }
}

/*
    任意定制交通工具
    任意定制生产过程
    任意定制产品一族

    当我们new 一个交通工具时，必须控制权限；那我们写一段代码呗，当然是可以的；比如：创建car权限/创建train权限/创建plane权限是不一样的
    所以代码就得来来回回变，代码变得很不稳定

    既然这样，产生对象的方式，我们交给工厂，比如简单工厂
 */






























