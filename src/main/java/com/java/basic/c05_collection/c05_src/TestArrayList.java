package com.java.basic.c05_collection.c05_src;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:29 上午 2020/3/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import java.util.ArrayList;

/**
 * day22_06源码分析：ArrayList动态数组
 *
 * 内部实现：数组
 *
 * 1、初始化大小：10
 * 如果JDK1.8时 new ArrayList()，发现数组初始化为一个DEFAULTCAPACITY_EMPTY_ELEMENTDATA，长度为0的空数组
 * 如果JDK1.6时 new ArrayList()，发现数组初始化为一个长度为10的Object[]
 * 如果JDK1.7时 new ArrayList()，发现数组初始化为一个EMPTY_ELEMENTDATA, 长度为0的空数组；
 *
 * 2、添加元素时，如果数组满了，如何扩容
 * 扩容为1.5倍
 *
 * JDK1.7和JDK1.8时，因为一开始是空数组，那么第一次扩展的长度为10的数组。
 * 然后不够了，再扩为原来的1.5倍
 *
 * 3、删除元素时，数组会不会缩小呢？
 * 不会
 * 但是像ArrayList有一个trimToSize() 可以调整大小
 *
 */
public class TestArrayList {
    public void test18(){ // 测试JDK 1.8版本
        ArrayList list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("10");

        list.remove("1");
    }
}
