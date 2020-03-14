package com.java.basic.c02_object.date;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.concurrent.TimeUnit;

/**
 * DateTimeFormatter
 *      DateTimeFormatter.ofLocalizeDate(预定义模式)
 *      DateTimeFormatter.ofPattern("自定义模式");和SimpleDateFormat一样 yyyy-MM-dd
 */
public class TestDateFormat {

    public static final String YYYY_FORMAT = "yyyy";
    public static final String YMDHMS_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_FORMAT = "yyyy-MM-dd";
    public static final String YYYYMMDD_FORMAT = "yyyyMMdd";
    public static final String HMSS_FORMAT = "HHmmssSSS";
    public static final String YMD_HMSS_FORMAT = "yyyy-MM-dd HHmmssSSS";
    public static final String YMD_HMSS_SSS_FORMAT = "yyyy-MM-dd HH:mm:ss SSS";
    public static final String HHMMSS_FORMAT = "HH:mm:ss";

    public static final DateTimeFormatter YMD_HMSS_SSS_DF = DateTimeFormatter.ofPattern(YMD_HMSS_SSS_FORMAT);

    public static void main(String[] args) throws Exception {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.format(DateTimeFormatter.BASIC_ISO_DATE));    //yyyyMMdd
        System.out.println(localDate.format(DateTimeFormatter.ISO_DATE));            //yyyy-MM-dd

        //2.LocalTime  --> String
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.format(DateTimeFormatter.ISO_TIME));            //20:19:22.42
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(HHMMSS_FORMAT);
        System.out.println(localTime.format(formatter));

        System.out.println("============================================");
        //3.LocalDateTime  --> String
        LocalDateTime startTime = LocalDateTime.now();
        System.out.println(LocalDateTime.now().toString());
        LocalDateTime localDateTime = LocalDateTime.parse("2020-03-11 11:16:40 518", YMD_HMSS_SSS_DF);
        System.out.println("localDateTime:" + localDateTime.format(DateTimeFormatter.ofPattern(YYYY_FORMAT)));

        System.out.println(startTime.format(DateTimeFormatter.ofPattern(YYYY_FORMAT)));
        System.out.println(startTime.format(DateTimeFormatter.ofPattern(YMDHMS_FORMAT)));
        System.out.println(startTime.format(DateTimeFormatter.ofPattern(YYYY_MM_DD_FORMAT)));
        System.out.println(startTime.format(DateTimeFormatter.ofPattern(YYYYMMDD_FORMAT)));
        System.out.println(startTime.format(DateTimeFormatter.ofPattern(HMSS_FORMAT)));
        System.out.println(startTime.format(DateTimeFormatter.ofPattern(YMD_HMSS_FORMAT)));
        System.out.println(startTime.format(DateTimeFormatter.ofPattern(YMD_HMSS_SSS_FORMAT)));
        System.out.println(startTime.format(DateTimeFormatter.ofPattern(HHMMSS_FORMAT)));

        TimeUnit.SECONDS.sleep(10);
        LocalDateTime endTime = LocalDateTime.now();
    }


    @Test
    public void test3() {
        LocalDateTime rightNow = LocalDateTime.now();
        String date = DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(rightNow);
        System.out.println(date);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss");
        System.out.println(formatter.format(rightNow));
    }

    @Test
    public void test2(){
        LocalDate today = LocalDate.now();

        DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd E");
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
