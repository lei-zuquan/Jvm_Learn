package com.java.z_exam.design_patterns.c04_decorator;

/**
 * @Author:
 * @Date: Created in 10:42 上午 2020/9/2
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Milk extends Decorator {
    public Milk(AbstractDrink drink) {
        super(drink);
        setDes(" 牛奶 ");
        setPrice(2.0f);
    }
}
