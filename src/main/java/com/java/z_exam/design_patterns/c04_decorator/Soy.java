package com.java.z_exam.design_patterns.c04_decorator;

/**
 * @Author:
 * @Date: Created in 10:43 上午 2020/9/2
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Soy extends Decorator {
    public Soy(AbstractDrink drink) {
        super(drink);
        setDes(" 豆浆 ");
        setPrice(1.5f);
    }
}
