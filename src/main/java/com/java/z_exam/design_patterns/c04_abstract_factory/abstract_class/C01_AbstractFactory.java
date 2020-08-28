package com.java.z_exam.design_patterns.c04_abstract_factory.abstract_class;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 6:38 下午 2020/8/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 工厂方法比较方便产品一族的扩展
public abstract class C01_AbstractFactory {
    public abstract C01_Food createFood();
    public abstract C01_Vehicle createVehicle();
    public abstract C01_Weapon createWeapon();
}
