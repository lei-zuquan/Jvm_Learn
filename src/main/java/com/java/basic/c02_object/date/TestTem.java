package com.java.basic.c02_object.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * 校正时间
 */
public class TestTem {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println("下一个周日：" + now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)));
        System.out.println("下一个周五：" + now.with(TemporalAdjusters.next(DayOfWeek.FRIDAY)));
        System.out.println("本月最后一天：" + now.with(TemporalAdjusters.lastDayOfMonth()));
    }
}
