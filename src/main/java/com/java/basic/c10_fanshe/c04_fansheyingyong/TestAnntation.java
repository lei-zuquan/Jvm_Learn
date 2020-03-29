package com.java.basic.c10_fanshe.c04_fansheyingyong;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 1:01 下午 2020/3/29
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * day27_14使用Class对象获取注解
 *
 * 获取注解信息（一些框架能过获取注解信息进行反射应用）
 *
 * 注解分为三个部分：
 *      1、声明
 *      2、使用
 *      3、读取
 *          要使得注妥在反射阶段被读取到，必须保证该注解可以滞留到运行时
 *
 *          反射阶段：运行时
 *
 */
public class TestAnntation {
    public static void main(String[] args) {
        // 读取MyClass类型上的注解
        // (1)获取MyClass的Class对象
        Class<?> clazz = MyClass.class;

        // (2)获取MyClass类型上的注解
        MyAnntation my = clazz.getAnnotation(MyAnntation.class);

        // (3)获取注解的配置参数的值
        String str = my.value(); // 把value当做方法一样调用
        System.out.println(str);
    }
}

// 使用注解
@MyAnntation("lei")
class MyClass{

}

// 声明注解
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnntation{
    String value();
}
