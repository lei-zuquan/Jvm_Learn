package com.java.z_exam.design_patterns.c06_observer.improve;

/**
 * @Author:
 * @Date: Created in 10:11 上午 2020/9/5
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */


import java.util.ArrayList;

/**
 * 类是核心
 * 1、包含最新的天气情况信息
 * 2、含有 观察者集扣，使用ArrayList管理
 * 3、当数据有更新时，就主动的调用 ArrayList，通知所有的（接入方）就看到最新的信息
 */
public class WeatherData implements Subject {
    // 温度，气压，湿度
    private float temperature;
    private float pressure;
    private float humidity;

    // 观察者集合
    private ArrayList<Observer> observers;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void dataChange() {
        // 调用 接入方的 update
        //currentConditions.update(getTemperature(), getPressure(), getHumidity());
        notifyObservers();
    }

    // 当数据有更新时，就调用setData
    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        // 调用dataChange，将最新的信息，推送给接入方 currentConditions
        dataChange();
    }

    // 注册一个观察者
    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    // 移除一个观察者
    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    // 遍历所有的观察者，并通知
    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(this.temperature, this.pressure, this.humidity);
        }
    }
}
