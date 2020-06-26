package com.java.z_exam.algorithm.c02_sort.sort_with_design;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:45 上午 2020/6/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T07_SearchOfMid<T extends Comparable<T>> {


    public int binarySearch(T[] arr, T searchKey) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid].compareTo(searchKey) == 0) {
                return mid;
            } else if (arr[mid].compareTo(searchKey) > 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    /*
     * 二分查找，返回索引，递归实现
     */
    private int recursiveFind(T[] arr,int start,int end, T searchKey){
        int mid = start + (end - start) / 2;
        if (arr[mid].compareTo(searchKey) == 0) {
            return mid;
        } else if (arr[mid].compareTo(searchKey) > 0) {
            end = mid -1;
            return recursiveFind(arr, start, end, searchKey);
        } else {
            start = mid +1;
            return recursiveFind(arr, start, end, searchKey);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7,8,9};

        T07_SearchOfMid search = new T07_SearchOfMid();
        int index = search.recursiveFind(arr, 0, arr.length -1, 90);
        System.out.println(index);
    }
}
