package com.java.z_exam.design_patterns.c03_factory_method;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 12:59 下午 2020/8/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C03_CarFactory {
    public C02_Car createCar() {
        System.out.println("a car created!");
        return new C02_Car();
    }
}
