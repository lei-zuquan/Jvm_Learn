package com.java.z_exam.design_patterns.c03_abstract_factory;

import com.java.z_exam.design_patterns.c03_abstract_factory.abstract_class.C01_AbstractFactory;
import com.java.z_exam.design_patterns.c03_abstract_factory.abstract_class.C01_Food;
import com.java.z_exam.design_patterns.c03_abstract_factory.abstract_class.C01_Vehicle;
import com.java.z_exam.design_patterns.c03_abstract_factory.abstract_class.C01_Weapon;
import com.java.z_exam.design_patterns.c03_abstract_factory.bean.C01_AK47;
import com.java.z_exam.design_patterns.c03_abstract_factory.bean.C01_Bread;
import com.java.z_exam.design_patterns.c03_abstract_factory.bean.C01_Car;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:15 下午 2020/8/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C02_ModernFactory extends C01_AbstractFactory {
    @Override
    public C01_Food createFood() {
        return new C01_Bread();
    }

    @Override
    public C01_Vehicle createVehicle() {
        return new C01_Car();
    }

    @Override
    public C01_Weapon createWeapon() {
        return new C01_AK47();
    }
}
