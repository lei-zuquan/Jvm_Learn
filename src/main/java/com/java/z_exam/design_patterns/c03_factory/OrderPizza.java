package com.java.z_exam.design_patterns.c03_factory;

/**
 * @Author:
 * @Date: Created in 7:48 上午 2020/8/31
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class OrderPizza {
    // 构造器
    public OrderPizza() {
        Pizza pizza = null;
        String orderType; //  订购披萨的类型
        do {
            orderType = getType();

            if (orderType.equals("greek")) {
                pizza = new GreekPizza();
                pizza.setName(" 希腊披萨 ");
            } else if (orderType.equals("cheese")) {
                pizza = new CheesePizza();
                pizza.setName(" 奶酪披萨 ");
            } else if (orderType.equals("pepper")) {
                pizza = new PepperPizza();
                pizza.setName("胡椒披萨");
            } else {
                break;
            }
            //输出 pizza 制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);
    }

    public String getType() {
        return "";
    }
}







