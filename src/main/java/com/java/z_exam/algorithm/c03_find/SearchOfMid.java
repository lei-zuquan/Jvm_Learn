package com.java.z_exam.algorithm.c03_find;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 5:28 下午 2020/5/9
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */


public class SearchOfMid {

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        //常规方式
        System.out.println(binarySearch(arr, 9));
        //递归实现
        System.out.println(recursiveFind2(arr,0,arr.length-1,2));
    }
    /*
     * 二分查找，返回索引
     */
    private static int binarySearch(int [] arr,int searchKey){
        int lowerBound = 0;
        int upperBound = arr.length -1;
        int mid; // 二分查找，每次查找对应的索引值
        while (lowerBound <= upperBound){
            //mid = (lowerBound + upperBound) / 2; // 可能数值溢出
            mid = lowerBound + (upperBound - lowerBound) / 2;

            if (arr[mid] == searchKey) {
                return mid;
            } else {
                if (arr[mid] < searchKey) {
                    lowerBound = mid + 1;
                } else {
                    upperBound = mid - 1;
                }
            }
        }
        return -1;
    }
    /*
     * 二分查找，返回索引，递归实现
     */
    private static int recursiveFind(int[] arr,int start,int end,int searchKey){
        if (start <= end) {
            //int mid = (start + end) / 2; // 可能数值溢出
            int mid = start + (end - start) / 2;

            if (searchKey == arr[mid]) {
                return mid;
            } else if (searchKey < arr[mid]) {
                return recursiveFind(arr, start, mid - 1, searchKey);
            } else {
                return recursiveFind(arr, mid + 1, end, searchKey);
            }
        } else {
            return -1;
        }
    }


























    private static int binarySearch2(int [] arr,int searchKey){
        int start = 0;              // 二分查找起始下标值
        int end = arr.length - 1;   // 二分查找结束下标值

        while (end >= start) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == searchKey) {
                return mid;
            } else if (searchKey > arr[mid]) {
                start = mid + 1;
            } else if (searchKey < arr[mid]) {
                end = mid - 1;
            }
        }

        return -1; // 返回查找数据索引下标值
    }


    private static int recursiveFind2(int[] arr,int start,int end,int searchKey) {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == searchKey){
                return mid;
            }

            if (searchKey > arr[mid]){
                start = mid + 1;
            } else if (searchKey < arr[mid]){
                end = mid - 1;
            }

            return recursiveFind2(arr, start, end, searchKey);
        } else {
            return -1;
        }
    }
}

