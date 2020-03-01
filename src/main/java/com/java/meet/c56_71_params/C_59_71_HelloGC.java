package com.java.meet.c56_71_params;

/**
 * 59_JVM的标配参数和X参数
 * 60_JVM的XX参数之布尔类型
 * 61_JVM的XX参数设置类型
 * 62_JVM的XX参数之XmsXmx坑题
 * 63_JVM盘点家底查看修改变更值
 * 64_JVM盘点家底查看修改变更值
 *
 *
 * 你说你做过JVM调优和参数配置，请问如何盘点查看JVM系统默认值
 *      JVM的参数类型
 *          1.标配类型
 *              -version
 *              -help
 *              java -showversion
 *
 *          2.x参数（了解）
 *              -Xint   解释执行
 *              -Xcomp  第一次使用就编译成本地代码
 *              -Xmixed 混合模式
 *
 *          3.xx参数（重点）
 *              Boolean类型
 *                  公式
 *                      -XX: +或者 -某个属性值
 *                      +表示开启
 *                      -表示关闭
 *                  case
 *                      是否打印GC收集细节
 *                          -XX:-PrintGCDetails     先jps -l；再jinfo -flag PrintGCDetails 11422
 *                          -XX:+PrintGCDetails
 *
 *                      是否使用串行垃圾回收器
 *                          -XX:-UseSerialGC
 *                          -XX:+UseSerialGC
 *
 *              kv设值类型
 *                  公式
 *                      -XX:属性key=属性值value
 *                  case
 *                      -XX:MetaspaceSize=128m  (元空间)
 *                      -XX:MaxTenuringThreshold=15 （多少次minorgc可以到老年代）
 *
 *
 *              jinfo举例，如何查看当前运行程序的配置
 *                  公式
 *                      jinfo -flag 配置项  进程编号
 *                      jinfo -flags 进程编号(搜索目前能搜索到的全部参数)；其中Non-default是系统默认，Command line:是人为自定义参数
 *
 *              题外话（坑题）
 *                  两个经典参数：-Xms和-Xmx
 *
 *                  这个你如何解释：
 *                          -Xms    等价于-XX:InitialHeapSize(初始化堆内存)
 *                          -Xmx    等价于-XX:MaxHeapSize（最大堆内存）
*/


/**
 * 第一种，查看参数盘点家底
 * jps
 * jinfo -flag 具体参数 java进程编号
 * jinfo -flags        java进程编号
 *
 * 第二种，查看参数盘点家底
 *
 * 【重点】盘点家底查看JVM默认值
 *      -XX:+PrintFlagsInital
 *              主要查看初始默认
 *              公式
 *                      java -XX:PrintFlagsInitial -version
 *                      java -XX:+PrintFlagsInitial  (JVM调优这个参数非常非常重要)
 *              case
 *
 *      -XX:+PrintFlagsFinal
 *              主要查看修改更新
 *              公式
 *                      java -XX:PrintFlagsFinal -version
 *                      java -XX:+PrintFlagsFinal  (查看默认jvm参数)
 *                      说明：如果只是一个=号，代表没有修改过的；如果有:=代表人为修改过或jvm默认修改过
 *              case
 *
 *
 *      PrintFlagsFinal举例，运行java命令的同时打印出参数
 *                      运行一个java程序
 *  *                   java -XX:+PrintFlagsFinal -XX:MetaspaceSize=512m T
 *
 *      -XX:+PrintCommandLineFlags(查看垃圾回收器，java8默认是并行垃圾回收器)
 *                      如：java -XX:+PrintCommandLineFlags -version
 *                      -XX:InitialHeapSize=134217728 -XX:MaxHeapSize=2147483648 -XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseParallelGC
 *                      java version "1.8.0_241"
 *                      Java(TM) SE Runtime Environment (build 1.8.0_241-b07)
 *                      Java HotSpot(TM) 64-Bit Server VM (build 25.241-b07, mixed mode)
 *
 *
 *
 */



public class C_59_71_HelloGC {

    public static void main(String[] args) throws Exception{
        method59_64();
        return;

    }

    private static void method59_64() throws InterruptedException {
        System.out.println("********HelloGC");

        Thread.sleep(Integer.MAX_VALUE);

        // 在idea添加JVM运行参数：Run --> Edit Configurations --> 找到需要调节的应用程序

        /**
         * 如何查看一个正在运行中的java程序，它的某个jvm参数是否开启？具体值是多少？
         * jps：查看java后台进程，可在Terminal输入jps -l
         * jinfo：查看正在运行java程序的各种信息；
         *      如：jinfo -flag PrintGCDetails 11422
         *      leizuquan@leizuquandeMacBook-Air JvmLearn % jinfo -flag PrintGCDetails 11422
         *      -XX:-PrintGCDetails
         *      从上面的输出我们可以看出没有开启打印GC收集细节信息
         *
         *      这时，我们在idea中的Run -> Edit Configurations -> VM Options 中输入：-XX:+PrintGCDetails
         *      重复上述查看操作，jps -l与jinfo -flag PrintGCDetails 11422
         */}


    /**
     * 65_堆内存初始大小快速复习
     * 66_常用基础参数栈内存Xss
     * 67_常用基础参数元空间MetaspaceSize
     * 68_常用基础参数PrintGCDetails回收前后对比详解
     * 69_常用基础参数SurvivorRation讲解
     * 70_常用基础参数NewRation
     * 71_常用基础参数MaxTenuringThreshold
     *
     * 你平时工作用过的JVM常用基本配置参数有哪些？
     *      基础知识复习
     *          JDK1.8之后将最初的永久代取消了，由元空间取代。元空间的本质和永久代类似。
     *
     *          元空间（Java8）与永久代（Java7)之间最大的区别在于：
     *              永久代使用的JVM的堆内存，但是java8以后的元空间并不在虚拟机中而是使用本机物理内存。
     *
     *          因此，默认情况下，元空间的大小仅受本地内存限制。类的元数据放入native memeory，
     *          字符串池和类的静态变量放入java堆中，这样可以加载多少类的元数据不再由MaxPermSize控制，
     *          而由系统的实际可用空间来控制。
     *          <------Minor GC----------->  <-------------Major GC----------->
     *            Eden | s0 | s1            | Old Memory        | 元空间
     *          <----------------JVM Heap(-Xms -Xmx)------------>
     *          <----- Young Gen(-Xmn) -----><
     *
     *      常用参数【重点】另外最好看jdk官方说明文档：docs.oracle.com/javase/8/docs/index.html
     *              -Xms                初始大小内存，默认为物理内存1/64；等价于-XX:InitialHeapSize
     *              -Xmx                最大分配内存，默认为物理内存1/4；等价于-XX:MaxHeapSize
     *              -Xss                设置单个线程栈的大小，一般默认为512k~1024k；等价于-XX:ThreadStackSize；如果查询时此值为0，则代表默认为，因多数64位平台都是1024k
     *                                  如：在idea-run-vm options中输入：-Xss160k，然后jps -l，再jinfo -flag ThreadStackSize 1288
     *
     *              -Xmm                设置年轻代大小，这个参数一般不调节，除非有一些基础的情况
     *              -XX:MetaspaceSize（此参数经常会调节）
     *                          设置元空间大小
     *                                  元空间的本质和永久代类似，都是对JVM规范中方法区的实现。
     *                                  不过元空间与永久代之间最大的区别在于：
     *                                      元空间并不在虚拟机中，而是使用本地内存。
     *                                      因此，默认情况下，元空间的大小仅受本地内存限制
     *                          -Xmx10m -Xmx10m -XX:MetaspaceSize=1024m -XX:+PrintFlagsFinal
     *                          示例：
     *                              -XX:+PrintCommandLineFlags可以让在程序运行前打印出用户手动设置或者JVM自动设置的XX选项，建议加上这个选项以辅助问题诊断。
     *                              -XX:+PrintGCDetails 这个选项会打印出更多的GC日志，不同的收集器产生的日志会不一样。
     *                              初始内存128m；最大堆内存4g；初始栈大小1024k；元空间512m；串行垃圾回收器
     *                              -Xms128m -Xmx4096m -Xss1024k -XX:MetaspaceSize=512m -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseSerialGC
     *                              -Xms128m -Xmx4096m -Xss1024k -XX:MetaspaceSize=512m -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseSerialGC
     *              典型设置案例
     *              -XX:+PrintGCDetails(重点)
     *                          如：-XX:+PrintGCDetails
     *                             -Xms10m -Xmx10m -XX:+PrintGCDetails
     *
     *                          输出详细GC收集日志信息
     *
     *                          GC
     *
     *                          FullGC
     *
     *              -XX:SurvivorRatio（工作中一般不调节）
     *                          设置新生代中eden和s0/s1空间的比例，默认-XX:SurvivorRatio=8,Eden:s0:s1=8:1:1
     *                          假如
     *                          -XX:SurvivorRatio=4,Eden:s0:s1=4:1:1
     *                          SurvivorRatio值就是设置eden区的比例占多少，s0/s1相同
     *                          默认
     *                          Eden:s0:s1 = 8:1:1
     *                          实操：
     *                          -XX:+PrintGCDetails -XX:+UseSerialGC -Xms10m -Xmx10m
     *                          -XX:+PrintGCDetails -XX:+UseSerialGC -Xms10m -Xmx10m -XX:SurvivorRatio=8
     *                          Eden:s0:s1 = 4:1:1
     *                          实操：
     *                          -XX:+PrintGCDetails -XX:+UseSerialGC -Xms10m -Xmx10m -XX:SurvivorRatio=4
     *
     *              -XX:NewRatio（工作中一般不调节）
     *                          配置年轻代与老年代在堆结构的占比。默认，-XX:NewRatio=2新生代占1，老年代2，年轻代占整个堆的1/3
     *                          假如：-XX:NewRatio=4新生代占1，老年代4，年轻代占整个堆1/5
     *                          NewRatio值就是设置老年代的占比，剩下的1给新生代
     *                          实操：idea-run-vm option中输入
     *                          默认：-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseSerialGC -XX:NewRatio=2
     *                          修改：-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseSerialGC -XX:NewRatio=4
     *
     *              -XX:MaxTenuringThreshold（工作中一般不调节）
     *                          设置垃圾最大年龄
     *
     *                          实操：idea -> run -> vm options : -XX:MaxTenuringThreshold=12
     *                          Terminal中输入: jps -l
     *                          jinfo -flag MaxTenuringThreshold
     *
     *                          -XX:MaxTenuringThreshold=0: 设置垃圾最大年龄。如果设置为0的话，则年轻代对象不经过Survivor区，直接进入
     *                          老年代。对于老年代比较多的应用，可以提高效率。如果将此值设置为一个较大值，则年轻代对象会在Survivor区进行
     *                          多次复制，这样可以增加对象再年轻代的存活时间，增加在年轻代即被回收的概论。
     *
     */
    public static void method65(){
        // idea中的run --> vm options 什么都不配置
        long totalMemory = Runtime.getRuntime().totalMemory();// 返回Java虚拟机的内存总量
        long maxMemory = Runtime.getRuntime().maxMemory();// 返回Java虚拟机试图使用的最大内存量。
        System.out.println("初始的虚拟机内存大约是物理内存的64分之一：TOTAL_MEMORY(-Xms) = " + totalMemory + "(字节)：" + (totalMemory / (double)1024 / 1024) + "MB");
        System.out.println("虚拟机试图使用最内存大约是物理内存的4分之一：MAX_MEMORY(-Xmx) = " + maxMemory + "(字节)：" + (maxMemory / (double)1024 / 1024) + "MB");
    }

    public static void method68(){
        System.out.println("********HelloGC");
        // 首先在idea -> run -> vm options:输入 -Xms10m -Xmx10m -XX:+PrintGCDetails
        byte[] byteArray = new byte[1 * 1024 * 1024];
    }
}
