package com.java.basic.c05_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 1、定义员工类型：Employee，有属性姓名、薪资
 * 2、创建集合对象，并添加多个Employee对象到集合中
 *      自己测试其他Collection的方法
 * 3、用三种方式遍历集合
 */
public class TestCollectionExer1 {
    public static void main(String[] args) {
        Collection coll = new ArrayList();

        coll.add(new Employee("zhangsan", 12000));
        coll.add(new Employee("lisi", 13000));
        coll.add(new Employee("wangwu", 14000));

        /**
         * 1、判断是否包含
         * boolean flag = coll.contains("张三"); // "张三"字符串
         *
         * 对象的比较只有两种方式：（1）== （2）equals
         * 因为Employee没有重写equals，那么就相当于==
         *
         * 集合中的contains，remove等涉及到对象比较的方法，都是用对象的equals
         */

        boolean flag = coll.contains(new Employee("zhangsan",12000));
        System.out.println(flag);

        // (1)转为数组
        Object[] array = coll.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println();

        // (2)直接foreach
        for (Object object : array) {
            System.out.println(object);
        }
        System.out.println();

        // (3)Iterator
        Iterator iterator = coll.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
