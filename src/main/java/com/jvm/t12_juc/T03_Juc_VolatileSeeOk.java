package com.jvm.t12_juc;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:41 下午 2020/8/20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// java 内存模型 —— 可见性 Volatile 解决
public class T03_Juc_VolatileSeeOk {
    //volatile static boolean run  = true;
    static boolean run  = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (run) {
                System.out.println(1);
            }
        });
        t.start();

        Thread.sleep(1000);
        run = false; // 线程t 不会如预想的那样停下来
    }
}
