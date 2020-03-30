package com.java.z_exam.jvm;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:46 下午 2020/3/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class MyMath {

    public static int initData = 666;
    public static User user = new User();

    public int compute(){ // 一个方法对应一块栈帧内存区域
        int a = 1;
        int b = 2;
        int c = (a+b) * 10;
        return c;
    }

    public static void main(String[] args) {
        MyMath math = new MyMath();
        math.compute();
    }
}

class User{
//    private String name;
//    private int age;
//
//    public User() {
//    }
//
//    public User(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
}