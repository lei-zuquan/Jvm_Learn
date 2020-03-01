package com.java.basic.c04_data;

public class TestSingleList {
    public static void main(String[] args) {
        // 1、创建容器
        MySingleList my = new MySingleList();

        // 2、添加元素
        my.add("zhangsan");
        my.add("lisi");
        my.add("wangwu");
        my.add("zhaoliu");

        // 3、元素个数
        System.out.println(my.size());

        // 4、遍历
        Object[] array = my.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        System.out.println();

        // 5、删除
        my.remove("zhangsan");
        array = my.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println();

        my.remove("wangwu");
        array = my.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println();
    }
}
