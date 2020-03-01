package com.java.meet.c01_11_volatile;

import com.sun.tools.javap.resources.javap;

public class C_11_SingletonDemoT1 {
    /**
    /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/bin/javap -c com.java.meet.c01_11_volatile.C_11_SingletonDemoT1
    Compiled from "C_11_SingletonDemoT1.java"
    public class com.java.meet.c01_11_volatile.C_11_SingletonDemoT1 {
  public com.java.meet.c01_11_volatile.C_11_SingletonDemoT1();
        Code:
        0: aload_0
        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
        4: return

        public static void main(java.lang.String[]);
        Code:
        0: new           #2                  // class com/java/meet/c01_11_volatile/C_11_SingletonDemoT1
        3: dup
        4: invokespecial #3                  // Method "<init>":()V
        7: astore_1
        8: return
    }

    Process finished with exit code 0
    */
    public static void main(String[] args) {
        C_11_SingletonDemoT1 t1 = new C_11_SingletonDemoT1();
    }
}
