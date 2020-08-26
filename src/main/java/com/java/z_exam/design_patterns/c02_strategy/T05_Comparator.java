package com.java.z_exam.design_patterns.c02_strategy;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:58 上午 2020/8/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

@FunctionalInterface  // 如果确认只有这一个方法，不编写@FunctionalInterface 也是可以的
public interface T05_Comparator<T> {
    int compare(T o1, T o2);
}
