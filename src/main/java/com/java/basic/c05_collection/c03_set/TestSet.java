package com.java.basic.c05_collection.c03_set;

import org.junit.Test;

import java.util.*;

/**
 * java.util.Set：接口，是Collection的子接口。
 *      1）不支持重复
 *      2）无序的
 *
 * Set没有增加方法，都是Collection接口的方法。
 *
 * Set:
 *      1) HashSet：完全无序（效率最高）
 *              如何保证两个元素不重复？依据元素的equals方法
 *      2) TreeSet：大小顺序，和添加顺序无关
 *              如何保证两个元素不重复？依据元素的"大小"顺序
 *      3) LinkedHashSet：遍历时可以保证添加顺序，存储和添加顺序无关
 *              LinkedHashSet是HashSet的子类，但是它的元素比HashSet的元素要多维护一个添加顺序。
 *              LinkedHashSet的效率就比HashSet低，每次添加、删除、要同时考虑顺序。
 *              LinkedHashSet和HashSet一样依据equals，决定是否重复
 * 结论：
 *      如果既要元素不重复，又要按大小，选TreeSet
 *      如果既要元素不重复，又要保证添加顺序，选LinkedHashSet
 *      如果既要元素不重复，选择HashSet
 *
 */
public class TestSet {
    @Test
    public void test6(){
        Set set = new HashSet<>();

        // 判断两个元素是否重复的依据：equals，如果Student没有重写equals，那么就是按照地址
        set.add(new Student(2, "张三", 89));
        set.add(new Student(1, "李四", 99));
        set.add(new Student(3, "王五", 78));
        set.add(new Student(4, "赵六", 56));
        set.add(new Student(2, "张三", 89));
        set.add(new Student(1, "李四", 99));
        set.add(new Student(3, "王五", 78));
        set.add(new Student(4, "赵六", 56));

        for (Object object : set) {
            System.out.println(object);
        }
    }
    @Test
    public void test5(){
        Set set = new HashSet<>();

        set.add("张三");
        set.add("李四");
        set.add("王五");
        set.add("赵六");
        set.add("张三");
        set.add("李四");
        set.add("王五");
        set.add("赵六");

        for (Object object : set) {
            System.out.println(object);
        }
    }
    @Test
    public void test4(){
        Set set = new LinkedHashSet<>();

        set.add(new Student(2, "张三", 89));
        set.add(new Student(1, "李四", 99));
        set.add(new Student(3, "王五", 78));
        set.add(new Student(4, "赵六", 56));


        for (Object object : set) {
            System.out.println(object);
        }
    }
    @Test
    public void test3(){
        Set set = new TreeSet<>();

        set.add(new Student(2, "张三", 89));// 如果成功，要实现java.lang.Comparable
        set.add(new Student(1, "李四", 99));
        set.add(new Student(3, "王五", 78));
        set.add(new Student(4, "赵六", 56));
        set.add(new Student(4, "赵六", 56));//TreeeSet判断是否重复元素的依据，而是这两个对象的大小是否相等


        for (Object object : set) {
            System.out.println(object);
        }
    }
    @Test
    public void test2(){
        Set set = new TreeSet<>();

        set.add("zhangsan"); // String 类型实现了java.lang.Comparable
        set.add("lisi");
        set.add("wangwu");
        set.add("zhaoliu");

        for (Object object : set) {
            System.out.println(object);
        }
    }
    @Test
    public void test(){
        Set set = new HashSet<>();

        set.add("张三");
        set.add("李四");
        set.add("王五");
        set.add("赵六");

        for (Object object : set) {
            System.out.println(object);
        }
    }
}


class Student implements Comparable{
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


    @Override
    public int compareTo(Object o) {
        Student stu = (Student)o;
        return this.id - stu.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                score == student.score &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, score);
    }
}