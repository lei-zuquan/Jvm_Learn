package com.java.basic.c02_object.date;

import org.junit.Test;

import java.time.*;

/**
 * Duration: 时间间隔
 * Period: 日期间隔
 */
public class TestDuration {
    @Test
    public void test3(){
        LocalTime now = LocalTime.now();
        LocalTime xia = LocalTime.of(17,0,0);

        Duration d = Duration.between(now, xia);
        System.out.println(d);
    }
    @Test
    public void test2(){
        LocalDate today = LocalDate.now();
        LocalDate year = LocalDate.of(2019,2,5);

        Period p = Period.between(today, year);
        System.out.println(p);
    }
    @Test
    public void test(){
        LocalDate today = LocalDate.now();
        LocalDate birth = LocalDate.of(1996,6,6);

        Period p = Period.between(today, birth);
        System.out.println(p);
    }
}
