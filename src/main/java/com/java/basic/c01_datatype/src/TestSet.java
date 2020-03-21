package com.java.basic.c01_datatype.src;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:24 上午 2020/3/14
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
 * Set的底层实现，内部实现：
 *
 * HashSet: 内部实现是HashMap
 *      添加（add）到HashSet的元素是作为HashMap的key, 所有的value共享一个Object类型的常量对歇脚PRESENT
 * LinkedHashSet: 内部实现是LinkedHashMap
 *      添加（add) 到LinkedHashSet的元素是作为LinkedHashMap的key，所有的value共享同一个Object类型的常量对象PRESENT
 * TreeSet: 内部实现是TreeMap
 *      添加（add）到TreeSet的元素是作为TreeMap的key，所有的value共享同一个Object类型的常量对象PRESENT
 *
 */
public class TestSet {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add("张三");

        LinkedHashSet lset = new LinkedHashSet();
        lset.add("李四");

        TreeSet tree = new TreeSet();
        tree.add("王五");
    }
}



























