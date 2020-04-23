package com.java.z_exam.jvm_gc;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:22 下午 2020/3/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 1、启动程序
 * 2、在Terminal终端中输入：jvisualvm 查看堆使用情况
 *
 * 还有一种方式：
 *      GC日志详解：
 *          对于java应用我们可以通过一些配置把程序运行过程中的gc日志全部打印出来，然后分析gc日志得到关键性指标
 *          在JVM参数里增加参数
 *          -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC -XX:+UseParallelOldGC
 *
 *  java -XX:+PrintCommandLineFlags -version
 *  打印JVM参数
 *
 *
 */
public class HeapTest {

    byte[] a = new byte[1024*100];  // 100KB

    public static void main(String[] args) throws InterruptedException {
        ArrayList<HeapTest> heapTests = new ArrayList<>();

        while (true){
            heapTests.add(new HeapTest());
            TimeUnit.MILLISECONDS.sleep(10);
        }
    }
}
