package com.jvm.t12_juc;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:01 上午 2020/8/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// java 内存模型 —— 有序性 理解
public final class T05_Juc_Singleton {
    private T05_Juc_Singleton() {} // 构造方法私有

    private static T05_Juc_Singleton INSTANCE = null;

    public static T05_Juc_Singleton getInstance() {
        // 实例没创建，才会进入内部的 synchronized 代码块
        if (INSTANCE == null) {
            synchronized (T05_Juc_Singleton.class) {
                // 也许有其他线程已经创建实例，所以再判断一次
                if (INSTANCE == null) {
                    INSTANCE = new T05_Juc_Singleton();
                }
            }
        }
        return INSTANCE;
    }
}
