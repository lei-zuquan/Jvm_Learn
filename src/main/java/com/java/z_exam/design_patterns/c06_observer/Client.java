package com.java.z_exam.design_patterns.c06_observer;

/**
 * @Author:
 * @Date: Created in 10:18 上午 2020/9/5
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Client {
    public static void main(String[] args) {
        // 创建接入方 currentConditions
        CurrentConditions currentConditions = new CurrentConditions();
        // 创建 WeatherData 并将接入方 currentConditions 传递到WeatherData中
        WeatherData weatherData = new WeatherData(currentConditions);

        // 更新天气情况
        weatherData.setData(30, 150, 40);

        // 天气情况变化
        System.out.println("========== 天气情况变化 ==========");
        weatherData.setData(40, 160, 20);
    }
}
