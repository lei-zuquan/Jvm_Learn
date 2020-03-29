package com.java.basic.c10_fanshe.c04_fansheyingyong;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:58 上午 2020/3/29
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * day27_10使用Class对象和构造器对象创建对象
 *
 * 三、在运行期间，动态的为对象的属性赋值或获取属性值
 *
 * 步骤：
 *      1、获取Class对象
 *      2、获取Field属性对象
 *      3、创建实例对象，Class代表的类型的实例对象，例如这里是学生对象
 *      4、调用Field对象.set(实例对象，属性值)
 *          调用Field对象.get(实例对象）
 *
 *      说明：如果属性是私有的，那么可以调用
 *          Field对象.setAccessible(true);
 *
 */
public class TestFieldSetGet {
    @Test
    public void test1() throws Exception {
        // 1、获取Class对象
        Class<?> clazz = Class.forName("com.lei.java.Student");
        // 2、获取Field属性对象
        // 例如：这里要为name属性赋值
        Field nameField = clazz.getDeclaredField("name");

        // 3、创建Student的对象
        Object stu = clazz.newInstance();

        nameField.setAccessible(true);
        // 4、为属性赋值
        nameField.set(stu, "zhangsan"); // stu.setName("zhangsan"); stu.name = "zhangsan";

        // 5、获取属性值
        Object value = nameField.get(stu);
        System.out.println(value);
    }
}
