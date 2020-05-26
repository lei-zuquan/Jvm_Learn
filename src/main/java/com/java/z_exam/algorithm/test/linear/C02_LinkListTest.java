package com.java.z_exam.algorithm.test.linear;

import com.java.z_exam.algorithm.linear.C02_LinkList;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:01 上午 2020/5/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C02_LinkListTest {
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

        System.out.println(list.length());
        System.out.println("-------------------");

        //测试get方法
        System.out.println(list.get(2));
        System.out.println("------------------------");
        //测试remove方法
        String remove = list.remove(1);
        System.out.println(remove);
        System.out.println(list.length());
        System.out.println("----------------");;
        for (String s : list) {
            System.out.println(s);
        }

    }
}
