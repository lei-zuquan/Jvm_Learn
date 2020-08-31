package com.java.z_exam.design_patterns.c03_factory.c03_abstract_factory;

import com.java.z_exam.design_patterns.c03_factory.Pizza;

/**
 * @Author:
 * @Date: Created in 10:01 上午 2020/8/31
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
//一个抽象工厂模式的抽象层(接口)
public interface AbsFactory {
    //让下面的工厂子类来 具体实现
    public Pizza createPizza(String orderType);
}
