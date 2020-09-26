package com.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:
 * @Date: Created in 8:53 下午 2020/9/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

        示例 1:

        输入: 123
        输出: 321
         示例 2:

        输入: -123
        输出: -321
        示例 3:

        输入: 120
        输出: 21

执行结果：
通过
显示详情
执行用时：
1 ms
, 在所有 Java 提交中击败了
100.00%
的用户
内存消耗：
36.1 MB
, 在所有 Java 提交中击败了
66.81%
的用户
*/


public class C007 {

    public static int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            x = -1 * x;
            flag = true;
        }

        int remain = x;
        int res = 0;
        while (remain > 0) {
            if (res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int first = remain % 10;
            res = res * 10 + first;
            remain = remain / 10;
        }

        if (flag) {
            res = -1 * res;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1_534_236_469));
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
    }
}
