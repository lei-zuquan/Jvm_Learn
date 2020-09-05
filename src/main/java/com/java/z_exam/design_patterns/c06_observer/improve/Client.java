package com.java.z_exam.design_patterns.c06_observer.improve;

/**
 * @Author:
 * @Date: Created in 11:00 上午 2020/9/5
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        // 创建一个WeatherData
        WeatherData weatherData = new WeatherData();

        // 创建观察者
        CurrentConditions currentConditions = new CurrentConditions();

        // 注册到weatherData
        weatherData.registerObserver(currentConditions);
        weatherData.registerObserver(new BaiduSite());

        weatherData.removeObserver(currentConditions);

        // 测试
        System.out.println("通知各个注册的观察者，看看信息");
        weatherData.setData(10, 100, 30.3f);
    }
}
