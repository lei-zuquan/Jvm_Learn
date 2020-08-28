package com.java.z_exam.design_patterns.c02_strategy;

/**
 * @Author:
 * @Date: Created in 9:12 上午 2020/8/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 按体重大小的比较器
public class T05_CatWeightComparator implements T05_Comparator<T05_Cat> {

    @Override
    public int compare(T05_Cat o1, T05_Cat o2) {
        if (o1.weight < o2.weight) return -1;
        else if (o1.weight > o2.weight) return 1;
        else return 0;
    }
}
