package com.java.z_exam.design_patterns.c02_strategy;

import java.util.Arrays;

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
public class T04_Main {
    public static void main(String[] args) {
        T04_Cat[] a = {
                new T04_Cat(3,3),
                new T04_Cat(5,5),
                new T04_Cat(1,1)
        };
        T04_Sorter sorter = new T04_Sorter();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
