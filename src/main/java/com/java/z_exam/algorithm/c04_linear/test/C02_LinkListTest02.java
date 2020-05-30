package com.java.z_exam.algorithm.c04_linear.test;

import com.java.z_exam.algorithm.c04_linear.C02_LinkList;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:01 上午 2020/5/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C02_LinkListTest02 {
    public static void main(String[] args) {
        C02_LinkList<String> list = new C02_LinkList<>();
        list.insert(0,"张三");
        list.insert(1,"李四");
        list.insert(2,"王五");
        list.insert(3,"赵六");
        //测试length方法
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("-------------------");

        //测试get方法
        list.reverse();

        for (String s : list) {
            System.out.println(s);
        }

    }
}
