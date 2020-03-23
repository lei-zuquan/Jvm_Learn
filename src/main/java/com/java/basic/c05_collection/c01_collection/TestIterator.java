package com.java.basic.c05_collection.c01_collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * java.util.Iterator迭代器类型：用于遍历（迭代）Collection集合用的
 *
 * 步骤：
 *      1、先通过Collection系列集合.对象拿到迭代器对象
 *      2、再通过Iterator的方法进行迭代
 *          boolean hasNext(): 判断集合中是否有下一个元素需要迭代
 *          Object next(): 取出下一个元素
 *          void remove() :删除刚刚迭代的元素，用于根据条件删除
 */
public class TestIterator {

    @Test
    public void test1(){
        Collection c = new ArrayList();
        c.add("zhangsan");
        c.add("lisi");
        c.add("wangwu");
        c.add("qianqi");

        // 1)先通过Collection系列集合.对象拿到迭代器对象
        Iterator iterator = c.iterator();

        // 2)再通过Iterator的方法进行迭代
        while (iterator.hasNext()){
            Object next = iterator.next(); // 判断集合中是否有下一个元素需要迭代
            System.out.println(next);
        }
    }

    @Test
    public void test2(){
        Collection c = new ArrayList();
        c.add(new Student(1, "zhangsan", 89));
        c.add(new Student(2, "lisi", 67));
        c.add(new Student(3, "wangwu", 90));
        c.add(new Student(4, "zhaoliu", 45));

        // 需求：要删除不及格的学生
        // 1)方法一：直接删除，不行
        // c.remove(o); // 通过Collection的remove() 不行
        // 2)方法二：用foreach，遍历，然后删除
//        for (Object object : c) {
//            Student stu = (Student)object;
//            if (stu.getScore() < 60){
//                c.remove(stu);
//            }
//        }
        // 3)方式三：用Iterator遍历删除
        Iterator iterator = c.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            Student stu = (Student)next;

            if (stu.getScore() < 60){
                iterator.remove(); // 调用迭代器的remove
            }
        }

    }
}

class Student {
    private int id;
    private String name;
    private int score;

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

