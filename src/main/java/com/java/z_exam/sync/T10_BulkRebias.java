package com.java.z_exam.sync;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 2:17 下午 2020/4/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T10_BulkRebias {

    private static class A {}

    public static void main(String[] args) throws Exception {
        // 延时产生可偏向对象
        TimeUnit.SECONDS.sleep(5);

        // 创造100个偏向线程t1的偏向锁
        List<A> listA = new ArrayList<>();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                A a = new A();
                synchronized (a) {
                    listA.add(a);
                }
            }
            try {
                TimeUnit.MILLISECONDS.sleep(100000000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t1.start();

        // 睡眠3s钟保证线程t1创建对象完成
        TimeUnit.SECONDS.sleep(3);
        System.out.println("打印t1线程， list中第20个对象的对像头：应该是101 - 偏向锁");
        System.out.println(ClassLayout.parseInstance(listA.get(19)).toPrintable());
        System.out.println("打印t1线程， list中第26个对象的对像头：应该是101 - 偏向锁");
        System.out.println(ClassLayout.parseInstance(listA.get(25)).toPrintable());

        // 创建线程t2竞争线程t1中已经退出同步块的锁
        Thread t2 = new Thread(() -> {
            // 这里面只循环了30次！！！
            for (int i = 0; i < 30; i++) {
                A a = listA.get(i);
                synchronized (a) {
                    // 分别打印第19次和第20次偏向锁重偏向结束
                    if (i == 18 || i==19 || i==25){
                        System.out.println("t2线程：第" + (i+1) + "次偏向结束");
                        System.out.println(ClassLayout.parseInstance(a).toPrintable());
                    }
                }
            }
            try {
                TimeUnit.MILLISECONDS.sleep(100000000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t2.start();


        TimeUnit.SECONDS.sleep(3);
        System.out.println("偏向结束后：list中第11个对象的对象头：");
        System.out.println(ClassLayout.parseInstance(listA.get(10)).toPrintable());
        System.out.println("偏向结束后：list中第26个对象的对象头：");
        System.out.println(ClassLayout.parseInstance(listA.get(25)).toPrintable());
        System.out.println("偏向结束后：list中第41个对象的对象头：");
        System.out.println(ClassLayout.parseInstance(listA.get(40)).toPrintable());
    }
}
