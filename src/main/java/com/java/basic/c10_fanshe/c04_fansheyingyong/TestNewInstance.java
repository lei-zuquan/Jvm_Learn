package com.java.basic.c10_fanshe.c04_fansheyingyong;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:53 上午 2020/3/29
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * day27_10使用Class对象和构造器对象创建对象
 *
 * 二、在运行期间，动态的创建任意类型的对象，只要这个类型可以创建对象
 *      1、Class对象.newInstance()
 *          前提：这个类型必须有无参构造【自己编写的类，尽量保持无参构造；因为很多框架都是会有无参构造】
 *          步骤：
 *              （1）获取Class对象
 *              （2）直接调用Class对象.newInstance()
 *
 *      2、构造器来创建对象
 *          步骤：
 *              （1）获取Class对象
 *              （2）获取构造器对象，获取其中一个
 *              Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
 *                      parameterTypes: 构造器形的类型列表
 *
 *          构造器可以重载，有很多个，如何确定要哪一个？
 *              通过形参列表
 *              （3）用构造器创建对象
 *                  java.lang.reflect.Constructor类型中：
 *                      T newInstance(Object... initargs)
 *                          initargs: 创建对象时，给构造器的实参列表
 *
 */
public class TestNewInstance {
    @Test
    public void test2() throws Exception{
        // 1、获取Class对象
        Class<?> clazz = Class.forName("com.lei.java.Student");

        // 2、获取构造器对象
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
        // Constructor代表 public Student(String name){} 构造器

        // 3、用构造器创建对象
        Object obj = constructor.newInstance("张三"); // 等价于new Student("zhangsan")

        System.out.println(obj);
    }

    @Test
    public void test1() throws Exception{
        // 1、获取Class对象
        Class<?> clazz = Class.forName("com.lei.java.Student");

        // 2、创建Student的对象
        // clazz代表类型，虽然它本身是Class的对象，但是它是代表类型
        Object obj = clazz.newInstance();
        System.out.println(obj);
    }
}
