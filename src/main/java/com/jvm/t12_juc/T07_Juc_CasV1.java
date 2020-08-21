package com.jvm.t12_juc;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 12:38 下午 2020/8/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// java 内存模型 —— CAS 概述
public class T07_Juc_CasV1 {
    static int shareValue = 0;

    public static void main(String[] args) {
        // 需要不断尝试
//        while (true) {
//            int 旧值 = 共享变量; // 比如拿到了当前值 0
//            int 结果 = 旧值 + 1; // 在旧值 0 的基础上增加1， 正确结果是 1
//
//            /*
//             这时候如果别的线程把共享变量改成了 5，本线程的正确结果 1 就作废了，这时候
//             compareAndSwap 返回 false, 重新尝试，直到：
//             compareAndSwap 返回 true, 表示我本线程做修改的同时，别的线程没有干扰
//             */
//            if (compareAndSwap(旧值, 结果)) {
//                // 成功，退出循环
//            }
//        }
    }

































}
