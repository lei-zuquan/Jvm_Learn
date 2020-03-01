package com.java.basic.c04_data;

public class TestMyArrayList {
    public static void main(String[] args) {
        // 1、创建一个容器
        MyArrayList my = new MyArrayList();

        // 2、可以装对象
        my.add("zhangsan");
        my.add("lisi"); // null也可以是一个有效元素
        my.add(null);
        my.add("wangwu");

        // 3、查看有几个元素
        System.out.println(my.size());

        // 4、遍历元素
        Object[] all = my.toArray();
        for (int i = 0; i < all.length; i++) {
            System.out.println(all[i]);
        }

        // 5、获取index位置的元素
        Object object = my.get(0);
        System.out.println(object);

        // 6、查找李四的位置
        int index = my.indexOf(null);
        System.out.println(index);
    }
}
