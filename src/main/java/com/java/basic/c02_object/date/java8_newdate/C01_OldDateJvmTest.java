package com.java.basic.c02_object.date.java8_newdate;

import java.util.Date;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-04-23 16:55
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C01_OldDateJvmTest {
    public static void main(String[] args) {
        while (true) {
            Date connectDate = new Date();
            Date currDate = new Date();

            long currtTime = currDate.getTime();
            long connectTime = connectDate.getTime();
            long freeSpendTime = currtTime - connectTime;
            if (freeSpendTime > 2000) {
                System.out.println("freeSpendTime：" + freeSpendTime);
            }
//            try {
//                //TimeUnit.MILLISECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

    }
}
