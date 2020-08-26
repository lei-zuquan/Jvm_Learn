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
public class T03_Main {
    public static void main(String[] args) {
        T03_Cat[] a = {
                new T03_Cat(3,3),
                new T03_Cat(5,5),
                new T03_Cat(1,1)
        };
        T03_Sorter sorter = new T03_Sorter();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
