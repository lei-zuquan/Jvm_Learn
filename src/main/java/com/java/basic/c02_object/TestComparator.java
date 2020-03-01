package com.java.basic.c02_object;

import java.util.Arrays;
import java.util.Comparator;

public class TestComparator {
    public static void main(String[] args) {
        Student[] arr = new Student[3];
        arr[0] = new Student("王小二", 89);
        arr[1] = new Student("张三", 87);
        arr[2] = new Student("李四", 56);

        // 在Arrays的类中
        // public static <T> void sort(T[] a, Comparator<? super T> c)
        Arrays.sort(arr, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                Student s1 = (Student)o1;
                Student s2 = (Student)o2;
                return s1.getScore() - s2.getScore();
            }
        });

        System.out.println(Arrays.toString(arr));
    }
}
