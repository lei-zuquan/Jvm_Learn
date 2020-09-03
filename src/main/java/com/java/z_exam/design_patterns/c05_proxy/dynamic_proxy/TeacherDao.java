package com.java.z_exam.design_patterns.c05_proxy.dynamic_proxy;

/**
 * @Author:
 * @Date: Created in 9:55 下午 2020/9/3
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println(" 老师授课中... ");
    }

    @Override
    public void sayHello(String name) {
        System.out.println("hello " + name);
    }
}
