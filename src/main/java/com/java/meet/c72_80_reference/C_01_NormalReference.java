package com.java.meet.c72_80_reference;

import java.io.IOException;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:18 上午 2020/4/13
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C_01_NormalReference {
    public static void main(String[] args) throws IOException {
        C_01M m = new C_01M();
        m = null;

        System.gc(); // DisableExplicitGC
        System.out.println(m);

        System.in.read(); // 阻塞main线程，给垃圾回收线程时间执行
    }
}
