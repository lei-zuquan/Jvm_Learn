package com.java.z_exam.design_patterns.c03_factory_method;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 12:55 下午 2020/8/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 下面是简单工厂
/*
    简单工厂的可扩展性不好
    我们还可以针对每个交通工具创建一个工厂
 */
public class C03_SimpleVehicleFactory {
    public C02_Car createCar() {
        // before processing
        return new C02_Car();
    }

    public C02_Broom createBroom() {
        return new C02_Broom();
    }
}
