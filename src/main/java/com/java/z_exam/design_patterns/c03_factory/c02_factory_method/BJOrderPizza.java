package com.java.z_exam.design_patterns.c03_factory.c02_factory_method;

import com.java.z_exam.design_patterns.c03_factory.Pizza;
import com.java.z_exam.design_patterns.c03_factory.c02_factory_method.bean.BJCheesePizza;
import com.java.z_exam.design_patterns.c03_factory.c02_factory_method.bean.BJPepperPizza;

/**
 * @Author:
 * @Date: Created in 9:15 上午 2020/8/31
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

public class BJOrderPizza extends AbstractOrderPizza {
    @Override
    Pizza createPizza(String orderType) {

        Pizza pizza = null;
        if(orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        } else if (orderType.equals("pepper")) {
            pizza = new BJPepperPizza();
        }
        return pizza;
    }
}
