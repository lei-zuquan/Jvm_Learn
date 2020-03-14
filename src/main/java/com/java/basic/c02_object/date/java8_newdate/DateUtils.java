package com.java.basic.c02_object.date.java8_newdate;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * 日期时间工具类
 *
 * @author Administrator
 */
public class DateUtils {

    private static final String YYYY_FORMAT = "yyyy";
    public static final String YMDHMS_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD_FORMAT = "yyyy-MM-dd";
    private static final String YYYYMMDD_FORMAT = "yyyyMMdd";
    public static final String HMSS_FORMAT = "HHmmssSSS";
    private static final String YMD_HMSS_FORMAT = "yyyy-MM-dd HHmmssSSS";
    private static final String YMD_HMSS_SSS_FORMAT = "yyyy-MM-dd HH:mm:ss SSS";
    private static final String HHMMSS_FORMAT = "HH:mm:ss";

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
            Date dateTime1 = new SimpleDateFormat(YMD_HMSS_SSS_FORMAT).parse(time1);
            Date dateTime2 = new SimpleDateFormat(YMD_HMSS_SSS_FORMAT).parse(time2);

            if (dateTime1.before(dateTime2)) {
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
    public static boolean ymd_HMSS_SSS_After(String time1, String time2) {
        try {
            // time1,time2 yyyy-MM-dd HH:mm:ss SSS
            Date dateTime1 = new SimpleDateFormat(YMD_HMSS_SSS_FORMAT).parse(time1);
            Date dateTime2 = new SimpleDateFormat(YMD_HMSS_SSS_FORMAT).parse(time2);

            if (dateTime1.after(dateTime2)) {
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
            Date dateTime1 = new SimpleDateFormat(YMDHMS_FORMAT).parse(time1);
            Date dateTime2 = new SimpleDateFormat(YMDHMS_FORMAT).parse(time2);

            if (dateTime1.before(dateTime2)) {
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
    public static boolean ymd_HMSS_SSS_Before(Date time1, Date time2) {
        try {
            // time1,time2 yyyy-MM-dd HH:mm:ss SSS
            if (time1.before(time2)) {
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
            Date dateTime1 = new SimpleDateFormat(YYYY_MM_DD_FORMAT).parse(time1);
            Date dateTime2 = new SimpleDateFormat(YYYY_MM_DD_FORMAT).parse(time2);

            if (dateTime1.after(dateTime2)) {
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
            Date dateTime = new SimpleDateFormat(YMD_HMSS_FORMAT).parse(adjustTime);
            adjustTime = new SimpleDateFormat(YMD_HMSS_SSS_FORMAT).format(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return adjustTime;
    }


    public static boolean before(String time1, String time2) {
        try {
            Date dateTime1 = new SimpleDateFormat(YMDHMS_FORMAT).parse(time1);
            Date dateTime2 = new SimpleDateFormat(YMDHMS_FORMAT).parse(time2);

            if (dateTime1.before(dateTime2)) {
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
            Date dateTime1 = new SimpleDateFormat(YMDHMS_FORMAT).parse(time1);
            Date dateTime2 = new SimpleDateFormat(YMDHMS_FORMAT).parse(time2);

            if (dateTime1.after(dateTime2)) {
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
            Date datetime1 = new SimpleDateFormat(YMDHMS_FORMAT).parse(time1);
            Date datetime2 = new SimpleDateFormat(YMDHMS_FORMAT).parse(time2);

            long millisecond = datetime1.getTime() - datetime2.getTime();

            return Integer.valueOf(String.valueOf(millisecond / 1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    public static int ymd_hmss_sss_milliSeconds(String time1, String time2) {
        try {
            Date datetime1 = new SimpleDateFormat(YMD_HMSS_SSS_FORMAT).parse(time1);
            Date datetime2 = new SimpleDateFormat(YMD_HMSS_SSS_FORMAT).parse(time2);


            long millisecond = datetime1.getTime() - datetime2.getTime();
            return Integer.valueOf(String.valueOf(millisecond));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int ymd_hmss_milliSeconds(String time1, String time2) {
        try {
            Date datetime1 = new SimpleDateFormat(YMDHMS_FORMAT).parse(time1);
            Date datetime2 = new SimpleDateFormat(YMDHMS_FORMAT).parse(time2);


            long second = datetime1.getTime() - datetime2.getTime();
            return Integer.valueOf(String.valueOf(second));
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
        return new SimpleDateFormat(YMDHMS_FORMAT).format(new Date());
    }

    /**
     * 获取当天日期加零点（yyyy-MM-dd 00:00:00）
     *
     * @return 当天日期
     */
    public static String getTodayYMDZeroTime() {
        return new SimpleDateFormat(YYYY_MM_DD_FORMAT).format(new Date()) + " 00:00:00";
    }

    /**
     * 获取当前年份（yyyy）
     */
    public static String getCurrentYear() {
        return new SimpleDateFormat(YYYY_FORMAT).format(new Date());
    }

    /**
     * 获取当天日期加零点（yyyyMMdd）
     *
     * @return 当天日期
     */
    public static String getTodayYYYYMMDD() {
        return new SimpleDateFormat(YYYYMMDD_FORMAT).format(new Date());
    }

    /**
     * 获取当天日期及时间（yyyy-MM-dd）
     *
     * @return
     */
    public static String getTodayYMD() {
        return new SimpleDateFormat(YYYY_MM_DD_FORMAT).format(new Date());
    }

    /**
     * 获取当天时间（HHmmssSSS）
     *
     * @return
     */
    public static String getHMSSTime() {
        return new SimpleDateFormat(HMSS_FORMAT).format(new Date());
    }

    /**
     * 获取当天日期及时间（yyyy-MM-dd HH:mm:ss SSS）
     *
     * @return
     */
    public static String getCurrentYMD_HMSS_SSS() {
        return new SimpleDateFormat(YMD_HMSS_SSS_FORMAT).format(new Date());
    }

    /**
     * 输入时间戳字符，获取对应的时间，最后两个时间做对比，获取时间差，单位毫秒
     *
     * @param dataTimeStamp
     * @return
     */
    public static int getTransCacuSpendTime(String dataTimeStamp) {
        String dealTime = DateUtils.getAdjustTime(dataTimeStamp);
        dealTime = DateUtils.getYMD_HMSS_SSS_AdjustTime(dataTimeStamp);
        String currentTime = DateUtils.getCurrentYMD_HMSS_SSS();

        int transCacuSpendTime = DateUtils.ymd_hmss_sss_milliSeconds(currentTime, dealTime);
        return transCacuSpendTime;
    }

    /**
     * 输入时间戳字符，获取对应的时间，最后两个时间做对比，获取时间差，单位毫秒
     *
     * @param
     * @return
     */
    public static int getTransCacuSpendTimeByDateTime(String dateTime) {
        String currentTime = DateUtils.getTodayYMDHMS();

        int transCacuSpendTime = DateUtils.ymd_hmss_milliSeconds(currentTime, dateTime);
        return transCacuSpendTime;
    }


    /**
     * 获取当前时间戳
     *
     * @return
     */
    public static long getTimeStamp() {
        return System.currentTimeMillis();
    }

    public static String getDateTimeByTimeStamp(long timeStamp) {
        return new SimpleDateFormat(YYYY_MM_DD_FORMAT).format(new Date(Long.parseLong(String.valueOf(timeStamp))));
    }

    public static String getYearMonthDayByTimeStamp(String timeStamp) {
        // 152803000
        // 1563175681270
        Long rt = Long.valueOf(timeStamp);
        Long time = rt * 1000L;
        return new SimpleDateFormat(YYYY_MM_DD_FORMAT).format(new Date(time));
    }

    /**
     * 获取昨天的日期（yyyy-MM-dd）
     *
     * @return 昨天的日期
     */
    public static String getYesterdayDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_YEAR, -1);

        Date date = cal.getTime();

        return new SimpleDateFormat(YYYY_MM_DD_FORMAT).format(date);
    }

    /**
     * 格式化日期（yyyy-MM-dd）
     *
     * @param date Date对象
     * @return 格式化后的日期
     */
    public static String formatDate(Date date) {
        return new SimpleDateFormat(YYYY_MM_DD_FORMAT).format(date);
    }

    /**
     * 格式化时间（yyyy-MM-dd HH:mm:ss）
     *
     * @param date Date对象
     * @return 格式化后的时间
     */
    public static String formatTime(Date date) {
        return new SimpleDateFormat(YYYY_MM_DD_FORMAT).format(date);
    }

    /**
     * 解析时间字符串
     *
     * @param time 时间字符串
     * @return Date
     */
    public static Date parseTime(String time) {
        try {
            return new SimpleDateFormat(YYYY_MM_DD_FORMAT).parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 格式化日期key
     *
     * @param date
     * @return YYYYMMDD_FORMAT = "yyyyMMdd";
     */
    public static String formatDateKey(Date date) {
        return new SimpleDateFormat(YYYYMMDD_FORMAT).format(date);
    }

    // 每一个线程
    private static final ThreadLocal<SimpleDateFormat> THREAD_LOCAL = new ThreadLocal<SimpleDateFormat>();

    public static Date parseDateKey(String dateStr) {
        SimpleDateFormat sdf = null;
        sdf = THREAD_LOCAL.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat(YYYYMMDD_FORMAT);
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
     * @param date
     * @return
     */
    public static String formatTimeMinute(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        return sdf.format(date);
    }


    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime   当前时间
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime == null || startTime == null || endTime == null) {
            return false;
        }

        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断时间是否在有交易时间段内
     *
     * @param currDate
     * @return
     */
    public static boolean checkIsWorkingTime(Date currDate) {
        // 如果当前时间是周末的话则直接返回
        if (checkWeekend(currDate)) {
            return false;
        }

        // 如果当前时间是节假日的话，则直接返回false
        if (checkIsHoliday(currDate)) {
            return false;
        }

        SimpleDateFormat hhmmssFormat = new SimpleDateFormat(DateUtils.HHMMSS_FORMAT);
        String timeStr = hhmmssFormat.format(currDate);

        Date nowTime = null;
        Date amStartTime = null;
        Date amEndTime = null;

        try {
            nowTime = hhmmssFormat.parse(timeStr);
            amStartTime = hhmmssFormat.parse("09:26:00");
            amEndTime = hhmmssFormat.parse("11:30:30");
        } catch (ParseException e) {

            e.printStackTrace();
        }


        boolean isEffective = false;
        isEffective = DateUtils.isEffectiveDate(nowTime, amStartTime, amEndTime);

        if (isEffective) {
            return isEffective;
        }

        Date pmStartTime = null;
        Date pmEndTime = null;

        try {
            pmStartTime = hhmmssFormat.parse("13:00:00");
            pmEndTime = hhmmssFormat.parse("15:00:30");
        } catch (ParseException e) {

            e.printStackTrace();
        }

        isEffective = DateUtils.isEffectiveDate(nowTime, pmStartTime, pmEndTime);
        return isEffective;
    }

    /**
     * 通过时间，判断是否是周末。如果是周末的话，则返回true
     *
     * @param date
     * @return
     * @throws Exception
     */
    public static boolean checkWeekend(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);//设置当前时间
        //判断日期是否是周六周日
        if (ca.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                ca.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
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
    public static boolean checkIsHoliday(Date date) {
        String currtDate = DateUtils.formatDateKey(date);
        // 通过当前年份，获取当前年份对应的假期数据
        String yearTime = DateUtils.getCurrentYear();
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
        SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = sf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Timestamp dateSQL = new java.sql.Timestamp(date.getTime());
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
        SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = sf.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date dateSQL = new java.sql.Date(date.getTime());
        return dateSQL;
    }
}
