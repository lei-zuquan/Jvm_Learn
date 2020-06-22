package com.java.z_exam.algorithm.c02_sort.sort_with_design;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-22 15:06
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T00_Student implements Comparable<T00_Student> {

    private String userName;
    private int age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "T00_Student{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(T00_Student o) {
        return this.getAge() - o.getAge();
    }

    public static void main(String[] args) {
        T00_Student stu1 = new T00_Student();
        stu1.setUserName("zhangSan");
        stu1.setAge(17);

        T00_Student stu2 = new T00_Student();
        stu2.setUserName("lisi");
        stu2.setAge(19);

        Comparable max = getMax(stu1, stu2);
        System.out.println(max);
    }

    // 测试方法，获取两个元素中的较大值
    public static Comparable getMax(Comparable c1, Comparable c2) {
        int cmp = c1.compareTo(c2);
        if (cmp >= 0) {
            return c1;
        } else {
            return c2;
        }
    }
}
