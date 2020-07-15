package com.java.z_exam.jvm_gc;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-14 20:49
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import java.util.LinkedList;
import java.util.List;

public class T02_HelloGC {
    public static void main(String[] args) {
        System.out.println("HelloGC!");
        List list = new LinkedList();
        for (; ; ) {
            byte[] b = new byte[1024 * 1024];
            list.add(b);
        }
    }
}

/*
1.  java -XX:+PrintCommandLineFlags HelloGC
        -XX:+PrintCommandLineFlags

2.  java -Xmn10M -Xms40M -Xmx60M -XX:+PrintCommandLineFlags -XX:+PrintGC HelloGC PrintGCDetails PrintGCTimeStamps PrintGCCauses
        -Xmn10M -Xms40M -Xmx60M -XX:+PrintCommandLineFlags -XX:+PrintGC
3.  java -XX:+UseConcMarkSweepGC -XX:+PrintCommandLineFlags HelloGC
         -XX:+UseConcMarkSweepGC -XX:+PrintCommandLineFlags

 */