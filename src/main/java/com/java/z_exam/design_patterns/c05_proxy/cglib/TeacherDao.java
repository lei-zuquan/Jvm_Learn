package com.java.z_exam.design_patterns.c05_proxy.cglib;

/**
 * @Author:
 * @Date: Created in 11:18 下午 2020/9/3
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class TeacherDao {
    public String teach() {
        System.out.println(" 老师授课中，我是cglib代理，不需要实现接口");
        return "hello";
    }
}
