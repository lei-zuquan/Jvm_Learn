package com.test.leetcode;

/**
 * @Author:
 * @Date: Created in 5:18 下午 2020/9/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class SearchByMid {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        //常规方式
        System.out.println(binarySearch(arr, 9));
        //递归实现
        System.out.println(recursiveFind2(arr,0,arr.length-1,2));
    }

    public static int binarySearch(int[] arr, int findValue) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == findValue) {
                return mid;
            } else if (findValue > arr[mid]) {
                start = mid +1;
            } else {
                end = mid-1;
            }
        }

        return -1;
    }

    public static int recursiveFind2(int[] arr, int start, int end,int searchKey ) {
        if (start >= end) {
            return -1;
        }
        int mid = start + (end - start) / 2;

        if (arr[mid] == searchKey) {
            return mid;
        } else if (searchKey > arr[mid]) {
            return recursiveFind2(arr, mid, end, searchKey);
        } else {
            return recursiveFind2(arr, 0, mid, searchKey);
        }
    }


}
