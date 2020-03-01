package com.java.basic.c02_object.system;

import org.junit.Test;

/**
 * System有三个常量对象：
 *      System.in: InputStream
 *      System.out: PrintStream
 *      System.err: PrintStream
 *
 * System.currentTimeMillis(): 当前时间与协调世界时1970年1月1日午夜之间的时间差（以毫秒为单位测量）。
 * System.arraycopy(src, srcPost, dest, destPost, int len)
 *      第一个参数：被复制（移动）数组
 *      第二个参数：从哪个位置开始复制（移动）
 *      第三个参数：目标数组
 *      第四个参数：目标的起始位置
 *      第五个参数：要复制（移动）元素个数
 *
 * System.gc(): 通知垃圾回收器来回收垃圾。但是，不是一调用，立马就回收
 *
 * Runtime: 代表运行环境
 *      Runtime对象.gc()
 *      long maxMemory()
 *      long freeMemory()
 *      long totalMemory()
 *
 */
public class TestSystem {

    @Test
    public void test1(){
        // 插入
        String[] arr = new String[5];
        arr[0] = "hello";
        arr[1] = "java";
        arr[2] = "world";
        arr[3] = "string";
        arr[4] = "array";

        // 要删除arr[1]
        int total = 5;
        int index = 1;
        System.arraycopy(arr, index + 1, arr, index, total - index -1);
        arr[total-1] = null;
        total--;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
