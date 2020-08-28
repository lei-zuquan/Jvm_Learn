package com.java.z_exam.design_patterns.c04_abstract_factory;

import com.java.z_exam.design_patterns.c04_abstract_factory.abstract_class.C01_AbstractFactory;
import com.java.z_exam.design_patterns.c04_abstract_factory.abstract_class.C01_Food;
import com.java.z_exam.design_patterns.c04_abstract_factory.abstract_class.C01_Vehicle;
import com.java.z_exam.design_patterns.c04_abstract_factory.abstract_class.C01_Weapon;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 1:09 下午 2020/8/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
    1、工厂系列
    2、简单工厂
    3、静态工厂
    4、工厂方法FactoryMethod
        a.产品维度扩展
    5、抽象工厂
        a.产品一族进行扩展
 */
public class C02_Main {
    public static void main(String[] args) {
        // 使用抽象工厂，可以方便产品族的扩展
        C01_AbstractFactory f = new C02_ModernFactory();

        C01_Vehicle c = f.createVehicle();
        c.go();

        C01_Weapon w = f.createWeapon();
        w.shoot();

        C01_Food b = f.createFood();
        b.printName();
    }
}

























