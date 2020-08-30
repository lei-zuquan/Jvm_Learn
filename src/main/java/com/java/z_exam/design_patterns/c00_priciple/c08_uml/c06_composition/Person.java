package com.java.z_exam.design_patterns.c00_priciple.c08_uml.c06_composition;

/**
 * @Author:
 * @Date: Created in 11:01 下午 2020/8/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Person {
    private IDCard card;  // 聚合关系
    private Head head = new Head(); // 组合关系
}
class IDCard{}
class Head{}
