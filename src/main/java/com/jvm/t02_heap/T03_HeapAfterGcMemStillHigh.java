package com.jvm.t02_heap;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-29 10:26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 演示查看对象个数 堆转储 dump
 */
public class T03_HeapAfterGcMemStillHigh {
    public static void main(String[] args) throws InterruptedException {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            students.add(new Student());
//            Student student = new Student();
        }
        Thread.sleep(1000000000L);
    }
}

class Student {
    private byte[] big = new byte[1024 * 1024];
}

