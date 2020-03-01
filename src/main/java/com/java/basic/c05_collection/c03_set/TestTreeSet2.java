package com.java.basic.c05_collection.c03_set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 4、添加到一个集合中，要求不可重复，但是要求这次按照价格从低到高排序
 *      提示：TreeSet
 *
 *      因为在上一题中，默认实现按照销量从高到低，你们就不方便再次修改Book类的compareTo方法
 *      说明，Book类的自然排序规则，无法满足本题的要求。
 *
 *      要求：给TreeSet对象要多传一个"定制比较器对象"，即java.util.Comparator
 *
 *      Arrays.sort(arr)：按照元素的自希排序
 *      Arrays.sort(arr, 定制比较器对象)
 *
 *      TreeSet set = new TreeSet()：按照元素的自希排序
 *      TreeSet set = new TreeSet(定制比较器对象): 按照定制比较器排序
 */
public class TestTreeSet2 {
    public static void main(String[] args) {
//        TreeSet set = new TreeSet(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                Book b1 = (Book)o1;
//                Book b2 = (Book)o2;
//
//                /**
//                if (b1.getPrice() > b2.getPrice()){
//                    return 1;
//                } else if (b1.getPrice() < b2.getPrice()){
//                    return -1;
//                } else {
//                    return 0;
//                }*/
//                // 严格按照如下方式比较
//                //return Double.compare(b1.getPrice(), b2.getPrice());
//
//                long p1 = Double.doubleToLongBits(b1.getPrice());
//                long p2 = Double.doubleToLongBits(b2.getPrice());
//                return Long.compare(p1,p2);
//            }
//        });

        TreeSet set = new TreeSet((Object o1, Object o2) -> {
                Book b1 = (Book)o1;
                Book b2 = (Book)o2;

                // 严格按照如下方式比较
                return Double.compare(b1.getPrice(), b2.getPrice());
        });

        // Book cannot be cast to java.lang.Comparable
        set.add(new Book(1,"《从入门到精通》", "宋老师", 99.9, 1000));
        set.add(new Book(2,"《从入门到放弃》", "紫老师", 66.6, 2000));
        set.add(new Book(3,"《从精通到疯癫》", "孙老师", 88.8, 3000));

        for (Object object : set) {
            System.out.println(object);
        }
    }
}
