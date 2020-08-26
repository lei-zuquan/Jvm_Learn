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
public class T01_Main {
    public static void main(String[] args) {
        int[] a = {9,2,3,5,7,1,4};
        T01_Sorter sorter = new T01_Sorter();
        sorter.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
