package com.java.z_exam.design_patterns.c04_decorator;

/**
 * @Author:
 * @Date: Created in 10:40 上午 2020/9/2
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 具体的Decorator, 这里就是调味品
public class Chocolate extends Decorator {
    public Chocolate(AbstractDrink drink) {
        super(drink);
        setDes(" 巧克力 ");
        setPrice(3.0f); // 调味品的价格
    }
}
