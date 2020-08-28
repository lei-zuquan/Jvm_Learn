package com.java.z_exam.design_patterns.c03_factory_method;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 12:59 下午 2020/8/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C04_CarFactory {
    // 更加严格的做法，是返回一下抽象接口类
    public C02_Moveable create() {
        System.out.println("a car created!");
        return new C02_Car();
    }
}
