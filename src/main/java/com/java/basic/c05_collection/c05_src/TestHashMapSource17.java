package com.java.basic.c05_collection.c05_src;

import org.junit.Test;

import java.util.HashMap;
import java.util.Set;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:13 上午 2020/3/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * day22_08源码分析：JDK1.7的HashMap
 *
 * JDK1.7 以及之前：HashMap的底层实现是数组 + 链表
 *
 * 1、数组的类型
 * 2、为什么有链表
 * 3、数组的初始化的长度是多少
 * 初始化长度默认为16
 * 如果手动指定，那么也必须是2的n次方，如果不是会自动纠正为2的n次方
 *
 * 4、数组是否会扩容
 * 会
 *
 * 为什么要扩容？因为如果不扩容，会导致链表会变得很长，那么它的查询效率，添加的效率整体会降低
 *
 * 什么情况下会扩容？
 * 有一个变量threshold阈值来判断是否需要扩容，
 *      当这个threshold达到临界值时，就会考虑扩容，还要看当前添加(key, value)时，是否table[index]==null
 *      如果table[index] != null，那么就会扩容，如果table[index] == null，那么本次先不扩容。
 *
 * DEFAULT_LOAD_FACTOR：默认加载因子0.75
 * threshold = table.length * 0.75
 * 第一次：16 * 0.75 = 12，当我们size达到12个，就会考虑扩容。
 *
 *
 * 5、index如何计算
 * 拿到一个key的hash值后，如何计算[index]
 *      1）key是null，固定位置[index] = [0]
 *      2）第一步，先用hashCode值通过hash(key)函数得到一个比较分散的"hash值"
 *         第二步，再根据 "hash值" 与 table.length 做运算得到index
 *                  hash & table.length - 1 按位与 确保index在[0, length - 1]范围内
 *
 * 6、如何避免key不可重复的
 *      换句话说，如果key重复了，会怎么办？
 *
 *      如果key相同，那么我们会替换旧的value
 *      key相同，先判断hash值，如果hash值相同，判断key的地址或equals是否相等。
 *
 * 7、新的（key, value）添加到table[index] 后，发现table[index]不为空，怎么连接的
 *      (key, value)是作为table[index]的头，原来下面的元素作为我的next。
 */
public class TestHashMapSource17 {

    @Test
    public void test4() {
        HashMap map = new HashMap();

        map.put(1, "11");
        map.put(1, "22");

        Set entrySet = map.entrySet();
        for (Object object: entrySet){
            System.out.println(object);
        }
    }
    @Test
    public void test1(){
        HashMap map = new HashMap();

        map.put(1, "11");
        map.put(2, "22");
        map.put(3, "33");
        map.put(4, "44");
        map.put(5, "44");
        map.put(6, "44");
        map.put(7, "44");
        map.put(8, "44");
        map.put(9, "44");
        map.put(10, "44");
        map.put(11, "44");
        map.put(12, "44");
        map.put(13, "44");
    }
    @Test
    public void test2(){
        HashMap map = new HashMap();

        map.put("哈哈", 1);
        map.put("嘻嘻", 2);
        map.put("呵呵", 3);
        map.put("嘿嘿", 4);
        map.put("xx", 5);
        map.put("yy",   6);
        map.put("呜呜", 7);
        map.put("啦啦", 8);
        map.put("么么", 9);
        map.put("哒哒", 10);
        map.put("嘎嘎", 11);
        map.put("啪啪", 12);
        map.put("滴滴", 13);
    }
}
