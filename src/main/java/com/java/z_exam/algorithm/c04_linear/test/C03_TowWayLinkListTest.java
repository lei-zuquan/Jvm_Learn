package com.java.z_exam.algorithm.c04_linear.test;

import com.java.z_exam.algorithm.c04_linear.C03_TowWayLinkList;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:37 上午 2020/5/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C03_TowWayLinkListTest {
    public static void main(String[] args) {
        C03_TowWayLinkList<String> list = new C03_TowWayLinkList<>();
        list.insert("乔峰");
        list.insert("虚竹");

        list.insert("段誉");
        list.insert(1,"鸠摩智");
        list.insert(3,"叶二娘");

        for (String str : list) {
            System.out.println(str);
        }

        System.out.println("----------------------");
        String tow = list.get(2);
        System.out.println(tow);
        System.out.println("-------------------------");
        String remove = list.remove(3);
        System.out.println(remove);
        System.out.println(list.length());
        System.out.println("--------------------");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }
}
