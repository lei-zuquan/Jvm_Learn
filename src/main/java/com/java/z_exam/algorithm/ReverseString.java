package com.java.z_exam.algorithm;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:20 下午 2020/7/15
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
    Given s = "the sky is blue",
    return "eht yks si eulb".
    函数名：reverseString
    参数：原字符串
    返回：新字符串
    要求：可以不要求能一次性编译通过，语言任选。
 */
public class ReverseString {
    public static void main(String[] args) {
        String output = SplitLine("the sky is blue");

        System.out.println(output);
    }

    private static String SplitLine(String line) {
        String[] words = line.split(" ");

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(reverse(word) + " ");
        }

        String res = sb.toString();
        String substring = res.substring(0, res.length() - 1);
        return substring;
    }

    // 为了减少时间复杂度，不使用从头到尾遍历的方式；时间复杂度 O(logN)
    private static String reverse(String inputData) {
        int start = 0;
        int end  = inputData.length() - 1;
        char[] chars = inputData.toCharArray();

        while (start < end) {
            swap(chars, start++, end--);
        }

        return new String(chars);
    }

    // 数组元素交换
    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
