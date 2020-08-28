package com.java.z_exam.design_patterns.c02_strategy;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:31 上午 2020/8/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T05_Cat {
    public int weight, height;

    public T05_Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public String toString() {
        return "T03_Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
