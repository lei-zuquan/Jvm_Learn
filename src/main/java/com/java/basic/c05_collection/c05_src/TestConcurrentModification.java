package com.java.basic.c05_collection.c05_src;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:03 上午 2020/3/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * day22_05源码分析：foreach和Iterator迭代的并发问题
 *
 * Iterator迭代器和foreach遍历，多线程并发问题。
 *
 * 用迭代器或foreach遍历时，再用集合对象的remove方法时会报ConcurrentModificationException异常
 * 因为迭代器和集合两条线路同时操作元素。
 *
 * 在foreach或获取Iterator迭代器对象时，就会用expectedModCount 记录当前集合被修改的次数modCount的值。
 * expectedModCount = modCount;
 * 如果在迭代器或foreach遍历的过程中，发现expectedModCount != modCount，说明你用集合的add或remove等方法修改
 * 了当前集合的元素，就会报：ConcurrentModificationException异常
 *
 * 如果你用Iterator迭代器自己的删除方法的话，那么它会重新修改expectedModCount变量的值，保证与modCount的值一样
 *
 * 为了避免将来因为其他线程而修改了集合的元素，导致当前这个操作的数据不正确的风险，干脆快速失败，只有发现
 * expectedModCount != modCount，说明数据已经不是原来的数据，就快速失败。
 *
 * 旧版Enumration就不会快速失败，就有可能数据不一致性。
 */
public class TestConcurrentModification {

//    @SuppressWarnings("all")
//    public static void main(String[] args) {
//        ArrayList list = new ArrayList();
//
//        list.add("a1");
//        list.add("a2");
//        list.add("a3");
//        list.add("a4");
//
//        for (Object object : list){
//            list.remove(object);
//        }
//    }
    @SuppressWarnings("all")
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        list.add("a1");
        list.add("a2");
        list.add("a3");
        list.add("a4");

        Iterator iterator = list.iterator();

        while (iterator.hasNext()) {
            Object next = iterator.next();
            list.remove(next);
        }
    }
}
