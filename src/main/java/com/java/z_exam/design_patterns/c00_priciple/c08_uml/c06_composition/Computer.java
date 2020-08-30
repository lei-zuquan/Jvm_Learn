package com.java.z_exam.design_patterns.c00_priciple.c08_uml.c06_composition;

/**
 * @Author:
 * @Date: Created in 10:46 下午 2020/8/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Computer {
    private Mouse mouse = new Mouse();     // 鼠标可以 和 computer 不能分离
    private Monitor monitor = new Monitor(); // 显示器可以和 computer 不能分离
}

class Mouse{}

class Monitor{}





























