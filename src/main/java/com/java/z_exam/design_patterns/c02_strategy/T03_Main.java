package com.java.z_exam.design_patterns.c02_strategy;

import java.util.Arrays;

/**
 * @Author:
 * @Date: Created in 7:26 上午 2020/8/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
 * 一步步写策略:
 * 对修改关闭，对扩展开放；
 * 示例：比较大小策略、枪支打出来的子弹的策略
 * 核心点：将策略封装成一个接口，然后可以通过实现策略接口方式实现各式各样的不同策略；应用类调用时按需传入不同的策略即可，或者使用匿名内部类的方式实现接口方法
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
