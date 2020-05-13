package com.java.z_exam.suanfa.find;

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
        int [] arr = {1,3,4,5,2,5,1,8,9,5};
        //常规方式
        System.out.println(find(arr,9));
        //递归实现
        System.out.println(recursiveFind(arr,0,arr.length-1,9));
    }
    /*
     * 二分查找，返回索引
     */
    private static int find(int [] arr,int searchKey){
        int lowerBound = 0;
        int upperBound = arr.length -1;
        int curIn;
        while (lowerBound <= upperBound){
            curIn = (lowerBound + upperBound) / 2;
            if (arr[curIn] == searchKey) {
                return curIn;
            } else {
                if (arr[curIn] < searchKey) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
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
            int middle =  (start+end)/2;
            if (searchKey == arr[middle]) {
                return middle;
            } else if (searchKey < arr[middle]) {
                return recursiveFind(arr, start, middle - 1, searchKey);
            } else {
                return recursiveFind(arr, middle + 1, end, searchKey);
            }
        } else {
            return -1;
        }
    }
}

