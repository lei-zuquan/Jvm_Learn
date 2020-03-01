package com.java.basic.c01_datatype;


/**
 * 二分法查找
 * 前提：数组必须是有序的
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        int[] arr = new int[]{2,34,44,65,78,88,89,90,123,234,456};

        int value = -456;

        int head = 0; // 首索引
        int end = arr.length - 1; // 尾索引
        boolean isFlag = true;

        while (head <= end){
            int middle = (head + end) / 2;

            if (arr[middle] == value){
                System.out.println("数据已找到，索引为：" + middle);
                isFlag = false;
                break;
            } else if (arr[middle] > value){
                end = middle - 1;
            } else { // arr[middle] < value
                head = middle + 1;
            }
        }

        if(isFlag) {
            System.out.println("很遗憾，数据不存在于指定数组中");
        }
    }
}
