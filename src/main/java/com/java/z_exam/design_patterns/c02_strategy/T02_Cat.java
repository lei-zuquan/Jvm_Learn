package com.java.z_exam.design_patterns.c02_strategy;

/**
 * @Author:
 * @Date: Created in 7:31 上午 2020/8/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T02_Cat {
    int weight, height;

    public T02_Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
    // 定义猫的比较方法
    public int compareTo(T02_Cat c) {
        if (this.weight < c.weight) return -1;
        else if (this.weight > c.weight) return 1;
        else return  0;
    }

    @Override
    public String toString() {
        return "T03_Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }
}
