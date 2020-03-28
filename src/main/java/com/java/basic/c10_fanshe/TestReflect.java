package com.java.basic.c10_fanshe;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:54 下午 2020/3/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import org.junit.Test;

/**
 * day27_07反射的概述
 *
 * Java是强类型语言，静态语言。在编译时能对数据类型进行编译检查
 *
 * 反射：在运行时可以获取类的信息，对类进行操作，而且该类可能是在编译时完全未知的类型。使得Java具有动态语言的特征。
 *      原来从类 -》 对象
 *      现在从这个类Class对象 -> 操作类的所有的...
 *
 *      人为的给大家取个新名称来对比反射，叫正射
 *      我们之前写代码的方工就是正射
 *      步骤：
 *          （1）先写类
 *          （2）用类创建对象
 *          （3）通过对象操作...
 *
 *      反射：有很多种
 *      其中一种，例如：tomcat，hibernate,spring,mybatis等各种框架
 *          （1）先创建对象        --》框架
 *          （2）通过对象操作       --》框架
 *          （3）再写类              --》我们写，然后通过xml等文件告知框架我的类名是什么
 *
 *      第二种：
 *          （1）先写类
 *          （2）通过四种方式之前，获取取该类的Class对象
 *          （3）用Class对象创建，这个类的对象
 *          （4）再通过Class对象操作...
 *
 *
 *
 */
public class TestReflect {

    @Test
    public void test1() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //Student1 stu = new Student1("tt", 10);
        // (2) 通过四种方式之前，获取到该类的Class对象
        //Class<?> clazz = Class.forName("com.java.basic.c10_fanshe.Student1");
        Class<?> clazz = Class.forName("java.lang.String");

        // (3) 用Class对象创建 这个类Student1的对象
        // 因为clazz就是Student1类型
        Object obj = clazz.newInstance();

        System.out.println(obj);
    }
}

class Student1 {
    private String name;
    private int age;

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
