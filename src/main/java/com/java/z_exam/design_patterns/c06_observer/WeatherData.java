package com.java.z_exam.design_patterns.c06_observer;

/**
 * @Author:
 * @Date: Created in 10:11 上午 2020/9/5
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/**
 * 类是核心
 * 1、包含最新的天气情况信息
 * 2、含有 CurrentConditions 对象
 * 3、当数据有更新时，就主动的调用 CurrentConditions 对象update方法（含display），这样他们（接入方）就看到最新的信息
 */
public class WeatherData {
    // 温度，气压，湿度
    private float temperature;
    private float pressure;
    private float humidity;
    private CurrentConditions currentConditions;

    public WeatherData(CurrentConditions currentConditions) {
        this.currentConditions = currentConditions;
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
        currentConditions.update(getTemperature(), getPressure(), getHumidity());
    }

    // 当数据有更新时，就调用setData
    public void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        // 调用dataChange，将最新的信息，推送给接入方 currentConditions
        dataChange();
    }
}
