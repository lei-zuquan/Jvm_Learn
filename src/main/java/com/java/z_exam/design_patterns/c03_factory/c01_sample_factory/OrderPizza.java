package com.java.z_exam.design_patterns.c03_factory.c01_sample_factory;

/**
 * @Author:
 * @Date: Created in 8:52 上午 2020/8/31
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
import com.java.z_exam.design_patterns.c03_factory.CheesePizza;
import com.java.z_exam.design_patterns.c03_factory.GreekPizza;
import com.java.z_exam.design_patterns.c03_factory.PepperPizza;
import com.java.z_exam.design_patterns.c03_factory.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    //定义一个简单工厂对象
    SimpleFactory simpleFactory;
	Pizza pizza = null;

    //构造器
    public OrderPizza(SimpleFactory simpleFactory) {
	    setFactory(simpleFactory);
    }

    public void setFactory(SimpleFactory simpleFactory) {
        String orderType = ""; //用户输入的
        this.simpleFactory = simpleFactory; //设置简单工厂对象
        do {
            orderType = getType();
            pizza = this.simpleFactory.createPizza(orderType);

            //输出 pizza
            if (pizza != null) { //订购成功
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println(" 订购披萨失败 ");
                break;
            }
        } while (true);
    }

    // 写一个方法，可以获取客户希望订购的披萨种类
    private String getType() {
        try {
            BufferedReader strIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input pizza 种类:");
            String str = strIn.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace(); return "";
        }
    }
}
