package com.java.z_exam.sync;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 2:19 下午 2020/4/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

/**
 * 假如锁处于偏向状态，这时来了竞争者，那么他的状态是什么？
 */
public class T04_HelloJOL {
    public static void main(String[] args) throws Exception {
        //TimeUnit.SECONDS.sleep(5);

        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        synchronized (o){ // 锁定这个对象
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
