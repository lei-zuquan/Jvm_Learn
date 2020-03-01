package com.java.basic.c02_object.math;

import org.junit.Test;

/**
 * Math: 和数学运算相关
 * 如初等指数、对数、平方根和三角函数。
 *
 * 常量：
 * 1、PI
 * 2、求平方根：sqrt(x)
 * 3、求几次方：pow(x, y)，求x的y次方
 * 4、round(x): 四舍五入
 *      ceil(x): 向无穷大的方向取整 ceil天花枝
 *      floor(x): 向无穷小的方向取整 floor地板
 * 5、max(x, y)
 *    min(x, y)
 *
 * 6、随机数：Math.random()  -> [0,1)
 *      Java中在设计很多方法时，右边界基本上不包括。
 *
 *      java.util.Random类： 专门用来产生随机数
 *      1、double nextDouble(): [0,1)
 *      2、int nextInt(): 遍布所有int范围
 *      3、int nextInt(int n): [0, n)
 *
 */
public class TestMath {
    @Test
    public void test(){
        System.out.println(Math.round(2.4));
        System.out.println(Math.ceil(2.4));
        System.out.println(Math.floor(2.4));
        System.out.println();


        System.out.println(Math.round(2.6));
        System.out.println(Math.ceil(2.6));
        System.out.println(Math.floor(2.6));
        System.out.println();

        System.out.println(Math.round(-2.4));
        System.out.println(Math.ceil(-2.4));
        System.out.println(Math.floor(-2.4));
        System.out.println();

        System.out.println(Math.round(-2.6));
        System.out.println(Math.ceil(-2.6));
        System.out.println(Math.floor(-2.6));
        System.out.println();

        System.out.println(Math.round(-2.5));
        System.out.println(Math.ceil(-2.5));
    }
}
