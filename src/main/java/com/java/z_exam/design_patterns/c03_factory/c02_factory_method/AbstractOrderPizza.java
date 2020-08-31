package com.java.z_exam.design_patterns.c03_factory.c02_factory_method;

import com.java.z_exam.design_patterns.c03_factory.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author:
 * @Date: Created in 9:13 上午 2020/8/31
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

public abstract class AbstractOrderPizza {
    //定义一个抽象方法，createPizza ,  让各个工厂子类自己实现
    abstract Pizza createPizza(String orderType);

    // 构造器
    public AbstractOrderPizza() { Pizza pizza = null;
        String orderType; //  订购披萨的类型
        do {
            orderType = getType();
            pizza = createPizza(orderType); //抽象方法，由工厂子类完成
            //输出 pizza 制作过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();

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