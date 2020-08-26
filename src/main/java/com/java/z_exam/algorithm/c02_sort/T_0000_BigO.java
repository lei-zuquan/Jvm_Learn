package com.java.z_exam.algorithm.c02_sort;

import javax.xml.stream.events.EndDocument;

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

    // 空间复杂度：不管传入的数组大小为多少，始终额外申请4+4=8个字节
    public static int[] reverse(int[] arr) {
        int n = arr.length; // 申请4个字节
        int temp; // 申请4个字节
        for (int start = 0, end = n-1; start <= end; start++, end--) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        return arr;
    }

    // 空间复杂度：4+4n+24=4n + 28
    public static int[] reverse2(int[] arr) {
        int n = arr.length; // 申请4个字节
        int[] temp = new int[n]; // 申请n*4个字节 + 数组自身头信息开销24字节
        for (int i = n-1; i >= 0; i--) {
            temp[n-1-i] = arr[i];
        }
        return temp;
    }
}
