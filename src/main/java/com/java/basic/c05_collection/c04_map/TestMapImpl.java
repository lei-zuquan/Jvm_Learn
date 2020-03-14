package com.java.basic.c05_collection.c04_map;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * Map的实现类们：
 *      1、HashMap：哈希表
 *      2、Hashtable：哈希表
 *      3、LinkedHashMap:
 *              它是HashMap的子类，比HashMap多维护了添加的顺序。
 *      4、TreeMap：映射关系的顺序会按照key的"大小"顺序排列
 *              要求：映射关系的key，必须支持排序，即实现java.lang.Comparable接口，或者单独为TreeMap指定定制比较器对象。
 *      5、Properties:
 *              1) Properties是Hashtable的子类
 *              2) Properties的key和value的类型是String
 *
 * 面试题：Hashtable与HashMap的区别
 * Hashtable: 最古老，线程安全的，它的key和value不允许为null
 * HashMap: 相对新，线程不安全，它的key和value都允许为null
 *
 *
 * 类同：
 *      StringBuffer与StringBuilder
 *      Vector与ArrayList
 */
public class TestMapImpl {

    @Test
    public void test1(){
        // 获取系统属性
        Properties properties = System.getProperties();

        Set entrySet = properties.entrySet();
        for (Object property : entrySet) {
            System.out.println(property);
        }
    }

    @Test
    public void test6(){
        Map map = new LinkedHashMap();

        map.put("胡利民", "卢明珠");
        map.put("曹阳", null);
        map.put("张武林", new String[]{"陈豹","刘俊峰"});
        map.put("吕宏生", new String[]{"陈豹","刘俊峰"});

        Set entrySet = map.entrySet();
        for (Object entry : entrySet) {
            System.out.println(entry);
        }
    }
}
