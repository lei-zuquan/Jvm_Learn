package com.java.z_exam.dead_lock;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-03-31 10:00
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import java.util.concurrent.TimeUnit;

/**
 * 查看程序是否发生死锁：
 * jstack 7552
 */
public class DeadLockSimple extends Thread {
    private String lockA;
    private String lockB;

    public DeadLockSimple(String name, String lockA, String lockB) {
        super(name);
        this.lockA = lockA;
        this.lockB = lockB;
    }

    public void run() {
        synchronized (lockA) {
            System.out.println(this.getName() + " hold: --> " + lockA);
            try {
                TimeUnit.SECONDS.sleep(4);
                synchronized (lockB) {
                    System.out.println(this.getName() + " hold: --> " + lockB);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        String lockA = "lockA";
        String lockB = "lockB";
        DeadLockSimple t1 = new DeadLockSimple("thread1", lockA, lockB);
        DeadLockSimple t2 = new DeadLockSimple("thread2", lockB, lockA);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}


/*
C:\Users\leizuquan>jstack 7552
2020-03-31 10:09:49
Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.211-b12 mixed mode):

"thread2" #15 prio=5 os_prio=0 tid=0x0000000023678800 nid=0x1344 waiting for monitor entry [0x000000002464e000]
java.lang.Thread.State: BLOCKED (on object monitor)
at com.java.z_exam.dead_lock.DeadLockSimple.run(DeadLockSimple.java:29)
- waiting to lock <0x0000000740d2fc40> (a java.lang.String)
- locked <0x0000000740d2fc78> (a java.lang.String)

"thread1" #14 prio=5 os_prio=0 tid=0x0000000023606000 nid=0x1124 waiting for monitor entry [0x000000002454f000]
java.lang.Thread.State: BLOCKED (on object monitor)
at com.java.z_exam.dead_lock.DeadLockSimple.run(DeadLockSimple.java:29)
- waiting to lock <0x0000000740d2fc78> (a java.lang.String)
- locked <0x0000000740d2fc40> (a java.lang.String)

"Service Thread" #13 daemon prio=9 os_prio=0 tid=0x00000000234e3800 nid=0xf8 runnable [0x0000000000000000]
java.lang.Thread.State: RUNNABLE

"C1 CompilerThread3" #12 daemon prio=9 os_prio=2 tid=0x00000000234a3800 nid=0x934 waiting on condition [0x0000000000000000]
java.lang.Thread.State: RUNNABLE

"C2 CompilerThread2" #11 daemon prio=9 os_prio=2 tid=0x00000000234a3000 nid=0x8c8 waiting on condition [0x0000000000000000]
java.lang.Thread.State: RUNNABLE

"C2 CompilerThread1" #10 daemon prio=9 os_prio=2 tid=0x000000002349a000 nid=0x1b6c waiting on condition [0x0000000000000000]
java.lang.Thread.State: RUNNABLE

"C2 CompilerThread0" #9 daemon prio=9 os_prio=2 tid=0x0000000023499000 nid=0x2ecc waiting on condition [0x0000000000000000]
java.lang.Thread.State: RUNNABLE

"JDWP Command Reader" #8 daemon prio=10 os_prio=0 tid=0x00000000233b9800 nid=0xe78 runnable [0x0000000000000000]
java.lang.Thread.State: RUNNABLE

"JDWP Event Helper Thread" #7 daemon prio=10 os_prio=0 tid=0x00000000233b4800 nid=0x1bc4 runnable [0x0000000000000000]
java.lang.Thread.State: RUNNABLE

"JDWP Transport Listener: dt_shmem" #6 daemon prio=10 os_prio=0 tid=0x00000000233a8000 nid=0xd1c runnable [0x0000000000000000]
java.lang.Thread.State: RUNNABLE

"Attach Listener" #5 daemon prio=5 os_prio=2 tid=0x0000000023349000 nid=0x135c waiting on condition [0x0000000000000000]
java.lang.Thread.State: RUNNABLE

"Signal Dispatcher" #4 daemon prio=9 os_prio=2 tid=0x0000000023348800 nid=0xf54 runnable [0x0000000000000000]
java.lang.Thread.State: RUNNABLE

"Finalizer" #3 daemon prio=8 os_prio=1 tid=0x000000000303e000 nid=0x588 in Object.wait() [0x000000002390e000]
java.lang.Thread.State: WAITING (on object monitor)
at java.lang.Object.wait(Native Method)
- waiting on <0x0000000740788ed0> (a java.lang.ref.ReferenceQueue$Lock)
at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:144)
- locked <0x0000000740788ed0> (a java.lang.ref.ReferenceQueue$Lock)
at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:165)
at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:216)

"Reference Handler" #2 daemon prio=10 os_prio=2 tid=0x0000000023330800 nid=0x1b80 in Object.wait() [0x000000002380f000]
java.lang.Thread.State: WAITING (on object monitor)
at java.lang.Object.wait(Native Method)
- waiting on <0x0000000740786bf8> (a java.lang.ref.Reference$Lock)
at java.lang.Object.wait(Object.java:502)
at java.lang.ref.Reference.tryHandlePending(Reference.java:191)
- locked <0x0000000740786bf8> (a java.lang.ref.Reference$Lock)
at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:153)

"main" #1 prio=5 os_prio=0 tid=0x0000000002f43800 nid=0xa80 in Object.wait() [0x0000000002d1f000]
java.lang.Thread.State: WAITING (on object monitor)
at java.lang.Object.wait(Native Method)
- waiting on <0x0000000740d2fcb0> (a com.java.z_exam.dead_lock.DeadLockSimple)
at java.lang.Thread.join(Thread.java:1252)
- locked <0x0000000740d2fcb0> (a com.java.z_exam.dead_lock.DeadLockSimple)
at java.lang.Thread.join(Thread.java:1326)
at com.java.z_exam.dead_lock.DeadLockSimple.main(DeadLockSimple.java:46)

"VM Thread" os_prio=2 tid=0x000000002153a000 nid=0xe44 runnable

"GC task thread#0 (ParallelGC)" os_prio=0 tid=0x0000000002f59000 nid=0x2ac runnable

"GC task thread#1 (ParallelGC)" os_prio=0 tid=0x0000000002f5a800 nid=0xf00 runnable

"GC task thread#2 (ParallelGC)" os_prio=0 tid=0x0000000002f5c000 nid=0xd74 runnable

"GC task thread#3 (ParallelGC)" os_prio=0 tid=0x0000000002f5f800 nid=0x2e48 runnable

"GC task thread#4 (ParallelGC)" os_prio=0 tid=0x0000000002f60800 nid=0x22ac runnable

"GC task thread#5 (ParallelGC)" os_prio=0 tid=0x0000000002f61800 nid=0x3050 runnable

"GC task thread#6 (ParallelGC)" os_prio=0 tid=0x0000000002f65000 nid=0xd44 runnable

"GC task thread#7 (ParallelGC)" os_prio=0 tid=0x0000000002f66000 nid=0x1f44 runnable

"VM Periodic Task Thread" os_prio=2 tid=0x00000000235b1800 nid=0x2f60 waiting on condition

JNI global references: 1921


Found one Java-level deadlock:
=============================
"thread2":
waiting to lock monitor 0x000000000303d9c8 (object 0x0000000740d2fc40, a java.lang.String),
which is held by "thread1"
"thread1":
waiting to lock monitor 0x000000000303d5a8 (object 0x0000000740d2fc78, a java.lang.String),
which is held by "thread2"

Java stack information for the threads listed above:
===================================================
"thread2":
at com.java.z_exam.dead_lock.DeadLockSimple.run(DeadLockSimple.java:29)
- waiting to lock <0x0000000740d2fc40> (a java.lang.String)
- locked <0x0000000740d2fc78> (a java.lang.String)
"thread1":
at com.java.z_exam.dead_lock.DeadLockSimple.run(DeadLockSimple.java:29)
- waiting to lock <0x0000000740d2fc78> (a java.lang.String)
- locked <0x0000000740d2fc40> (a java.lang.String)

Found 1 deadlock.


C:\Users\leizuquan>

 */