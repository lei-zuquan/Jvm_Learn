package com.java.basic.c06_generic.collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:40 下午 2020/3/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * day23_05集合工具类：java.util.Collections
 *
 * 数组的工具类：java.util.Arrays
 * 集合的工具类：java.util.Collections
 *
 *      1)
 *      public static <T> boolean addAll(Collection<? super T> c, T... elements)
 *      作用：添加elements这些对象到c这个集合中。
 *
 *      2)
 *      public static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key)
 *      作用：在list集合中查找key的索引
 *      因为只有List系列的集合才有索引信息，所以这里用List作为形参类型
 *      因为List本身是不支持大小排序，所以List的泛型要支持比较大小
 *      binarySearch：二分查找法，要求数组或集合必须有序的
 *
 *      3)
 *      public static boolean disjoint(Collection<?> c1, Collection<?> c2)
 *      作用：判断两个集合是否完全相同
 *
 *      4)
 *      public static <T extends Object & Comparable<? super T>> T max(Collection<? extends T> coll)
 *      作用：找coll中最大值
 *
 *      问？<T extends Object & Comparable<? super T>> 这里为什么要写Object，因为当擦除后，为了按照Object处理，使得返回值类型T，按照Object与老版本保持一致。
 *
 *
 */

class Graphic implements Comparable<Graphic>{
    @Override
    public int compareTo(Graphic o) {
        return 0;
    }
}

class Circle extends Graphic{

}

public class TestCollections {

    @Test
    public void test5(){
        List<Circle> list = new ArrayList<>();
        // ...
        Circle max = Collections.max(list);
    }
    @Test
    public void test4() {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("hello");
        list.add("world");

        String max = Collections.max(list);
        System.out.println(max);
    }

    @Test
    public void test3() {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("hello");
        list.add("world");

        /**
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(3); */

        List<String> list2 = new ArrayList<>();
        list2.add("abc");
        list2.add("hello");
        list2.add("world");
        list2.add("java");

        boolean b = Collections.disjoint(list, list2);
        System.out.println(b);

    }

    @Test
    public void test2(){
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("hello");
        list.add("world");

        int index = Collections.binarySearch(list, "hello");
        System.out.println(index);
    }

    @Test
    public void test1(){
        Collection<String> c = new ArrayList<>();
        Collection<Object> c1 = new ArrayList<>();
        Collections.addAll(c, "hello", "java", "world");
        Collections.addAll(c1, "hello", "java", "world");

    }
}
