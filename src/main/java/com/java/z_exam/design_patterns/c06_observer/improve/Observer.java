package com.java.z_exam.design_patterns.c06_observer.improve;

/**
 * @Author:
 * @Date: Created in 10:49 上午 2020/9/5
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 观察者接口，由观察者来实现
public interface Observer {
    public void update(float temperature, float pressure, float humidity);
}
