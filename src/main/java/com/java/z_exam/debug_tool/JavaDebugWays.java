package com.java.z_exam.debug_tool;

import java.time.LocalDate;
import java.util.Date;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:29 下午 2020/4/13
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
  JAVA 调试工具
  注意权限问题
  jps
      输出java 进程pid以及启动参数
      -q：只输出进程 ID
      -m：输出传入 main 方法的参数
      -l：输出完全的包名，应用主类名，jar的完全路径名
      -v：输出jvm参数
      -V：输出通过flag文件传递到JVM中的参数


  输出java 进程中各线程状态
        jstack —F PID

  会检测线程间是否有死锁
      jmap
      dump java进程内存状态快照
      如： jmap -histo PID
  jhat
      可以建立用于分析jmap dump出的快照文件的web ui
      内存泄漏分析
        gc log
  jstat
        实时输出堆内存各区域使用情况

  ============================================================
  第一步查看进程：
        Top或jps
  第二步查看进程所有线程：
        top -H -p PID 查找PID下面的线程id，显示线程的cpu的占用时间，占用比例，发现有很多个线程都会CPU占用很高，只能每个排查。
  第三步查看线程对应的十六进制：线程id是16进制表示，需要转一下
        printf "%x\n" 线程id
  第四步jstack查看线程信息
        jstack PID | grep "线程ID十六进制" -A 30
        jstack —F PID | grep "线程ID十六进制" -A 30
        jstack —F PID

  第五步，通过命名 jstat -gcutil 【PID】 1000 100 查看每秒钟gc的情况

 */
public class JavaDebugWays {
    // 运行时间，以天为划分间隔
    private Date runDate;
    private LocalDate runDay = LocalDate.now();

    public static void main(String[] args) throws Exception {
        JavaDebugWays myObject = new JavaDebugWays();

        while (true) {
            LocalDate currDay = LocalDate.now();
            if (currDay.getDayOfMonth() != myObject.runDay.getDayOfMonth()) {
                myObject.runDay = currDay;
                System.out.println("==================");
            }
        }
    }

    private void oldCheck() {
        JavaDebugWays myJavaObject = new JavaDebugWays();
        myJavaObject.runDate = new Date();

        while (true) {
            Date currDate = new Date();

            boolean isChange = myJavaObject.checkDateTimeIsChange(currDate);
            if (isChange) {
                System.out.println("==================");
            }
            //TimeUnit.MILLISECONDS.sleep(1);
        }
    }

    private boolean checkDateTimeIsChange(Date currDate) {
        // 如果当前天与之前记录的运行天不相等，则判定为新的一天
        if (currDate.getDate() != runDate.getDate()) {
            runDate = currDate;
            return true;
        }
        return false;

    }
}


/*
[root@node-02 ~]# jps
240099 Kafka
35332 ApplicationMaster
143111 CoarseGrainedExecutorBackend
171524 WebStockDataGetFromJydb-0.0.1-SNAPSHOT.jar
240971 DataNode
50056 CoarseGrainedExecutorBackend
143112 CoarseGrainedExecutorBackend
171689 WebStockData-0.0.1-SNAPSHOT.jar
239599 NodeManager
242861 kafkaGetStock-0.0.1-SNAPSHOT-jar-with-dependencies.jar
239085 QuorumPeerMain
226193 Jps
49881 ApplicationMaster
[root@node-02 ~]# jmap -histo 242861
242861: Unable to open socket file: target process not responding or HotSpot VM not loaded
The -F option can be used when the target process is not responding
[root@node-02 ~]# jmap 242861
Attaching to process ID 242861, please wait...
Debugger attached successfully.
Server compiler detected.
JVM version is 25.211-b12
0x0000000000400000      8K      /usr/java/jdk1.8.0_211-amd64/bin/java
0x00007fb7cc5ab000      103K    /usr/lib64/libresolv-2.17.so
0x00007fb7cc7c4000      30K     /usr/lib64/libnss_dns-2.17.so
0x00007fb7ce4e2000      91K     /usr/java/jdk1.8.0_211-amd64/jre/lib/amd64/libnio.so
0x00007fb7ce6f4000      110K    /usr/java/jdk1.8.0_211-amd64/jre/lib/amd64/libnet.so
0x00007fb7ce90b000      50K     /usr/java/jdk1.8.0_211-amd64/jre/lib/amd64/libmanagement.so
0x00007fb7efbd1000      124K    /usr/java/jdk1.8.0_211-amd64/jre/lib/amd64/libzip.so
0x00007fb7efded000      60K     /usr/lib64/libnss_files-2.17.so
0x00007fb7f4062000      226K    /usr/java/jdk1.8.0_211-amd64/jre/lib/amd64/libjava.so
0x00007fb7f4291000      64K     /usr/java/jdk1.8.0_211-amd64/jre/lib/amd64/libverify.so
0x00007fb7f44a0000      42K     /usr/lib64/librt-2.17.so
0x00007fb7f46a8000      1110K   /usr/lib64/libm-2.17.so
0x00007fb7f49aa000      16645K  /usr/java/jdk1.8.0_211-amd64/jre/lib/amd64/server/libjvm.so
0x00007fb7f5993000      2101K   /usr/lib64/libc-2.17.so
0x00007fb7f5d60000      18K     /usr/lib64/libdl-2.17.so
0x00007fb7f5f64000      106K    /usr/java/jdk1.8.0_211-amd64/lib/amd64/jli/libjli.so
0x00007fb7f617c000      138K    /usr/lib64/libpthread-2.17.so
0x00007fb7f6398000      159K    /usr/lib64/ld-2.17.so
[root@node-02 ~]# top
top - 10:56:28 up 19 days, 18:22,  1 user,  load average: 0.54, 0.45, 0.38
Tasks: 164 total,   1 running, 163 sleeping,   0 stopped,   0 zombie
%Cpu(s):  9.2 us,  1.4 sy,  0.0 ni, 86.3 id,  0.0 wa,  0.0 hi,  0.1 si,  3.1 st
KiB Mem : 32913832 total,   458288 free,  9734860 used, 22720684 buff/cache
KiB Swap:  4063228 total,  4028148 free,    35080 used. 21958420 avail Mem

   PID USER      PR  NI    VIRT    RES    SHR S  %CPU %MEM     TIME+ COMMAND
 50056 yarn      20   0 4275448   1.0g  40976 S  48.0  3.3 448:20.65 java
 49881 yarn      20   0 3368532   1.1g  41288 S  21.9  3.5 241:31.52 java
242861 root      20   0   12.2g 251248  13092 S   6.3  0.8  94:58.00 java
239599 yarn      20   0 3147096 824152  13236 S   3.3  2.5 367:16.51 java
240099 kafka     20   0 6500692 693072  16456 S   2.3  2.1   1980:41 java
240971 hdfs      20   0 2946932   1.0g  13356 S   1.3  3.3 285:28.90 java
     9 root      20   0       0      0      0 S   1.0  0.0  30:58.47 rcu_sched
 35332 yarn      20   0 3311652 777788  41200 S   0.7  2.4  67:15.48 java
143112 yarn      20   0 7438612 853768  40916 S   0.7  2.6   6:18.45 java
227890 root      20   0  161992   2328   1592 R   0.7  0.0   0:00.02 top
239085 zookeep+  20   0 5644804 473092  12980 S   0.7  1.4  74:28.41 java
    34 root      20   0       0      0      0 S   0.3  0.0   1:39.51 ksoftirqd/5
   465 root       0 -20       0      0      0 S   0.3  0.0   0:53.77 kworker/5:1H
143111 yarn      20   0 7427064   1.2g  40920 S   0.3  3.7   6:35.88 java
236100 root      20   0 2168976  63092   2672 S   0.3  0.2 283:04.12 cmf-agent
236342 root      20   0  687468  18008   3916 S   0.3  0.1  34:56.86 python2.7
     1 root      20   0  191140   2968   1884 S   0.0  0.0   7:50.01 systemd
     2 root      20   0       0      0      0 S   0.0  0.0   0:00.53 kthreadd
     3 root      20   0       0      0      0 S   0.0  0.0   0:15.86 ksoftirqd/0
     5 root       0 -20       0      0      0 S   0.0  0.0   0:00.00 kworker/0:0H
     7 root      rt   0       0      0      0 S   0.0  0.0   0:03.49 migration/0
     8 root      20   0       0      0      0 S   0.0  0.0   0:00.00 rcu_bh
    10 root       0 -20       0      0      0 S   0.0  0.0   0:00.00 lru-add-drain
    11 root      rt   0       0      0      0 S   0.0  0.0   0:07.82 watchdog/0
    12 root      rt   0       0      0      0 S   0.0  0.0   0:06.34 watchdog/1
    13 root      rt   0       0      0      0 S   0.0  0.0   0:05.49 migration/1
    14 root      20   0       0      0      0 S   0.0  0.0   0:17.46 ksoftirqd/1
    16 root       0 -20       0      0      0 S   0.0  0.0   0:00.00 kworker/1:0H
    17 root      rt   0       0      0      0 S   0.0  0.0   0:06.34 watchdog/2
    18 root      rt   0       0      0      0 S   0.0  0.0   0:02.76 migration/2
    19 root      20   0       0      0      0 S   0.0  0.0   0:31.28 ksoftirqd/2
    21 root       0 -20       0      0      0 S   0.0  0.0   0:00.00 kworker/2:0H
    22 root      rt   0       0      0      0 S   0.0  0.0   0:06.39 watchdog/3
    23 root      rt   0       0      0      0 S   0.0  0.0   0:04.41 migration/3
    24 root      20   0       0      0      0 S   0.0  0.0   0:03.66 ksoftirqd/3
    26 root       0 -20       0      0      0 S   0.0  0.0   0:00.00 kworker/3:0H
[root@node-02 ~]# jps
240099 Kafka
35332 ApplicationMaster
143111 CoarseGrainedExecutorBackend
171524 WebStockDataGetFromJydb-0.0.1-SNAPSHOT.jar
240971 DataNode
50056 CoarseGrainedExecutorBackend
228361 Jps
143112 CoarseGrainedExecutorBackend
171689 WebStockData-0.0.1-SNAPSHOT.jar
239599 NodeManager
242861 kafkaGetStock-0.0.1-SNAPSHOT-jar-with-dependencies.jar
239085 QuorumPeerMain
49881 ApplicationMaster
[root@node-02 ~]# ps aux | grep 242861
root     228439  0.0  0.0 112724   988 pts/0    S+   10:57   0:00 grep --color=auto 242861
root     242861  0.5  0.7 12760044 250920 ?     Sl   5月15  94:59 java -jar /root/kafkaGetStock-0.0.1-SNAPSHOT-jar-with-dependencies.jar 1 9 5000 100
[root@node-02 ~]# top -H -p 242861
top - 10:59:25 up 19 days, 18:25,  1 user,  load average: 0.36, 0.46, 0.40
Threads:  42 total,   0 running,  42 sleeping,   0 stopped,   0 zombie
%Cpu(s): 13.1 us,  2.0 sy,  0.0 ni, 78.3 id,  0.2 wa,  0.0 hi,  0.1 si,  6.3 st
KiB Mem : 32913832 total,   243184 free, 10040808 used, 22629840 buff/cache
KiB Swap:  4063228 total,  4028148 free,    35080 used. 21653096 avail Mem

   PID USER      PR  NI    VIRT    RES    SHR S %CPU %MEM     TIME+ COMMAND
242887 root      20   0   12.2g 250920  13092 S  0.7  0.8   6:38.95 java
242889 root      20   0   12.2g 250920  13092 S  0.7  0.8   6:34.60 java
242864 root      20   0   12.2g 250920  13092 S  0.3  0.8   1:33.39 java
242865 root      20   0   12.2g 250920  13092 S  0.3  0.8   1:32.90 java
242866 root      20   0   12.2g 250920  13092 S  0.3  0.8   1:33.46 java
242868 root      20   0   12.2g 250920  13092 S  0.3  0.8   1:32.90 java
242880 root      20   0   12.2g 250920  13092 S  0.3  0.8   1:12.73 java
242881 root      20   0   12.2g 250920  13092 S  0.3  0.8   6:39.84 java
242883 root      20   0   12.2g 250920  13092 S  0.3  0.8   6:33.87 java
242891 root      20   0   12.2g 250920  13092 S  0.3  0.8   6:34.74 java
242895 root      20   0   12.2g 250920  13092 S  0.3  0.8   6:35.35 java
242897 root      20   0   12.2g 250920  13092 S  0.3  0.8   6:40.11 java
242900 root      20   0   12.2g 250920  13092 S  0.3  0.8   0:30.56 java
242861 root      20   0   12.2g 250920  13092 S  0.0  0.8   0:00.00 java
242862 root      20   0   12.2g 250920  13092 S  0.0  0.8   0:00.62 java
242863 root      20   0   12.2g 250920  13092 S  0.0  0.8   1:33.20 java
242867 root      20   0   12.2g 250920  13092 S  0.0  0.8   1:32.87 java
242869 root      20   0   12.2g 250920  13092 S  0.0  0.8   2:38.96 java
242870 root      20   0   12.2g 250920  13092 S  0.0  0.8   0:00.05 java
242871 root      20   0   12.2g 250920  13092 S  0.0  0.8   0:00.05 java
242872 root      20   0   12.2g 250920  13092 S  0.0  0.8   0:00.00 java
242873 root      20   0   12.2g 250920  13092 S  0.0  0.8   0:21.52 java
242874 root      20   0   12.2g 250920  13092 S  0.0  0.8   0:20.13 java
242875 root      20   0   12.2g 250920  13092 S  0.0  0.8   0:09.65 java
242876 root      20   0   12.2g 250920  13092 S  0.0  0.8   0:00.00 java
242877 root      20   0   12.2g 250920  13092 S  0.0  0.8  11:01.41 java
242882 root      20   0   12.2g 250920  13092 S  0.0  0.8   1:03.88 java
242884 root      20   0   12.2g 250920  13092 S  0.0  0.8   1:04.71 java
242885 root      20   0   12.2g 250920  13092 S  0.0  0.8   6:34.17 java
242886 root      20   0   12.2g 250920  13092 S  0.0  0.8   1:11.18 java
242888 root      20   0   12.2g 250920  13092 S  0.0  0.8   1:04.59 java
242890 root      20   0   12.2g 250920  13092 S  0.0  0.8   1:04.39 java
242892 root      20   0   12.2g 250920  13092 S  0.0  0.8   1:12.23 java
242893 root      20   0   12.2g 250920  13092 S  0.0  0.8   6:37.17 java
242894 root      20   0   12.2g 250920  13092 S  0.0  0.8   1:04.34 java
242896 root      20   0   12.2g 250920  13092 S  0.0  0.8   1:04.98 java
[root@node-02 ~]# printf "%x\n" 242897
3b4d1
[root@node-02 ~]# jstack 242897 | grep "3b4d1" -A 30
242897: Unable to open socket file: target process not responding or HotSpot VM not loaded
The -F option can be used when the target process is not responding
[root@node-02 ~]# jstack -F 242897 | grep "3b4d1" -A 30
sun.jvm.hotspot.debugger.DebuggerException: sun.jvm.hotspot.debugger.DebuggerException: get_thread_regs failed for a lwp


[root@node-02 ~]# jstack -F 242877 | grep "3b4bd"
sun.jvm.hotspot.debugger.DebuggerException: sun.jvm.hotspot.debugger.DebuggerException: get_thread_regs failed for a lwp
        at sun.jvm.hotspot.debugger.linux.LinuxDebuggerLocal$LinuxDebuggerLocalWorkerThread.execute(LinuxDebuggerLocal.java:163)
        at sun.jvm.hotspot.debugger.linux.LinuxDebuggerLocal.getThreadIntegerRegisterSet(LinuxDebuggerLocal.java:482)
        at sun.jvm.hotspot.debugger.linux.LinuxThread.getContext(LinuxThread.java:65)
        at sun.jvm.hotspot.runtime.linux_amd64.LinuxAMD64JavaThreadPDAccess.getCurrentFrameGuess(LinuxAMD64JavaThreadPDAccess.java:93)
        at sun.jvm.hotspot.runtime.JavaThread.getCurrentFrameGuess(JavaThread.java:256)
        at sun.jvm.hotspot.runtime.JavaThread.getLastJavaVFrameDbg(JavaThread.java:218)
        at sun.jvm.hotspot.tools.StackTrace.run(StackTrace.java:86)
        at sun.jvm.hotspot.tools.StackTrace.run(StackTrace.java:45)
        at sun.jvm.hotspot.tools.JStack.run(JStack.java:66)
        at sun.jvm.hotspot.tools.Tool.startInternal(Tool.java:260)
        at sun.jvm.hotspot.tools.Tool.start(Tool.java:223)
        at sun.jvm.hotspot.tools.Tool.execute(Tool.java:118)
        at sun.jvm.hotspot.tools.JStack.main(JStack.java:92)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at sun.tools.jstack.JStack.runJStackTool(JStack.java:140)
        at sun.tools.jstack.JStack.main(JStack.java:106)
Caused by: sun.jvm.hotspot.debugger.DebuggerException: get_thread_regs failed for a lwp
        at sun.jvm.hotspot.debugger.linux.LinuxDebuggerLocal.getThreadIntegerRegisterSet0(Native Method)
        at sun.jvm.hotspot.debugger.linux.LinuxDebuggerLocal.access$800(LinuxDebuggerLocal.java:62)
        at sun.jvm.hotspot.debugger.linux.LinuxDebuggerLocal$1GetThreadIntegerRegisterSetTask.doit(LinuxDebuggerLocal.java:476)
        at sun.jvm.hotspot.debugger.linux.LinuxDebuggerLocal$LinuxDebuggerLocalWorkerThread.run(LinuxDebuggerLocal.java:138)
sun.jvm.hotspot.debugger.DebuggerException: sun.jvm.hotspot.debugger.DebuggerException: get_thread_regs failed for a lwp
        at sun.jvm.hotspot.debugger.linux.LinuxDebuggerLocal$LinuxDebuggerLocalWorkerThread.execute(LinuxDebuggerLocal.java:163)

 */