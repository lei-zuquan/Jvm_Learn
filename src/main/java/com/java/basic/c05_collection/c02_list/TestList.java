package com.java.basic.c05_collection.c02_list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * java.util.List: 接口
 *      1）有序：可以对元素的索引index，进行控制。
 *      2）可重复。
 *
 * 常用方法：
 *      继承了Collection，因此，刚才学习的Collection的所有方法和操作它都有
 *      List还增加了很多方法，这些方法都和Index相关
 *
 *      1、添加
 *          add(int index, E element): 在index位置插入一个元素
 *          addAll(int index, Collection<? extends E> c): 在index位置插入多个元素
 *      2、删除
 *          remove(int index)
 *      3、改
 *          刚才Collection根接口没有提供修改的方法
 *          set(int index, E element)
 *      4、查
 *          int indexOf(Object o): 从前往后
 *          int lastIndexOf(Object o): 从后往前
 *          get(int index): 返回index位置的元素
 *          subList(int fromIndex, int toIndex): 截取[fromIndex, toIndex]
 *      5、遍历
 *          1.toArray
 *          2.foreach
 *          3.Iterator
 *          4.ListIterator
 *              ListIterator是Iterator的子接口，Iterator有的，ListIterator也有，还增加：
 *              A: Iterator只能从前往后遍历
 *              ListIterator可以从任意位置开始，从前往后，或从后往前遍历
 *
 *              ListIterator的使用步骤：
 *              第一步：先获取ListIterator的对象
 *                      集合对象.listIterator()
 *              第二步：通过遍历方法
 *                      hasNext() + next()
 *                      hasPrevious() + previous()
 *              B.不难可以在遍历时删除了，还增加了set和add方法
 *
 */
public class TestList {

    @Test
    public void test5(){
        List list = new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        list.add("zhaoliu");
        list.add("qianqi");
        list.add("wangba");

        // 从前往后
        ListIterator listIterator = list.listIterator(); // 默认迭代器指向最前面
        while (listIterator.hasNext()){
            Object next = listIterator.next();
            System.out.println(next);
        }
        System.out.println();

        // 从后往前
        listIterator= list.listIterator(list.size()); // 要让迭代器先指到最后
        while (listIterator.hasPrevious()){
            Object previous = listIterator.previous();
            System.out.println(previous);
        }
        System.out.println();

        // 从任意位置往前
        listIterator= list.listIterator(3);
        while (listIterator.hasPrevious()){
            Object previous = listIterator.previous();
            System.out.println(previous);
        }
    }

    @Test
    public void test4(){
        List list = new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");

        int index = list.indexOf("zhangsan");
        System.out.println(index);
    }
    @Test
    public void test3(){
        List list = new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");

        list.set(0,"caoyang");
        for (Object object : list) {
            System.out.println(object);
        }
    }
    @Test
    public void test2(){
        List list = new ArrayList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");

        list.remove(0);
        for (Object object : list) {
            System.out.println(object);
        }
    }
    @Test
    public void test1(){
        List list = new ArrayList<>();
        list.add("zhangsan");
        list.add(0, "lisi");

        for (Object object : list) {
            System.out.println(object);
        }
    }
}
