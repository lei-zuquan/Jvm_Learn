package com.java.meet.c01_11_volatile;

import com.sun.tools.javap.resources.javap;

/**
 * 6_volatile不保证原子理论解释
 *
 * 使用javap -c或javap -verbose
 */

public class C_06_T1 {

    volatile int n = 0;

    /**
     * MyData.java ====> MyData.class ===> 字节码
     * n++ 被拆分成了3个指令
     * 执行getfield拿到原始n；
     * 执行iadd进行加1操作；
     * 执行putfield写把累加后的值写回
     *
     * 查看字节码，需要配置好External tools
     */

    /**
    /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/bin/javap -c com.java.meet.c01_11_volatile.C_06_T1
    Compiled from "C_06_T1.java"
    public class com.java.meet.c01_11_volatile.C_06_T1 {
        volatile int n;

  public com.java.meet.c01_11_volatile.C_06_T1();
        Code:
        0: aload_0
        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
        4: aload_0
        5: iconst_0
        6: putfield      #2                  // Field n:I
        9: return

        public void add();
        Code:
        0: aload_0
        1: dup
        2: getfield      #2                  // Field n:I
        5: iconst_1
        6: iadd
        7: putfield      #2                  // Field n:I
        10: return
    }

    Process finished with exit code 0
    */
    public void add(){
        n++;
    }
}
