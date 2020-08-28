package com.java.z_exam.design_patterns.c02_strategy;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:31 上午 2020/8/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T03_Cat implements T03_Comparable {
    int weight, height;

    public T03_Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
    // 定义猫的比较方法
    @Override
    public int compareTo(Object c) {
        T03_Cat cat = (T03_Cat)c;
        if (this.weight < cat.weight) return -1;
        else if (this.weight > cat.weight) return 1;
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
