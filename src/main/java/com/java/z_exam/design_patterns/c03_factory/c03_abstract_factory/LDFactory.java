package com.java.z_exam.design_patterns.c03_factory.c03_abstract_factory;

import com.java.z_exam.design_patterns.c03_factory.Pizza;
import com.java.z_exam.design_patterns.c03_factory.c02_factory_method.bean.LDCheesePizza;
import com.java.z_exam.design_patterns.c03_factory.c02_factory_method.bean.LDPepperPizza;

/**
 * @Author:
 * @Date: Created in 10:04 上午 2020/8/31
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class LDFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("~使用的是抽象工厂模式~");
        Pizza pizza = null;
        if (orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}