package com.java.basic.c02_object.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期时间API:
 *      第一代：java.util.Date
 *          1)年份：1990
 *      第二代：java.util.Calendar
 *
 *      第三代：JDK1.8之后引入了新的日期时间的API， 例如：LocalDate, LocalTime等
 *          1)  老版的日期时间对象没有设计为不可变对象
 *                  每一个日期时间点，都应该用一个对象表示。不同的日期时间点应该用不同的对象表示。
 *          2） 老版的日期时间API没有考虑闰秒
 *          3） 关于日期格式化等API只支持Date类型，不支持Calendar
 *
 *  第一代：java.util.Date
 *      1、new Date()
 *      2、long getTime()
 *      3、new Date(毫秒)
 *
 *      java.sql.Date是在JDBC中使用
 *
 *
 *  第二代：java.util.Calendar
 *      子类：GregorianCalendar
 *      1、Calendar c = Calendar.getInstance();
 *      2、get(常量多)获取具体的某个时间值
 *
 *  关于日期时间格式化：
 *      java.text.DateFormat:
 *      java.text.SimpleDateFormat
 *          1、Date parse(String)
 *          2、String format(date)
 */
public class TestDate {

    @Test
    public void test4() throws ParseException {
        Date d = new Date();
        System.out.println(d);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年-MM月-dd日 HH时:mm分:ss秒 SSS毫秒");
        String str = sf.format(d);
        System.out.println(str);
    }
    @Test
    public void test3() throws ParseException {
        String str = "2019-01-04 14:45:34 345";
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        Date date = sf.parse(str);
        System.out.println(date);
    }
    @Test
    public void test2(){
        Calendar c = Calendar.getInstance(); // 用默认的语言环境和时区
        System.out.println(c);

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH); // 在格里高利和罗马儒略历中一年中的第一个月是JARUARY,它为0
        int day = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(year + "年" + month + "月" + day + "日");

    }
    @Test
    public void test(){
        Date now = new Date();
        System.out.println(now);

        long time = now.getTime();
        System.out.println(time);

        Date date = new Date(time);
        System.out.println(date);

        Date future = new Date(Long.MAX_VALUE);
        System.out.println(future);
    }
}
