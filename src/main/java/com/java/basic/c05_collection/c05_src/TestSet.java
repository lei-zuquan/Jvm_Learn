package com.java.basic.c05_collection.c05_src;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:23 上午 2020/3/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

/**
 * day22_03源码分析：Set的内部实现
 *
 * Set的底层实现，内部实现：
 *
 * HashSet: 内部实现是HashMap
 *      添加（add）到HashSet的元素是作为HashMap的Key，所有的value共享一个Object类型的常量对象PRESENT
 * LinkedHashSet
 *      添加（add）到LinkedHashSet的元素是作为LinkedHashSet的Key，所有的value共享一个Object类型的常量对象PRESENT
 * TreeSet
 *      添加（add）到TreeSet的元素是作为TreeMap的Key，所有的value共享一个Object类型的常量对象PRESENT
 */
public class TestSet {

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("zhangsan");

        LinkedHashSet lset = new LinkedHashSet();
        lset.add("zhangSan");

        TreeSet tree = new TreeSet();
        tree.add("zhangsan");
    }
}
