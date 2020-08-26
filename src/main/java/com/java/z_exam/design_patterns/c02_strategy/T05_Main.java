package com.java.z_exam.design_patterns.c02_strategy;

import java.util.Arrays;
import java.util.Properties;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:26 上午 2020/8/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
 * 一步步写策略
 */
public class T05_Main {
    public static void main(String[] args) {
        T05_Cat[] a = {
                new T05_Cat(3,3),
                new T05_Cat(5,5),
                new T05_Cat(1,1)
        };
        T05_Sorter<T05_Cat> sorter = new T05_Sorter<T05_Cat>();
        //sorter.sort(a, new T05_CatWeightComparator());
        // 采用策略模型：
        //sorter.sort(a, new T05_CatHeightComparator());

        // 写法上，可以采用lambda 表达式进行
        sorter.sort(a, (o1, o2) -> {
            T05_Cat cat1 = (T05_Cat)o1;
            T05_Cat cat2 = (T05_Cat)o2;

            if (cat1.weight < cat2.weight) return -1;
            else if (cat1.weight > cat2.weight) return 1;
            else return 0;
        });

        // 还可以通过加载类名

        System.out.println(Arrays.toString(a));
    }
}
