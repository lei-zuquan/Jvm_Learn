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
public class T02_Main {
    public static void main(String[] args) {
        T02_Cat[] a = {new T02_Cat(3,3), new T02_Cat(5,5), new T02_Cat(1,1)};
        T02_Sorter sorter = new T02_Sorter();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
