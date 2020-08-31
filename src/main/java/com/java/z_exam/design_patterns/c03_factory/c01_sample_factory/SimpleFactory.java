package com.java.z_exam.design_patterns.c03_factory.c01_sample_factory;

import com.java.z_exam.design_patterns.c03_factory.CheesePizza;
import com.java.z_exam.design_patterns.c03_factory.GreekPizza;
import com.java.z_exam.design_patterns.c03_factory.PepperPizza;
import com.java.z_exam.design_patterns.c03_factory.Pizza;

/**
 * @Author:
 * @Date: Created in 8:47 上午 2020/8/31
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 简单工厂类
public class SimpleFactory {
    // 简单工厂模式 也叫 静态工厂模式
    public static Pizza createPizza(String orderType) {
        Pizza pizza = null;

        System.out.println("使用简单工厂模式");
        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName(" 希腊披萨 ");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName(" 奶酪披萨 ");
        } else if (orderType.equals("pepper")) {
            pizza = new PepperPizza();
            pizza.setName("胡椒披萨");
        }

        return pizza;
    }
}

