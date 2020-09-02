package com.java.z_exam.design_patterns.c04_decorator;

/**
 * @Author:
 * @Date: Created in 10:36 上午 2020/9/2
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Decorator extends AbstractDrink {
    private AbstractDrink drink;

    public Decorator(AbstractDrink drink) { // 组合
        this.drink = drink;
    }
    @Override
    public float cost() {
        // getPrice 自己价格
        return super.getPrice() + drink.cost();
    }

    @Override
    public String getDes() {
        // drink.getDes()  输出被装饰者的信息
        return super.des + " " + getPrice() + " && " + drink.getDes();
    }
}
