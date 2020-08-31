package com.java.z_exam.design_patterns.c03_factory.c02_factory_method;

/**
 * @Author:
 * @Date: Created in 9:16 上午 2020/8/31
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import com.java.z_exam.design_patterns.c03_factory.Pizza;
import com.java.z_exam.design_patterns.c03_factory.c02_factory_method.bean.LDCheesePizza;
import com.java.z_exam.design_patterns.c03_factory.c02_factory_method.bean.LDPepperPizza;


public class LDOrderPizza extends AbstractOrderPizza {
    @Override
    Pizza createPizza(String orderType) {
        Pizza pizza = null; if(orderType.equals("cheese")) {
            pizza = new LDCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new LDPepperPizza();
        }
        return pizza;
    }
}