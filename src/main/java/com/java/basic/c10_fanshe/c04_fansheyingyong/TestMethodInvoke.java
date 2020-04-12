package com.java.basic.c10_fanshe.c04_fansheyingyong;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:12 上午 2020/3/29
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * day27_12使用Class对象调用方法
 *
 * 四、在运行期间，动态的调用任意对象的任意方法
 * 步骤：
 *      1、获取Class对象
 *      2、获取Method对象
 *
 *      方法有重载，如何确定是哪个方法？方法名 + 形参列表
 *          clazz.getDeclaredMethod(name, parameterTypes)
 *      3、创建实例对象
 *      4、调用方法
 *
 */
public class TestMethodInvoke {


    @Test
    public void test2() throws Exception {
        // 1、获取Class对象
        Class<?> clazz = Class.forName("com.lei.java.Student");

        /**
         * 调用Student类的public static void test(int a) 方法
         */
        // 2、获取Method对象
        Method m = clazz.getDeclaredMethod("test", int.class);

        // 3、调用方法
        m.invoke(null, 10); // 如果是静态方法，实例对象可以用Null代替
    }

    @Test
    public void test1() throws Exception {
        // 1、获取Class对象
        Class<?> clazz = Class.forName("com.lei.java.Student");

        // 2、获取Method对象
        // method代表 public void setName(String name) {...}
        Method method = clazz.getDeclaredMethod("setName", String.class);

        // 3、创建实例对象
        Object stu = clazz.newInstance();

        // 4、调用方法
        Object invoke = method.invoke(stu, "李四");
        System.out.println(invoke); // 如果method代表的方法没有返回值，那么会返回null

        Class<?> impl = null;
        impl = Class.forName("com.lei.java.Student", true, Thread.currentThread().getContextClassLoader());
        Object o = impl.newInstance();
        // 4、调用方法
        Object invoke1 = method.invoke(stu, "李四222");
        System.out.println(invoke1); // 如果method代表的方法没有返回值，那么会返回null

        System.out.println(stu);

        /**
         * 调用getName
         */
        Method m2 = clazz.getDeclaredMethod("getName"); // getName()没有形参列表
        Object value = m2.invoke(stu);
        System.out.println(value);

    }
}
