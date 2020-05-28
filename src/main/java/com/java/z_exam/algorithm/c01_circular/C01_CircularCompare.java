package com.java.z_exam.algorithm.c01_circular;

import java.util.concurrent.TimeUnit;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-05-28 9:07
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C01_CircularCompare {
    public static void main(String[] args) throws Exception {
        int minTimes = 1;
        int maxTimes = 1 * 10000;

        int sryTime = 1000;
        int betterCnt = 0;
        int badCnt = 0;
        int sameCnt = 0;
        for (int i = 0; i < sryTime; i++) {
            long spend1 = minAndMaxCircular(minTimes, maxTimes);

            long spend2 = maxAndMinCircular(minTimes, maxTimes);
            if (spend1 < spend2) {
                betterCnt++;
            } else if (spend1 > spend2) {
                badCnt++;
            } else {
                sameCnt++;
            }

            System.out.println("----------------------------------------------测试：" + (i + 1));
            TimeUnit.MILLISECONDS.sleep(1);
        }

        System.out.println();
        System.out.println("====测试：" + sryTime + " 次， 效率更好出现：" + betterCnt + " 次" +
                " 效率更差出现：" + badCnt + " 次" + " 效率一样：" + sameCnt + " 次");
    }

    private static long minAndMaxCircular(int minTimes, int maxTimes) {
        long start = System.currentTimeMillis();
        long total = 0;
        for (int i = 0; i < minTimes; i++) {
            for (int j = 0; j < maxTimes; j++) {
                total++;
            }
        }
        long end = System.currentTimeMillis();
        long spend = end - start;
        System.out.println("minAndMaxCircular:" + spend + " 毫秒" + "\t循环：" + total + " 次");
        return spend;
    }

    private static long maxAndMinCircular(int minTimes, int maxTimes) {
        long start = System.currentTimeMillis();
        long total = 0;
        for (int i = 0; i < maxTimes; i++) {
            for (int j = 0; j < minTimes; j++) {
                total++;
            }
        }
        long end = System.currentTimeMillis();

        long spend = end - start;
        System.out.println("maxAndMinCircular:" + spend + " 毫秒" + "\t循环：" + total + " 次");
        return spend;
    }
}
