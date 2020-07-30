package com.jvm.t04_stringtable;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-30 9:30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 演示 StringTable 垃圾回收
 * -Xmx10m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
 */

// 因为在jdk1.8中，字符串常量池是放在堆中，如果堆空间不足，字符串常量池也会进行垃圾回收

public class T08_StringTableGc {
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        try {
            for (int j = 0; j < 10000; j++) { // 前后运行100次、10000次，进行对比。j=100, j=10000
                String.valueOf(j).intern();
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }
}
