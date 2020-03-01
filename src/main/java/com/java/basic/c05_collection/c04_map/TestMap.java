package com.java.basic.c05_collection.c04_map;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * java.util.Map:
 *      和Collection最大的不同，就是它存储"键值对，映射关系"
 *
 * 常用方法：
 *      1、添加
 *          put(key,value): 一次添加一对映射关系
 *          putAll(Map map): 一次添加多对映射关系
 *      2、删除
 *          remove(Object key): 根据key删除一对
 *          clear()清空
 *      3、修改
 *          通过put可以替换value,只要key相同，就替换
 *      4、查询
 *          1）containsKey(Object key): 判断某个key是否存在
 *          2）containsValue(Object value):判断某个value是否存在
 *          3) V get(Object key):根据key获取value
 *          4) boolean isEmpty(): 是否为空
 *
 *      5、获取映射关系，键值对数：int size()
 *
 *      6、遍历
 *          1）Set keySet()
 *          2）Collection values()
 *          3）Set entrySet(): 由entry对象构成的set，因为key不重复，那么entry对象也不会重复
 *
 *
 * 例如：存储男同学和他们的女朋友们
 *
 *
 */
public class TestMap {

    @Test
    public void test6(){
        Map map = new HashMap<>();

        map.put("胡利民", "卢明珠");
        map.put("曹阳", null);
        map.put("张武林", new String[]{"陈豹","刘俊峰"});
        map.put("吕宏生", new String[]{"陈豹","刘俊峰"});

        Set entrySet = map.entrySet();
        for (Object entry : entrySet) {
            System.out.println(entry);
        }
    }
    @Test
    public void test5(){
        Map map = new HashMap<>();

        map.put("胡利民", "卢明珠");
        map.put("曹阳", null);
        map.put("张武林", new String[]{"陈豹","刘俊峰"});
        map.put("吕宏生", new String[]{"陈豹","刘俊峰"});

        Collection values = map.values();
        for (Object value : values) {
            System.out.println(value);
        }
    }

    @Test
    public void test4(){
        Map map = new HashMap<>();

        map.put("胡利民", "卢明珠");
        map.put("曹阳", null);
        map.put("张武林", new String[]{"陈豹","刘俊峰"});

        Set keySet = map.keySet();//因为map的key不能重复，所以拿出所有的key，就是一个set
        for (Object key : keySet) {
            System.out.println(key);
        }
    }
    @Test
    public void test3(){
        Map map = new HashMap<>();

        map.put("张三", "如花");
        map.put("张三", "芙蓉");

        System.out.println("对数" + map.size());
    }
    @Test
    public void test2(){
        Map map = new HashMap<>();

        map.put("胡利民", "卢明珠");
        map.put("曹阳", null);
        map.put("张武林", new String[]{"陈豹","刘俊峰"});


        map.remove("曹阳");
        System.out.println(map);
    }
    @Test
    public void test(){
        Map map = new HashMap<>();

        map.put("胡利民", "卢明珠");
        map.put("曹阳", null);
        map.put("张武林", new String[]{"陈豹","刘俊峰"});

        System.out.println(map);
    }
}
