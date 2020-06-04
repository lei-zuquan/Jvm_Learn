package com.java.z_exam.better_code;

import java.util.HashMap;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-04 8:12
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
对取模可以有一个优化，可以简单可以记为：

              x  %  2^n = x & (2 ^ n - 1)

这个是针对2的n次方的，也就是针对偶数的，原理其实很简单：

举个例子吧：

xxx % 16 = 2 

　　   32  16  8   4   2   1 

18：   x     x  x   x   x   x
16：   0     1  0   0   0   0
16-1:  0     0  1   1   1   1
----------------------------------
       0     0  x   x   x   x 

可以理解为：大于16的那些一是可以直接约掉，因为大于16的1肯定是16的整数倍，可以直接约掉，

等于16的也是那样；对于小于16的数，就是有多少就是多少，也就是和所有1求与，所以就是那样了。

 */
public class C01_GetModWay {
    public static void main(String[] args) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 2);
        int times = 100000;
        int modInt = 2 << 3;
        getModWay1(times, modInt);
        getModWay2(times, modInt);
        
    }

    private static void getModWay1(int times, int modInt) {
        long startTime = System.currentTimeMillis();

        int modValue = 0;
        for (int i = 0; i < times; i++) {
            modValue = i % modInt;
            System.out.print(modValue + " ");
        }
        long endTime = System.currentTimeMillis();

        long spend = endTime - startTime;
        System.out.println();
        System.out.println(spend);
    }

    private static void getModWay2(int times, int modInt) {
        long startTime = System.currentTimeMillis();

        int modValue = 0;
        for (int i = 0; i < times; i++) {
            modValue = i & (modInt - 1);
            System.out.print(modValue + " ");
        }
        long endTime = System.currentTimeMillis();

        long spend = endTime - startTime;
        System.out.println();
        System.out.println(spend);
    }
}
