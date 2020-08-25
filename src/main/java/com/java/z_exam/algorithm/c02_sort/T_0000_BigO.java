package com.java.z_exam.algorithm.c02_sort;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:15 下午 2020/8/25
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T_0000_BigO {
    public static void main(String[] args) {
        int n = 100;
        int i = n+2;
        System.out.println(i);
    }

    public int search(int num) {
        int[] arr = {11,10,8,9,7,22,23,0};
        for (int i = 0; i < arr.length; i++) {
            if (num == arr[i]) {
                return i;
            }
        }
        return -1;
    }
}
