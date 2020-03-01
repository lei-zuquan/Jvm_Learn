package com.java.basic.c05_collection.c03_set;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * 3、添加到一个集合中，要求不可重复，但是要求按照销量从高到低排序
 *      提示：TreeSet
 *
 *      要求：Book类型实现java.lang.Comparable接口
 */
public class TestTreeSet1 {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();//要求放到TreeSet的元素必须实现java.lang.Comparable接口

        // Book cannot be cast to java.lang.Comparable
        set.add(new Book(1,"《从入门到精通》", "宋老师", 99.9, 1000));
        set.add(new Book(2,"《从入门到放弃》", "紫老师", 66.6, 2000));
        set.add(new Book(3,"《从精通到疯癫》", "孙老师", 88.8, 3000));

        for (Object object : set) {
            System.out.println(object);
        }
    }
}
