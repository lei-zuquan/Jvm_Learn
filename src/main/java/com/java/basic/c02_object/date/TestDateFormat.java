package com.java.basic.c02_object.date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * DateTimeFormatter
 *      DateTimeFormatter.ofLocalizeDate(预定义模式)
 *      DateTimeFormatter.ofPattern("自定义模式");和SimpleDateFormat一样 yyyy-MM-dd
 */
public class TestDateFormat {

    @Test
    public void test2(){
        LocalDate today = LocalDate.now();

        //DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd E");
        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println(d.format(today));
    }
    @Test
    public void test(){
        LocalDate today = LocalDate.now();

        // style
        DateTimeFormatter d1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        DateTimeFormatter d2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        DateTimeFormatter d3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);

        System.out.println(d1.format(today));
        System.out.println(d2.format(today));
        System.out.println(d3.format(today));
    }
}
