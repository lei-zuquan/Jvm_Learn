package com.jvm.t04_stringtable;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-30 9:16
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 演示 StringTable 位置
 * <p>
 * 在jdk8下设置 -Xmx10m -XX:-UseGCOverheadLimit;
 * java.lang.OutOfMemoryError: Java heap space
 * jdk1.8 StringTable字符串常量池是在堆里面
 * 在jdk6下设置 -XX:MaxPermSize=10m； jdk1.6 StringTable字符串常量池是在永久代里面
 * java.lang.OutOfMemoryError: PermGen space
 * jdk1.6 StringTable字符串常量池是在永久代中
 */

/*
-XX:+UseGCOverheadLimit
Enables the use of a policy that limits the proportion of time spent by
the JVM on GC before an OutOfMemoryError exception is thrown.
This option is enabled, by default, and the parallel GC will throw an OutOfMemoryError
if more than 98% of the total time is spent on garbage collection and less than 2% of
the heap is recovered. When the heap is small, this feature can be used to prevent
applications from running for long periods of time with little or no progress.
To disable this option, specify the option -XX:-UseGCOverheadLimit.
 */

public class T07_StringTablePosition {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        int i = 0;
        try {
            for (int j = 0; j < 260000; j++) {
                list.add(String.valueOf(j).intern());
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }
}
