package com.java.basic.c02_object.date.java8_newdate;

import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-04-23 16:55
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C02_NewDateJvmTest {
    public static void main(String[] args) {
        while (true) {
            LocalTime connectDate = LocalTime.now();
            LocalTime currDate = LocalTime.now();

            long currtTime = currDate.getSecond();
            long connectTime = connectDate.getSecond();
            long freeSpendTime = currtTime - connectTime;
            if (freeSpendTime > 2000) {
                System.out.println("freeSpendTime：" + freeSpendTime);
            }
//            try {
//                //TimeUnit.MILLISECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

    }

    @Test
    public void testSpendTime() throws Exception {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("计算两个时间的差：");
        TimeUnit.SECONDS.sleep(1);
        LocalDateTime end = LocalDateTime.now();
        Duration duration = Duration.between(now, end);
        long days = duration.toDays(); //相差的天数
        long hours = duration.toHours();//相差的小时数
        long minutes = duration.toMinutes();//相差的分钟数
        long millis = duration.toMillis();//相差毫秒数
        long nanos = duration.toNanos();//相差的纳秒数
        System.out.println(now);
        System.out.println(end);

        System.out.println("发送短信耗时【 " + days + "天：" + hours + " 小时：" + minutes + " 分钟：" + millis + " 毫秒：" + nanos + " 纳秒】");

    }
}
