package com.java.z_exam.design_patterns.c00_priciple.c08_uml.c05_aggregation;

/**
 * @Author:
 * @Date: Created in 10:46 下午 2020/8/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Computer {
    private Mouse mouse;     // 鼠标可以 和 computer 分离
    private Monitor monitor; // 显示器可以和 computer 分离

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }
    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
}

class Mouse{}

class Monitor{}





























