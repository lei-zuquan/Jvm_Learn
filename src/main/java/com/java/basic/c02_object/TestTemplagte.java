package com.java.basic.c02_object;

import java.util.Arrays;
import java.util.Random;

/**
 * 模板设计模式（了解）：
 *
 * 模板：定好了框架，格式，结构。具体的内容需要使用者来填写。
 *      简历模板，论文模板，请假条的模板...
 *
 * 在开发中，遇到这样的情况：当解决某个问题时，总体的代码结构是确定的，步骤也是确定的，
 * 只是其中的一小步的具体步骤不确定，那么我们可以把这个不确定的步骤设计为抽象方法，让使用者实现它。
 *
 * 例如：编写一个类，它具有一个功能，可以计算"任意"一段代码的运行时间。
 * 步骤：
 * 1）获取开始时间start
 * 2）执行xxx代码
 * 3）获取结束时间end
 * 4）计算时间差（end - start）
 *
 * 提示：System.currentTimeMillis(): 得到当前的系统时间，距离1970-1-1，凌晨的毫秒数
 *
 */
public class TestTemplagte {

    public static void main(String[] args) {
        // 看一步求1-100000的累加和的运行时间
        MyCalTime m = new MyCalTime();
        long time = m.getTime();
        System.out.println("耗时：" + time + "毫秒");

        // 看一下，整数数组的产生，和排序的时间
        OtherCalTime otherCalTime = new OtherCalTime();
        time = otherCalTime.getTime();
        System.out.println("耗时：" + time + "毫秒");
    }
}

/**
 * 模板类
 */
abstract class CalTime{
    public long getTime(){
        // 1) 获取开始时间start
        long start = System.currentTimeMillis();

        // 2) 执行xxx代码
        doWork();

        // 3) 获取结束时间end
        long end = System.currentTimeMillis();

        // 4) 计算时间差（end - start）
        return end - start;
    }

    protected abstract void doWork(); // 代表执行xxx代码
}

class MyCalTime extends CalTime{
    @Override
    protected void doWork() {
        // 计算1-100000的累加和
        long sum = 0;
        for (int i = 0; i < 100000; i++) {
            sum += i;
        }
        System.out.println("i-100000的累加和：" + sum);
    }
}


class OtherCalTime extends CalTime{

    @Override
    protected void doWork() {
        // 计算长度为10的数组，用随机数为数组赋值，然后从小到大排序
        Random r = new Random();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            //arr[i] = r.nextInt(); // 随机产生int范围内的一个整数
            arr[i] = r.nextInt(100); // 随机产生[0,100) 范围内的一个整数
        }

        // 冒泡排痛了，n-1轮，本题是9轮
        for (int i = 1; i < arr.length; i++) {
            /**
             * 想要把大的往右/后移动
             * int j = 0; 每一轮从[0] 开始比较
             * 第一轮：比较9次，j=0,1,2,3,4,5,6,7.8    j<9
             */
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        // 遍历结果
        System.out.println(Arrays.toString(arr));
    }
}
