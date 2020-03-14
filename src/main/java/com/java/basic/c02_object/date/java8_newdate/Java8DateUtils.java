package com.java.basic.c02_object.date.java8_newdate;


import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;


/**
 * 日期时间工具类
 *
 * @author Administrator
 */
public class Java8DateUtils {

    // SimpleDateFormat 非线程安全，JAVA8以前；解决办法在使用的时候进行创建
    // DateTimeFormatter 线程安全，JAVA8以后；一次创建好后，后续可多线程共享

    public static final String YYYY_TIME_FORMAT = "yyyy";
    public static final String YMDHMS_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_TIME_FORMAT = "yyyy-MM-dd";
    public static final String YYYYMMDD_TIME_FORMAT = "yyyyMMdd";
    public static final String HMSS_TIME_FORMAT = "HHmmssSSS";
    public static final String YMD_HMSS_TIME_FORMAT = "yyyy-MM-dd HHmmssSSS";
    public static final String YMD_HMSS_SSS_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss SSS";
    public static final String HHMMSS_TIME_FORMAT = "HH:mm:ss";
    public static final String YYYYMMHHMM_TIME_FORMAT = "yyyyMMddHHmm";

    public static final DateTimeFormatter YYYY_FORMAT = DateTimeFormatter.ofPattern(YYYY_TIME_FORMAT);
    public static final DateTimeFormatter YMDHMS_FORMAT = DateTimeFormatter.ofPattern(YMDHMS_TIME_FORMAT);
    public static final DateTimeFormatter YYYY_MM_DD_FORMAT = DateTimeFormatter.ofPattern(YYYY_MM_DD_TIME_FORMAT);
    public static final DateTimeFormatter YYYYMMDD_FORMAT = DateTimeFormatter.ofPattern(YYYYMMDD_TIME_FORMAT);
    public static final DateTimeFormatter HMSS_FORMAT = DateTimeFormatter.ofPattern(HMSS_TIME_FORMAT);
    public static final DateTimeFormatter YMD_HMSS_FORMAT = DateTimeFormatter.ofPattern(YMD_HMSS_TIME_FORMAT);
    public static final DateTimeFormatter YMD_HMSS_SSS_FORMAT = DateTimeFormatter.ofPattern(YMD_HMSS_SSS_TIME_FORMAT);
    public static final DateTimeFormatter HHMMSS_FORMAT = DateTimeFormatter.ofPattern(HHMMSS_TIME_FORMAT);
    public static final DateTimeFormatter YYYYMMHHMM_FORMAT = DateTimeFormatter.ofPattern(YYYYMMHHMM_TIME_FORMAT);
    public static final SimpleDateFormat YYYY_SDF = new SimpleDateFormat(YYYY_TIME_FORMAT);

    public static void main(String[] args) throws Exception {

        //String todayDate = new SimpleDateFormat(YMD_HMSS_SSS_TIME_FORMAT).format(new Date());
        //System.out.println(todayDate); // 2020-03-11 11:16:40 518

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    try {
                        //Date dateTime1 = YYYY_SDF.parse("2020-03-11 11:16:40 518");
                        //Date dateTime1 = new SimpleDateFormat(YYYY_TIME_FORMAT).parse("2020-03-11 11:16:40 518");
                        //System.out.println("SimpleDateFormat:" + dateTime1.toString());
                        LocalDateTime startTime = LocalDateTime.now();
                        System.out.println("DateTimeFormatter:" + startTime.format(YYYY_FORMAT));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
            }, i + " thread").start();
        }


    }

    /**
     * 判断一个时间是否在另一个时间之前
     *
     * @param time1 第一个时间
     * @param time2 第二个时间
     * @return 判断结果
     */
    public static boolean ymd_HMSS_SSS_Before(String time1, String time2) {
        try {
            // time1,time2 yyyy-MM-dd HH:mm:ss SSS
            LocalDateTime dateTime1 = LocalDateTime.parse(time1, YMD_HMSS_SSS_FORMAT);
            LocalDateTime dateTime2 = LocalDateTime.parse(time2, YMD_HMSS_SSS_FORMAT);

            if (dateTime1.isBefore(dateTime2)) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断一个时间是否在另一个时间之后
     *
     * @param time1 第一个时间
     * @param time2 第二个时间
     * @return 判断结果
     */
    public static boolean ymd_HMSS_SSS_After(String time1, String time2) {
        try {
            // time1,time2 yyyy-MM-dd HH:mm:ss SSS
            LocalDateTime dateTime1 = LocalDateTime.parse(time1, YMD_HMSS_SSS_FORMAT);
            LocalDateTime dateTime2 = LocalDateTime.parse(time2, YMD_HMSS_SSS_FORMAT);
            if (dateTime1.isAfter(dateTime2)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断一个时间是否在另一个时间之前
     *
     * @param time1 第一个时间
     * @param time2 第二个时间
     * @return 判断结果
     */
    public static boolean ymd_HMSS_Before(String time1, String time2) {
        try {
            // time1,time2 yyyy-MM-dd HH:mm:ss
            LocalDateTime dateTime1 = LocalDateTime.parse(time1, YMDHMS_FORMAT);
            LocalDateTime dateTime2 = LocalDateTime.parse(time2, YMDHMS_FORMAT);

            if (dateTime1.isBefore(dateTime2)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 判断一个时间是否在另一个时间之后
     *
     * @param time1 第一个时间
     * @param time2 第二个时间
     * @return 判断结果
     */
    public static boolean yyyy_MM_DD_After(String time1, String time2) {
        try {
            // time1,time2 yyyy-MM-dd
            LocalDateTime dateTime1 = LocalDateTime.parse(time1, YYYY_MM_DD_FORMAT);
            LocalDateTime dateTime2 = LocalDateTime.parse(time1, YYYY_MM_DD_FORMAT);

            if (dateTime1.isAfter(dateTime2)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getAdjustTime(String time) {
        if (time.length() < 9) {
            return getTodayYMD() + " 0" + time; // 2019-08-15 092903000
        } else {
            return getTodayYMD() + " " + time;  // 2019-08-15 152903000
        }
    }

    public static String getYMD_HMSS_SSS_AdjustTime(String time) {
        String adjustTime = getAdjustTime(time);

        try {
            LocalDateTime dateTime = LocalDateTime.parse(adjustTime, YMD_HMSS_FORMAT);
            adjustTime = dateTime.format(YMD_HMSS_SSS_FORMAT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return adjustTime;
    }


    public static boolean before(String time1, String time2) {
        try {
            LocalDateTime dateTime1 = LocalDateTime.parse(time1, YMDHMS_FORMAT);
            LocalDateTime dateTime2 = LocalDateTime.parse(time2, YMDHMS_FORMAT);

            if (dateTime1.isBefore(dateTime2)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 判断一个时间是否在另一个时间之后
     *
     * @param time1 第一个时间
     * @param time2 第二个时间
     * @return 判断结果
     */
    public static boolean after(String time1, String time2) {
        try {
            LocalDateTime dateTime1 = LocalDateTime.parse(time1, YMDHMS_FORMAT);
            LocalDateTime dateTime2 = LocalDateTime.parse(time2, YMDHMS_FORMAT);

            if (dateTime1.isAfter(dateTime2)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 计算时间差值（单位为秒）
     *
     * @param time1 时间1
     * @param time2 时间2
     * @return 差值
     */
    public static int seconds(String time1, String time2) {
        try {
            LocalDateTime dateTime1 = LocalDateTime.parse(time1, YMDHMS_FORMAT);
            LocalDateTime dateTime2 = LocalDateTime.parse(time2, YMDHMS_FORMAT);

            return dateTime1.getSecond() - dateTime2.getSecond();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    public static int ymd_hmss_sss_milliSeconds(String time1, String time2) {
        try {
            LocalDateTime dateTime1 = LocalDateTime.parse(time1, YMD_HMSS_SSS_FORMAT);
            LocalDateTime dateTime2 = LocalDateTime.parse(time2, YMD_HMSS_SSS_FORMAT);

            long toEpochMilli1 = dateTime1.toInstant(ZoneOffset.of("+8")).toEpochMilli();
            long toEpochMilli2 = dateTime2.toInstant(ZoneOffset.of("+8")).toEpochMilli();

            long millisecond = toEpochMilli1 - toEpochMilli2;
            return Integer.valueOf(String.valueOf(millisecond));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int ymd_hmss_milliSeconds(String time1, String time2) {
        try {
            LocalDateTime dateTime1 = LocalDateTime.parse(time1, YMDHMS_FORMAT);
            LocalDateTime dateTime2 = LocalDateTime.parse(time2, YMDHMS_FORMAT);


            long toEpochMilli1 = dateTime1.toInstant(ZoneOffset.of("+8")).toEpochMilli();
            long toEpochMilli2 = dateTime2.toInstant(ZoneOffset.of("+8")).toEpochMilli();

            long millisecond = toEpochMilli1 - toEpochMilli2;
            return Integer.valueOf(String.valueOf(millisecond));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * 获取年月日和小时
     *
     * @param datetime 时间（yyyy-MM-dd HH:mm:ss）
     * @return 结果（yyyy-MM-dd_HH）
     */
    public static String getDateHour(String datetime) {
        String date = datetime.split(" ")[0];
        String hourMinuteSecond = datetime.split(" ")[1];
        String hour = hourMinuteSecond.split(":")[0];
        return date + "_" + hour;
    }

    /**
     * 获取年月日和小时
     *
     * @param datetime 时间（yyyy-MM-dd HH:mm:ss）
     * @return 结果（yyyy-MM-dd_HH_MM_SS）
     * 2019-03-06 09:10:40
     */
    public static String getDateHourMinSecond(String datetime) {
        String date = datetime.split(" ")[0];
        String[] hourMinuteSecondArrStrings = datetime.split(" ")[1].split(":");

        return date + "_" + hourMinuteSecondArrStrings[0]
                + "_" + hourMinuteSecondArrStrings[1]
                + "_" + hourMinuteSecondArrStrings[2];
    }

    /**
     * 获取当天日期（yyyy-MM-dd HH:mm:ss）
     *
     * @return 当天日期
     */
    public static String getTodayYMDHMS() {
        return YMDHMS_FORMAT.format(LocalDateTime.now());
    }

    /**
     * 获取当天日期加零点（yyyy-MM-dd 00:00:00）
     *
     * @return 当天日期
     */
    public static String getTodayYMDZeroTime() {
        return YYYY_MM_DD_FORMAT.format(LocalDateTime.now()) + " 00:00:00";
    }

    /**
     * 获取当前年份（yyyy）
     */
    public static String getCurrentYear() {
        return YYYY_FORMAT.format(LocalDateTime.now());
    }

    /**
     * 获取当天日期加零点（yyyyMMdd）
     *
     * @return 当天日期
     */
    public static String getTodayYYYYMMDD() {
        return YYYYMMDD_FORMAT.format(LocalDateTime.now());
    }

    /**
     * 获取当天日期及时间（yyyy-MM-dd）
     *
     * @return
     */
    public static String getTodayYMD() {
        return YYYY_MM_DD_FORMAT.format(LocalDateTime.now());
    }

    /**
     * 获取当天时间（HHmmssSSS）
     *
     * @return
     */
    public static String getHMSSTime() {
        return HMSS_FORMAT.format(LocalDateTime.now());
    }

    /**
     * 获取当天日期及时间（yyyy-MM-dd HH:mm:ss SSS）
     *
     * @return
     */
    public static String getCurrentYMD_HMSS_SSS() {
        return YMD_HMSS_SSS_FORMAT.format(LocalDateTime.now());
    }

    /**
     * 输入时间戳字符，获取对应的时间，最后两个时间做对比，获取时间差，单位毫秒
     *
     * @param dataTimeStamp
     * @return
     */
    public static int getTransCacuSpendTime(String dataTimeStamp) {
        String dealTime = Java8DateUtils.getAdjustTime(dataTimeStamp);
        dealTime = Java8DateUtils.getYMD_HMSS_SSS_AdjustTime(dataTimeStamp);
        String currentTime = Java8DateUtils.getCurrentYMD_HMSS_SSS();

        int transCacuSpendTime = Java8DateUtils.ymd_hmss_sss_milliSeconds(currentTime, dealTime);
        return transCacuSpendTime;
    }

    /**
     * 输入时间戳字符，获取对应的时间，最后两个时间做对比，获取时间差，单位毫秒
     *
     * @param
     * @return
     */
    public static int getTransCacuSpendTimeByDateTime(String dateTime) {
        String currentTime = Java8DateUtils.getTodayYMDHMS();

        int transCacuSpendTime = Java8DateUtils.ymd_hmss_milliSeconds(currentTime, dateTime);
        return transCacuSpendTime;
    }


    /**
     * 格式化日期（yyyy-MM-dd）
     *
     * @param
     * @return 格式化后的日期
     */
    public static String formatDate(LocalDateTime localDateTime) {
        return YYYY_MM_DD_FORMAT.format(localDateTime);
    }

    /**
     * 格式化时间（yyyy-MM-dd HH:mm:ss）
     *
     * @param
     * @return 格式化后的时间
     */
    public static String formatTime(LocalDateTime localDateTime) {
        return YMDHMS_FORMAT.format(localDateTime);
    }

    /**
     * 解析时间字符串
     *
     * @param time 时间字符串
     * @return Date
     */
    public static LocalDateTime parseTime(String time) {
        try {
            return LocalDateTime.parse(time, YYYY_MM_DD_FORMAT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 格式化日期key
     *
     * @param
     * @return YYYYMMDD_FORMAT = "yyyyMMdd";
     */
    public static String formatDateKey(LocalDateTime localDateTime) {
        return YYYYMMDD_FORMAT.format(localDateTime);
    }

    // 每一个线程
    private static final ThreadLocal<SimpleDateFormat> THREAD_LOCAL = new ThreadLocal<SimpleDateFormat>();

    public static Date parseDateKey(String dateStr) {
        SimpleDateFormat sdf = null;
        sdf = THREAD_LOCAL.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat(YYYYMMDD_TIME_FORMAT);
        }
        //
        Date date = null;
        try {
            System.out.println("当前线程为 parseDateKey:" + Thread.currentThread().getName());
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    /**
     * 格式化时间，保留到分钟级别
     * yyyyMMddHHmm
     *
     * @param
     * @return
     */
    public static String formatTimeMinute(LocalDateTime localDateTime) {
        return YYYYMMHHMM_FORMAT.format(localDateTime);
    }


    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime   当前时间
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    public static boolean isEffectiveDate(LocalDateTime nowTime, LocalDateTime startTime, LocalDateTime endTime) {
        if (nowTime == null || startTime == null || endTime == null) {
            return false;
        }

        if (nowTime.isAfter(startTime) && nowTime.isBefore(endTime)) {
            return true;
        }

        return false;
    }

    /**
     * 判断时间是否在有交易时间段内
     *
     * @param currDate
     * @return
     */
    public static boolean checkIsWorkingTime(LocalDateTime currDate) {
        // 如果当前时间是周末的话则直接返回
        if (checkWeekend(currDate)) {
            return false;
        }

        // 如果当前时间是节假日的话，则直接返回false
        if (checkIsHoliday(currDate)) {
            return false;
        }

        LocalDateTime amStartTime = null;
        LocalDateTime amEndTime = null;

        try {
            amStartTime = LocalDateTime.parse("09:26:00", HHMMSS_FORMAT);
            amEndTime = LocalDateTime.parse("11:30:30", HHMMSS_FORMAT);
        } catch (Exception e) {
            e.printStackTrace();
        }


        boolean isEffective = Java8DateUtils.isEffectiveDate(currDate, amStartTime, amEndTime);
        if (isEffective) {
            return true;
        }

        LocalDateTime pmStartTime = null;
        LocalDateTime pmEndTime = null;

        try {
            pmStartTime = LocalDateTime.parse("13:00:00", HHMMSS_FORMAT);
            pmEndTime = LocalDateTime.parse("15:00:30", HHMMSS_FORMAT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        isEffective = Java8DateUtils.isEffectiveDate(currDate, pmStartTime, pmEndTime);
        return isEffective;
    }

    /**
     * 通过时间，判断是否是周末。如果是周末的话，则返回true
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static boolean checkWeekend(LocalDateTime date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            return true;
        }

        return false;
    }

    /**
     * 通过时间，判断是否为节假日。如果是节假日的话，则返回true
     *
     * @param date
     * @return
     */
    public static boolean checkIsHoliday(LocalDateTime date) {
        String currtDate = Java8DateUtils.formatDateKey(date);
        // 通过当前年份，获取当前年份对应的假期数据
        String yearTime = Java8DateUtils.getCurrentYear();
        //IStockHolidayDataDAO dao = DAOFactory.getStockHolidayDataDAO();
        //StockHolidayData stockHolidayData = dao.getHolidayByYear(yearTime);
        //String holiday = stockHolidayData.getHolidayTime();

        String holiday = "20190101,20190204,20190205,20190206,20190207,20190208,20190209,20190210,"
                + "20190405,20190406,20190407,20190501,20190502,20190503,20190607,20190608,20190609,"
                + "20190913,20190914,20190915,20191001,20191002,20191003,20191004,20191005,20191006,20191007,";

        if (holiday.contains(currtDate)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 将String字符串转换为java.sql.Timestamp格式日期,用于数据库保存
     *
     * @param strDate    表示日期的字符串
     * @param dateFormat 传入字符串的日期表示格式（如："yyyy-MM-dd HH:mm:ss"）
     * @return java.sql.Timestamp类型日期对象（如果转换失败则返回null）
     */
    public static java.sql.Timestamp strToSqlTimestamp(String strDate, String dateFormat) {
        LocalDateTime localDateTime = LocalDateTime.parse(strDate, DateTimeFormatter.ofPattern(dateFormat));
        java.sql.Timestamp dateSQL = Timestamp.valueOf(localDateTime);
        return dateSQL;
    }

    /**
     * 将String字符串转换为java.sql.Timestamp格式日期,用于数据库保存
     *
     * @param strDate    表示日期的字符串
     * @param dateFormat 传入字符串的日期表示格式（如："yyyy-MM-dd"）
     * @return java.sql.Timestamp类型日期对象（如果转换失败则返回null）
     */
    public static java.sql.Date strToSqlDate(String strDate, String dateFormat) {
        LocalDateTime localDateTime = LocalDateTime.parse(strDate, DateTimeFormatter.ofPattern(dateFormat));
        java.sql.Date dateSQL = java.sql.Date.valueOf(localDateTime.toLocalDate());

        return dateSQL;
    }
}
