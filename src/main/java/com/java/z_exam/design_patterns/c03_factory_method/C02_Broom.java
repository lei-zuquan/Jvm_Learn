package com.java.z_exam.design_patterns.c03_factory_method;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:08 上午 2020/8/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 扫帚
public class C02_Broom implements C02_Moveable {
    @Override
    public void go() {
        System.out.println("broom flying cha cha cha...");
    }
}
