package com.java.z_exam.design_patterns.c02_strategy;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:12 上午 2020/8/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T05_CatHeightComparator implements T05_Comparator<T05_Cat> {

    @Override
    public int compare(T05_Cat o1, T05_Cat o2) {
        if (o1.height > o2.height) return -1;
        else if (o1.height < o2.height) return 1;
        else return 0;
    }
}
