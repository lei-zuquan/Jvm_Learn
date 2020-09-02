package com.java.z_exam.design_patterns.c04_decorator;

/**
 * @Author:
 * @Date: Created in 10:26 上午 2020/9/2
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public abstract class AbstractDrink {

    public String des; // 描述
    private float price = 0.0f;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // 计算费用的抽象方法
    // 子类来实现
    public abstract float cost();
}
