package com.java.basic.c02_object;

/**
 * 对象如何比较大小？
 * 不能直接使用>,<
 *
 * 而且不同的对象比较大小的规则不一样：
 *  例如：两个学生如何比较大小，可能按身高，可能按年龄，可能按照成绩比较
 *       两个圆对象如何比较大小，可能按照半径比较，可能按照面积比较
 *       两个员工对象如何比较大小，可能按照编号，可能按照薪资
 *
 * 我就可以为两个对象比较大小指定一个标准，接口
 * Java中确实提供了这样的接口：java.lang.Comparable
 *                          java.util.Comparator
 */
public class MyArrays {

    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("张三", 89);
        students[1] = new Student("李四", 56);
        students[2] = new Student("王五", 78);

        sort(students);

        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);

        }
    }

    // Object[] 类型的形参，可以接收任意类型的对象数组
    public static void sort(Object[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                // arr[j] 和arr[j+1]比较大小
                //if (arr[j].compareTo(arr[j+1]) > 0){   //if (arr[j] > arr[j+1]){
                Comparable pre = (Comparable)arr[j];
                if (pre.compareTo(arr[j+1]) > 0){  // 如果这个位置运行没有报错，说明arr[j]这个元素类型是实现了Comparable接口
                    Object temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // 用冒泡排序
    public static void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
