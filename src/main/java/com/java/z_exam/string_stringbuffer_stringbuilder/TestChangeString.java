package com.java.z_exam.string_stringbuffer_stringbuilder;

import java.lang.reflect.Field;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-03-31 9:28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class TestChangeString {

    public static void main(String[] args) throws Exception {
        // String 对象是否真的不可变？

        // 创建字符串“HelloWorld”,并赋给引用s
        String s = "HelloWorld";
        System.out.println("Before change: s = " + s);

        // 获取String类中的value字段
        Field valueFieldOfString = String.class.getDeclaredField("value");
        // 改变value属性的访问权限
        valueFieldOfString.setAccessible(true);

        // 获取s对象上的value属性的值
        char[] value = (char[]) valueFieldOfString.get(s);
        // 改变value所引用的数组中的第5个字符
        value[5] = '_';
        System.out.println("After change: s = " + s);
    }
}
