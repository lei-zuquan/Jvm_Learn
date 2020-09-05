package com.java.z_exam.design_patterns.c06_observer.improve;

/**
 * @Author:
 * @Date: Created in 10:47 上午 2020/9/5
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 接口，让WeatherData 来实现
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
