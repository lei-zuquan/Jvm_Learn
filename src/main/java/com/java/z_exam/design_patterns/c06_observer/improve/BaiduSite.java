package com.java.z_exam.design_patterns.c06_observer.improve;

/**
 * @Author:
 * @Date: Created in 11:07 上午 2020/9/5
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class BaiduSite implements Observer {
    // 温度，气压，湿度
    private float temperature;
    private float pressure;
    private float humidity;

    // 更新天气情况，是由WeatherData 来调用，使用推送模式
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    // 显示
    public void display() {
        System.out.println("========百度网站============");
        System.out.println("*** 百度网站 mTemperature: " + temperature + "****");
        System.out.println("*** 百度网站 mPressure: " + pressure + "****");
        System.out.println("*** 百度网站 mHumidity: " + humidity + "****");
    }
}
