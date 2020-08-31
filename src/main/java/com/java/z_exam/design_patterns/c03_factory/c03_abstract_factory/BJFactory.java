package com.java.z_exam.design_patterns.c03_factory.c03_abstract_factory;

import com.java.z_exam.design_patterns.c03_factory.Pizza;
import com.java.z_exam.design_patterns.c03_factory.c02_factory_method.bean.BJCheesePizza;
import com.java.z_exam.design_patterns.c03_factory.c02_factory_method.bean.BJPepperPizza;

/**
 * @Author:
 * @Date: Created in 10:02 上午 2020/8/31
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
//这是工厂子类
public class BJFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        System.out.println("~使用的是抽象工厂模式~");
        Pizza pizza = null;
        if(orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")){
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
