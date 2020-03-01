package com.java.basic.c02_object;

/**
 * 希望学生类的对象，可以比较大小，遵循对象比较大小的标准。
 * 让学生类实现java.lang.Comparable接口
 *
 * java.lang.Comparable接口中有一个抽象方法：int compareTo(T o)
 */
public class Student implements Comparable{

    private String name;
    private int score;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student() {
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

    /**
     * 假设这里要求学生按照成绩比较大小
     * 比较两个学生对象：this 和 obj
     * 如果this对象"大于" obj对象，那么返回正整数
     * 如果this对象"小于" obj对象，那么返回负整数
     * 如果this对象"等于" obj对象，那么返回0
     *
     */
    @Override
    public int compareTo(Object obj) {
        if (!(obj instanceof Student)) {
            // 不能比较大小，应该是抛出异常，这里先提示
            System.out.println("obj不是学生对象");
            return 0; // 按理说返回0不合适
        }

        Student stu = (Student)obj;
        if (this.score > stu.score){
            return 1; // 正整数
        } else if (this.score < stu.score){
            return -1; // 负整数
        }

        return 0;
    }
}
