package com.java.z_exam.design_patterns.c03_factory.c04_jdk;

/**
 * @Author:
 * @Date: Created in 10:10 上午 2020/8/31
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
import java.util.Calendar;

public class Factory {
    public static void main(String[] args) {
        // getInstance 是 Calendar 静态方法
        Calendar cal = Calendar.getInstance();
        // 注意月份下标从 0 开始，所以取月份要+1
        System.out.println("年:" + cal.get(Calendar.YEAR));
        System.out.println(" 月 :" + (cal.get(Calendar.MONTH) + 1));
        System.out.println("日:" + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("时:" + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("分:" + cal.get(Calendar.MINUTE));
        System.out.println("秒:" + cal.get(Calendar.SECOND));
    }
}