package com.test.leetcode;

/**
 * @Author:
 * @Date: Created in 2:54 下午 2020/9/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
/*
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
进阶:

你能不将整数转为字符串来解决这个问题吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class C009 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String value = x + "";
        char[] chars = value.toCharArray();
        int start = 0;
        int end = chars.length -1;

        while (start<= end) {
            if (chars[start++] != chars[end--]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        C009 c009 = new C009();
        System.out.println(c009.isPalindrome(121));
        System.out.println(c009.isPalindrome(-121));
        System.out.println(c009.isPalindrome(10));
        System.out.println(c009.isPalindrome(121));
    }
}
