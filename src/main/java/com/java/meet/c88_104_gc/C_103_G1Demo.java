package com.java.meet.c88_104_gc;

import java.util.Random;

/**
 * 103_GC之G1参数配置和CMS比较
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseG1GC
 *
 * G1 响应比CMS快
 * G1 逻辑分代，物理不分
 *
 * CMS回收器，标记清除可能会形成垃圾碎片
 *
 *
 * CMS问题：
 *      因为CMS 采用标记清除算法，会形成碎片化，容易大对象
 *      如果碎片化严重，CMS采用Serial Old单线程来清理垃圾，卡起来可能几个小时或者1天
 *      浮动垃圾
 *
 * CMS阶段：
 *      1、初始标记，时间非常短
 *      2、并发标记，工作线程与垃圾回收线程并发
 *      3、重新标记，由于可能存错误标记，需要重新标记，所以需要重新标记
 *      4、并发清理
 *
 * top
 * jps
 * jinfo pid （oom时，此命令帮不上什么忙）
 * jstat -gc pid 1000  (间隔查询资源消耗)
 * jstack pid | more   (一般用来发现有没有死锁) (CPU突然飙高)
 *
 *
 * jconsole  原始的图形界面
 * jvisualvm 比较新的图形界面
 *
 * arthas 阿里开源的图形化界面：
 *      启动arthas：java -jar arthas-boot.jar
 *
 * 生产环境，使用指令排查问题，不使用图形化界面
 * 测试过程，可以使用图形化界面测试
 *
 */
public class C_103_G1Demo {

    public static void main(String[] args) {
        String str = "hello world";
        while (true){
            str += str + new Random().nextInt(77777777) + new Random().nextInt(88888888);
            str.intern();
        }
    }
}
