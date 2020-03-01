package com.java.basic.c02_object.date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 第三版时间：JDK1.8之后
 *
 * LocalDate: 只能表示日期，例如：生日，入职日期
 * LocalTime: 只能表示时间
 * LocalDateTime: 可以表示日期加时间，例如：用户注册日期时间，最后的登录日期时间 ，订单日期时间
 *
 * 1、now()
 * 2、of()
 * 3、getYear()
 *      getXxx
 * 4、withXxxx(): 修改
 * 5、plusXxx() : 加
 * 6、minusXxxx(): 减
 * 7、isLeapYear(): 是否是闰年
 *
 */
public class TestLocalDate {
    @Test
    public void test7(){
        LocalDate t = LocalDate.now();
        System.out.println(t.isLeapYear());
    }
    @Test
    public void test6(){
        LocalDate t = LocalDate.now();
        LocalDate days = t.minusDays(30);
        System.out.println(days);
    }
    @Test
    public void test5(){
         LocalDate t = LocalDate.now();
         LocalDate days = t.plusDays(150);
        System.out.println(days);
    }
    @Test
    public void test4(){
        LocalDate birth = LocalDate.of(1999, 9,9);
        LocalDate date = birth.withYear(2000);
        System.out.println(birth);
        System.out.println(date); // 凡是修改就会产生新对象
    }
    @Test
    public void test3(){
        LocalDate birth = LocalDate.of(1999, 9,9);
        int year = birth.getYear();

        LocalDate today = LocalDate.now();
        int t = today.getYear();
        System.out.println(t - year);
    }
    @Test
    public void test2(){
        LocalDate birth = LocalDate.of(1999, 9,9);
        System.out.println(birth);
    }
    @Test
    public void test1(){
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
    }
}
