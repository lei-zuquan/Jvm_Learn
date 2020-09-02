package com.java.z_exam.design_patterns.c04_decorator;

/**
 * @Author:
 * @Date: Created in 10:31 上午 2020/9/2
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Coffee extends AbstractDrink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}
