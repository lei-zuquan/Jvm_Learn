package com.java.z_exam.design_patterns.c02_strategy;

/**
 * @Author:
 * @Date: Created in 7:48 上午 2020/8/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 第三个版本使用Object，实现类需要进行强转；非常不便，可以使用泛型
public interface T04_Comparable<T> {
    public int compareTo(T a);
}
