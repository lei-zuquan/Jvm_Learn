package com.java.basic.c03_lambda_expression.exer;

import org.junit.Test;

import java.util.TreeSet;

/**
 * 3、EnglistStudent类型：学号、姓名（用英文名）、成绩，
 *      默认排序是按照学号排序，        ---> 该类需要实现java.lang.Comparable
 *      1）使用TreeSet保存本组学员的对象（Student）,用forEach(Consumer c)方法遍历显示
 *      2）使用TreeSet(Comparator)保存本组学员的对象（Student）,
 *      要求按照姓名排序，不区区大小写，再用forEach(Consumer c) 方法遍历显示
 */
public class TestExer3 {

    @Test
    public void test1(){
        /**
         * Comparator<T> : int compare(T t1, T t2)
         */
        //TreeSet<EnglishStudent> set1 = new TreeSet<>();
        TreeSet<EnglishStudent> set1 = new TreeSet<>((t1, t2) -> t1.getName().compareToIgnoreCase(t2.getName()));

        set1.add(new EnglishStudent(2,"tom", 67));
        set1.add(new EnglishStudent(1,"jack", 89));
        set1.add(new EnglishStudent(3,"anne", 89));

        /**
         * Consumer: void xxx(T t)
         *
         */

        set1.forEach(t -> System.out.println(t));
    }

    // 假设按成绩比较
    @Test
    public void test3(){
        /**
         * Comparator<T> : int compare(T t1, T t2)
         *
         * TreeSet不可重复的依据，不是hashCode和equals，而是看比较大小的方法，它会认为"大小相等"的就是相同元素
         *
         * 成绩相同，再按学号排序
         */
        //TreeSet<EnglishStudent> set1 = new TreeSet<>();
        TreeSet<EnglishStudent> set1 = new TreeSet<>((t1, t2) -> t1.getScore() == t2.getScore()? t1.getId() -t2.getId(): t1.getScore() - t2.getScore());

        set1.add(new EnglishStudent(2,"tom", 67));
        set1.add(new EnglishStudent(3,"jack", 89));
        set1.add(new EnglishStudent(1,"anne", 89));

        /**
         * Consumer: void xxx(T t)
         *
         */

        set1.forEach(t -> System.out.println(t));
    }
}
