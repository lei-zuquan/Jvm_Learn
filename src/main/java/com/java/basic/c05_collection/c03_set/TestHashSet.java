package com.java.basic.c05_collection.c03_set;

import java.util.HashSet;

/**
 *  2、添加到一个集合中，要求不可重复，规定编号相同就认为是一本书
 *       提示：HashSet
 *
 *       要重写Book类的hashCode和equals
 *       要求：
 *          1）必须一起重写
 *          2）hashCode值相同，不一定相同
 *              hashCode值不相同，equlas一定不相同
 *              equals相同，hashCode值一定相同
 *
 *           要求：参与hashCode值计算的属性，就要参数equals的比较
 *           3）equals方法的重写遵循几个原则
 *           对称性、自反性、传递性、一致性、非空与Null比较返回false
 *           参考：Object的equlas的API
 */
public class TestHashSet {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add(new Book(1,"《从入门到精通》", "宋老师", 99.9, 1000));
        set.add(new Book(2,"《从入门到放弃》", "紫老师", 66.6, 2000));
        set.add(new Book(3,"《从精通到疯癫》", "孙老师", 88.8, 3000));
        set.add(new Book(3,"《从精通到成魔》", "孙老师", 88.8, 3000));

        for (Object object : set) {
            System.out.println(object);
        }
    }
}
