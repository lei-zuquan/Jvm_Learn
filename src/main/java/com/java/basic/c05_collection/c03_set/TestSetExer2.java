package com.java.basic.c05_collection.c03_set;

import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * 1、声明一个Book类型，有编号、书名、作者、价格、销量
 * 2、添加到一个集合中，要求不可重复，规定编号相同就认为是一本书
 *      提示：HashSet
 * 3、添加到一个集合中，要求不可重复，但是要求按照销量从高到低排序
 *      提示：TreeSet
 * 4、添加到一个集合中，要求不可重复，但是要求这次按照价格从低到高排序
 *      提示：TreeSet
 * 5、添加到一个集合中，要求不可重复，但是要求按照添加顺序显示
 *      提示：LinkedHashSet
 */
public class TestSetExer2 {
    public static void main(String[] args) {
        LinkedHashSet set = new LinkedHashSet();//要求放到TreeSet的元素必须实现java.lang.Comparable接口

        // Book cannot be cast to java.lang.Comparable
        set.add(new Book(1,"《从入门到精通》", "宋老师", 99.9, 1000));
        set.add(new Book(2,"《从入门到放弃》", "紫老师", 66.6, 2000));
        set.add(new Book(3,"《从精通到疯癫》", "孙老师", 88.8, 3000));
        set.add(new Book(3,"《从精通到疯癫》", "孙老师", 88.8, 3000));

        for (Object object : set) {
            System.out.println(object);
        }
    }
}
