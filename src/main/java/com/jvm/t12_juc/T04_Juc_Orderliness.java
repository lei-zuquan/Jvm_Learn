package com.jvm.t12_juc;

import org.openjdk.jcstress.annotations.*;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:12 上午 2020/8/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// java 内存模型 —— 有序性 问题
@JCStressTest
@Outcome(id = {"1", "4"}, expect = Expect.ACCEPTABLE, desc = "ok")
@Outcome(id = "o", expect = Expect.ACCEPTABLE_INTERESTING, desc = "!!!!")
@State
public class T04_Juc_Orderliness {
    int num = 0;
    volatile boolean ready = false;

    // 线程1 执行此方法
    @Actor
    public void actor1(I_Result r){
        if (ready) {
            r.r1 = num + num;
        } else {
            r.r1 = 1;
        }
    }
    // 线程2 执行此方法
    @Actor
    public void actor2(I_Result r) {
        num = 2;
        ready = true;
    }
}

class I_Result {
    public int r1;
}