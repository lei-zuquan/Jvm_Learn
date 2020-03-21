package com.java.basic.c06_generic;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 5:59 下午 2020/3/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import java.util.ArrayList;
import java.util.Iterator;

/**
 * day22_13泛型练习（1）
 *
 * 1、练习1：
 *      把本组学员的姓名（String）存储到一个ArrayList中，并且用foreach和Iterator分别遍历
 *
 * JDK1.7之前：
 *      ArrayList<String> list = new ArrayList<String>();
 * JDK1.7之后：
 *      ArrayList<String> list = new ArrayList<>();
 *
 */
public class TextExer1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        list.add("zhang");
        list.add("li");
        list.add("lei");

        for (String name : list) {
            System.out.println(name);
        }

        System.out.println();

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String name = iterator.next();
            System.out.println(name);
        }
    }
}
