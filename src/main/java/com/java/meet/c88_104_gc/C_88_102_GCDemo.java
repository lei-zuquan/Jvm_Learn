package com.java.meet.c88_104_gc;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 88_垃圾收集器回收种类
 * 89_串行并行并发G1四大垃圾回收方式
 * 91_JVM默认的垃圾收集器有哪些
 * 92_GC之7大垃圾收集器概述
 * 93_GC之约定参数说明
 * 94_GC之Serial收集器
 * 95_GC之ParNew收集器
 * 96_GC之Parallel收集器
 * 97_GC之ParallelOld收集器
 * 98_GC之CMS收集器
 * 99_GC之SerialOld收集器
 * 100_GC之如何选择垃圾收集器
 * 101_GC之G1收集器
 * 102_GC之G1底层原理
 * 103_GC之G1参数配置和CMS比较
 * 104_JVMGC结合SpringBoot微服务优化简介
 * 105_Linux命令之top
 * 106_Linux之cpu查看vmstat
 * 107_Linux之cpu查看pidstat
 *
 * 其中6、7、8是重点
 *
 * 6.GC垃圾回收算法和垃圾收集器的关系？分别是什么请你谈谈
 *         GC算法（引用计数、复制、标记清除、标记整理）是内存回收的方法论，垃圾收集器就是算法落地实现。
 *         因为目前为止还没有完美的收集器出现，更加没有万能的收集器，只是针对具对应用最合适的收集器，进行分代收集
 *         4种主要垃圾收集器,以java8为例：（java11/12出现了ZGC）
 *                  Serial串行垃圾回收器：
 *                          它为单线程环境设计且只使用一个线程进行垃圾回收，会暂停所有的用户线程。所以不适合服务器环境
 *                          如：餐厅搞卫生，一个清洁工人说大家先暂停，我先搞一下卫生，然后大家再继续
 *                  Parallel并行垃圾回收器：java8默认
 *                          多个垃圾收集线程并行工作，此时用户线程是暂停的，适用于科学计算、大数据处理后台处理等弱交互场景
 *                          如：餐厅搞卫生，多个清洁工人说大家先暂停，我们先搞一下卫生，然后大家再继续（串行的加强版）
 *                  CMS并发垃圾回收器：
 *                          用户线程和垃圾收集线程同时执行（不一定是并行，可能交替执行），不需要停顿用户线程
 *                          互联网公司多用它，适用对响应时间有要求的场景
 *                          如：餐厅搞卫生，你们先到1号桌吃饭，等我搞完卫生，你们再从1号桌回来
 *                  G1垃圾回收器：garbage first
 *                          java8开始认证，java9默认是G1
 *                          G1垃圾回收器将堆内存分割成不同的区域然后并发的对其进行垃圾回收
 *
 * ------------------------------
 * 91_JVM默认的垃圾收集器有哪些
 * 92_GC之7大垃圾收集器概述
 * 93_GC之约定参数说明
 * 94_GC之Serial收集器
 * 95_GC之ParNew收集器
 * 96_GC之Parallel收集器
 * 97_GC之ParallelOld收集器
 * 98_GC之CMS收集器
 * 99_GC之SerialOld收集器
 * 100_GC之如何选择垃圾收集器
 * 101_GC之G1收集器
 * 102_GC之G1底层原理
 * 103_GC之G1参数配置和CMS比较
 * 104_JVMGC结合SpringBoot微服务优化简介
 * 105_Linux命令之top
 * 106_Linux之cpu查看vmstat
 * 107_Linux之cpu查看pidstat
 *
 * 7.怎么查看服务器默认的垃圾收集器是哪个？
 *      生产上如何配置垃圾收集器的？
 *      谈谈你对垃圾收集器的理解？
 *              怎么查看默认的垃圾收集器是哪个？
 *                      JVM参数：在Terminal输入如下，查看JVM默认的参数
 *                              java -XX:+PrintCommandLineFlags -version
 *                              下面红色就是默认垃圾收集器
 *                              -XX:InitialHeapSize=134217728 -XX:MaxHeapSize=2147483648 -XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseParallelGC
 *                              java version "1.8.0_241"
 *                              Java(TM) SE Runtime Environment (build 1.8.0_241-b07)
 *                              Java HotSpot(TM) 64-Bit Server VM (build 25.241-b07, mixed mode)
 *
 *              默认的垃圾收集器有哪些？
 *                      java的gc回收的类型主要有几种：
 *                          UseSerialGC(SerialOldGC随java8升级不用),UseParallelGC,UseConcMarkSweepGC,UseParNewGC,UseParallelOldGC,UseG1GC
 *
 *              垃圾收集器（重点）
 *                      Young Gen:  Serial Copying、Parallel Scavenge、ParNew
 *                                  （Serial、ParNew、Parallel Scavenge）
 *                      Old Gen:    Serial MSC(Serial Old)、Parallel Compacting(Parallel Old)、CMS
 *                                  (CMS、Serial Old(MSC)、Parallel Old)
 *                      G1可用于Young Gen和Old Gen两者都可
 *
 *                      垃圾收集器就是具体实现这些GC算法并实现内存回收。
 *                      不同厂商、不同版本的虚拟机实现差别很大，HotSpot中包含的收集器如下图所示：
 *                  -------------------------------
 *                      部分参数预先说明
 *                              DefNew      Default New Generation
 *                              Tenured     Old
 *                              ParNew      Parallel New Generation
 *                              PSYoungGen  Parallel Scavenge
 *                              ParOldGen   Parallel Old Generation
 *                      Server/Client模式分别是什么意思
 *                              1 适用范围：只需要掌握Server模式即可，Client模式基本不会用
 *                              2 操作系统：
 *                                  2.1 32位Window操作系统，不论硬件如何都默认使用Client的JVM模式
 *                                  2.2 32位其它操作系统，2G内存同时有2个cpu以上用Server模式，低于该配置还是Client模式
 *                                  2.3 64位only server模式
 *                      新生代
 *                              串行GC(Serial)/(Serial Copying)
 *                                      【串行收集器：Serial收集器】
 *                                      一句话：一个单线程的收集器，在进行垃圾收集时候，必须暂停其他所有的工作线程直到它收集结束。
 *                                      串行收集器是最古老，最稳定以及效率高的收集器，只使用一个线程去回收但其在进行垃圾收集过程中可能会产生较长的停顿（
 *                                      Stop-The-World状态）。虽然在收集垃圾过程中需要暂停所有其他的工作线程，但是它简单高效，对于限定单个CPU环境来说，没
 *                                      有线程交互的开销可以获得最高的单线程垃圾收集效率，因此Serial垃圾收集器依然是java虚拟机运行在Client模式下默认的
 *                                      新生代垃圾收集器。
 *                                      对应JVM参数是：-XX:+UseSerialGC
 *                                      开启后会使用：Serial(Young区用) + Serial Old(Old区用)的收集器组合
 *                                      表示：新生代、老年代都会使用串行回收收集器，新生代使用复制算法，老年代使用标记-整理算法
 *                                          -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseSerialGC
 *
 *                              并行GC(ParNew)
 *                                      ParNew(并行)收集器
 *                                      一句话：使用多线程程进行垃圾回收，在垃圾收集时，会Stop-the-world暂停其他所有的工作线程直到它收集结束。
 *                                      ParNew收集器其实就是Serial收集器新生代的并行多线程版本，最常见的应用场景是配合老年代的CMS GC工作，其余的行为和
 *                                      Serial收集器完全一样，ParNew垃圾收集器在垃圾收集过程中同样也要暂停所有其他的工作线程。它是很多java虚拟机运行在
 *                                      Server模式新生代的默认垃圾收集器。
 *
 *                                      常用对应JVM参数：-XX:+UseParNewGC      启用ParNew收集器，只影响新生代的收集，不影响老年代
 *                                      开启上述参数后，会使用：ParNew(Young区用)  +  Serial Old的收集器组合，新生代使用复制算法，老年代采用标记-整理算法
 *                                      但是，ParNew+Tenured这样的搭配，java8已经不再被推荐
 *                                      Java HotSpot(TM) 64 Bit Server VM warning:
 *                                      Using the ParNew young collector with the Serial old collector is deprecated and will likely be removed in a future
 *                                      release
 *
 *                                      备注
 *                                      -XX:+ParallelGCThreads 限制线程数量，默认开启和CPU数目相同的线程数
 *                                          -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseParNewGC
 *                              并行回收GC(Parallel)/(Parallel Scavenge)
 *                                      并行收集器
 *                                      Parallel Scavenge收集器类似ParNew 也是一个新生代垃圾收集器，使用复制算法，也是一个并行的多线程的垃圾收集器，
 *                                      俗称吞吐量优先收集器。一句话：串行收集器在新生代和老年代的并行化
 *
 *                                      它重点关注的是：
 *                                          可控制的吞吐量（Thoughput=运行用户代码时间 / (运行用户代码时间 + 垃圾收集时间)，也即比如程序运行100分钟，垃圾收集时间1分钟，
 *                                          吞吐时就是99%）。高吞吐量意味着高效利用CPU的时间，它多用于在后台运算而不需要太多交互的任务。
 *
 *                                          自适应调节策略也是ParallelScavenge收集器与ParNew收集器的一个重要区别。（自适应调节策略：虚拟机会根据当前系统的运行情况
 *                                          收集性能监控信息，动态调整这些参数以提供最合适的停顿时间 （-XX:MaxGCPauseMillis）或最大的吞量。）
 *
 *                                          常用JVM参数：-XX:+UseParallelGC 或 -XX:+UseParallelOldGC (可相互激活) 使用Parallel Scanvenge收集器
 *                                          开启该参数后：新生代使用复制算法，老年代使用标记-整理算法
 *
 *                                          多说一句：-XX:ParallelGCThreads=数字N  表示启动多少个GC线程
 *                                          cpu > 8  N = 5 / 8
 *                                          cpu < 8  N = 实际个数
 *                                              -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseParallelGC
 *                                              -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseParallelOldGC
 *
 *                      老年代
 *                              串行GC（Serial Old）/ (Serial MSC)
 *                                      Serial Old是Serial 垃圾收集器老年代版本，它同样是个单线程的收集器，使用标记-整理算法，这个收集器也主要是运行在Client默认
 *                                      的java虚拟机默认的老年代垃圾收集器。
 *
 *                                      在Server模式下，主要有两个用途（了解，版本已经到8及以后）：
 *                                      1.在JDK1.5之前版本中与新生代的Parallel Scavenge收集器搭配使用。（Parallel Scavenge + Serial Old）
 *                                      2.作为老年代版本中使用CMS收集器的后备垃圾收集方案。
 *                              并行GC（Parallel Old） / (Parallel MSC)
 *                                     Parallel Old收集器是Parallel Scavenge的老年代版本，使用多线程的标记-整理算法，Parallel Old收集器在JDK1.6才开始提供。
 *
 *                                     在JDK1.6之前，新生代使用ParallelScavenge收集器只能搭建老年代的Serial Old收集器，只能保证新生代的吞吐量优先，无法保证
 *                                     整体的吞吐量。在JDK1.6之前（Parallel Scavenge + Serial Old）
 *
 *                                     Parallel Old正是为了在老年代同样提供吞吐量优先的垃圾收集器，如果系统对吞吐量要求比较高，JDK1.8后可以优先考虑新生代
 *                                     Parallel Scavenge和老年代Parallel Old收集器的搭配策略。在JDK1.8及后（Parallel Scavenge + Parallel Old）
 *
 *                                     JVM常用参数:
 *                                     -XX:+UseParallelOldGC 使用Parallel Old收集器，设置该参数后，新生代Parallel + 老年代Parallel Old
 *                              并发标记清除GC（CMS）
 *                                      大型互联网公司都是使用CMS垃圾收集器
 *                                      CMS收集器（Concurrent Mark Sweep: 并发标记清除）是一种以获取最短回收停顿时间为目标的收集器。
 *                                      适合应用在互联网站或者B/S系统的服务器上，这类应用尤其重视服务器的响应速度，希望系统停顿时间最短。
 *                                      CMS非常适合堆内存大、CPU核数多的服务器端应用，也是G1出现之前大型应用的首选收集器。
 *                                              并发标记清除收集器组合 ParNew + CMS + Serial Old
 *                                      Concurrent Mark Sweep 并发标记清降，并发收集低停顿，并发指的是与用户线程一起执行
 *
 *                                      开启该收集器的JVM参数：-XX:+UseConcMarkSweepGC  开启该参数合会自动将-XX:+UseParNewGC打开
 *                                      开启该参数后，使用ParNew(Young区用) + CMS(Old区用) + Serial Old的收集器组合，Serial Old将作为CMS出错的后备收集器
 *                                      -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC
 *
 *                                      4步过程
 *                                          初始化标记（CMS initial mark）
 *                                                  只是标记一下GC Roots能直接关联的对象，速度很快，仍然需要暂停所有的工作线程
 *                                          并发标记（CMS concurrent mark）和用户线程一起
 *                                                  进行GC Roots跟踪的过程，和用户线程一起工作，不需要暂停工作线程。主要标记过程，标记全部对象
 *                                          重新标记（CMS remark）
 *                                                  为了修正在并发标记期间，因用户程序继续运行而导致标记产生变动的那一部分对象的标记记录，仍然需要暂停所有的工作线程。
 *
 *                                                  由于并发标记时，用户线程依然运行，因此在正式清理前，再做修正
 *                                          并发清除（CMS concurrent sweep)和用户线程一起
 *                                                  清除GC Roots不可达对象，和用户线程一起工作，不需要暂停工作线程。基于标记结果，直接清理对象
 *
 *                                                  由于耗时最长的并发标记和并发清除过程中，垃圾收集线程可以和用户现在一起并发工作，
 *                                                  所以总体上来看CMS收集器的内存回收和用户线程是一起并发地执行。
 *                                      优缺点
 *                                              优：并发收集低停顿
 *                                              缺：
 *                                                  并发执行，对CPU资源压力大
 *                                                          由于并发进行，CMS在收集与应用线程会同时会增加对堆内存的占用，也就是说，CMS必须要在老年代
 *                                                          堆内存用尽之前完成垃圾回收，否则CMS回收失败时，将触发担保机制，串行老年代收集器将会以
 *                                                          STW的方式进行一次GC，从而造成较大停顿时间
 *                                                  采用的标记清除算法会导致大量碎片
 *                                                          标记清除算法无法整理空间碎片，老年代空间会随着应用时长被逐步耗尽，最后将不得不通过担保机制对堆内存进行压缩。
 *                                                          CMS也提供了参数-XX:CMSFullGCsBeForeCompaction(默认0，即每次都进行内存整理)来指定多少次CMS收集之后，
 *                                                          进行一次压缩的Full GC。
 *
 *                      垃圾收集器配置代码总结
 *                              底层代码
 *                                  6种
 *                              实际代码
 *
 *              如何选择垃圾收集器？
 *                      组合的选择
 *                          . 单CPU或小内存，单机程序
 *                              -XX:+UseSerialGC
 *                          . 多CPU，需要最大吞吐量，如后台计算型应用
 *                              -XX:+UseParallelGC 或者-XX:+UseParallelOldGC
 *                          . 多CPU，追求低停顿时间，需快速响应如互联网应用
 *                              -XX:+UseConcMarkSweepGC
 *                              -XX:+ParNewGC
 *                      --------表格总结-----
 *                      参数                      新生代垃圾收集器            新生代算法           老年代垃圾收集器            老年代算法
 *                      -XX:+UseSerialGC            SerialGc                复制                  SerialOldGC             标记整理
 *                      -XX:+UseParNewGC            ParNew                  复制                  SerialOldGC             标记整理
 *                      -XX:+UseParallelGC/
 *                      -XX:+UseParallelOldGC       Parallel[Scavenge]      复制                  Serial Old              标记整理
 *                      -XX:+UseConcMarkSweepGC     ParNew                  复制          CMS + Serial Old的收集器组合
 *                                                                                      （Serial Old作为CMS出错的后备收集器）标记清除
 *                      -XX:+UseG1GC            G1整体上采用标记-整理算法   局部是通过复制算法，不会
 *                                                                         产生内存碎片
 *
 * 8.G1垃圾收集器
 *        以前收集器特点
 *              年轻代和老年代是各自独立且连续的内存块；
 *              年轻代收集使用单eden + s0 + s1进行复制算法；
 *              老年代收集必须扫描整个老年代区域；
 *              都是以尽可能少而快速地执行GC为设计原则。
 *        G1是什么
 *              G1(Garbage-First)收集器，是一款面向服务端应用的收集器
 *              从官网的描述中，我们知道G1是一种服务器端的垃圾收集器，应用在多处理器和大容晨内存环境中，在实现高吞量的同时，尽可能的
 *              满足垃圾收集暂停时间的要求。另外，它还具有以下特性：
 *                  像CMS收集器一样，能与应用程序线程并发执行。
 *                  整理空闲空间更快。
 *                  需要更多的时间 来预测GC停顿时间。
 *                  不希望牺牲大量的吞吐性能。
 *                  不需要更大的Java Heap.
 *
 *              G1收集器的设计目标是取代CMS收集器，它同CMS相比，在以下方面表现的更出色：
 *                  G1是一个有整理内存过程的垃圾收集器，不会产生很内存碎片。
 *                  G1的Stop The World(STW)更可控，G1在停顿时间 上添加了预测机制，用户可以指定期望停顿时间。
 *              CMS垃圾收集器虽然减少了暂停应用程序的运行时间，但是它还是存在着内存碎问题。于是，为了去除内存碎片问题，同时又何留
 *              CMS垃圾收集器低暂停时间的优点，JAVA7发布了一个新的垃圾收集器 - G1垃圾收集器。
 *
 *              G1是在2012年才在JDK1.7u4中可。oracle官方计划在jdk9中将G1变成默认的垃圾收集器以替代CMS。它是一款面向服务端应用的收集器，
 *              主要应用在多CPU和大内存服务器环境下，极大的减少垃圾收集的停顿时间，全面提升服务器的性能，逐步替换Java8以前的CMS收集器。
 *
 *              主要改变是Eden，Survivor和Tenured等内存区域不再是连续的了，而是变成了一个个大小一样的region，
 *              每个region从1M到32M不停。一个region有可能属于Eden，Survivor或者Tenured内存区域。
 *
 *              特点：
 *                  1.G1能充分利用多CPU、多核环境硬件优势，尽量缩短STW。
 *                  2.G1整体上采用标记-整理算法，局部是通过复制算法，不会产生内存碎片。
 *                  3.宏观上看G1之中不再区分年轻代和老年代。把内存划分成多个独立的子区域（Region）,可以近似理解为一个围棋的棋盘。
 *                  4.G1收集器里面讲整个的内存区都混合在一起了，但其本身依然在小范围内要进行年轻代和老年代的区分，保留了新生代和老年代，
 *                      但它们不再是物理隔离的，而是一部分Region的集合且不需要Region是连续的，也就是说依然会采用不同的GC方式来处理不同的区域。
 *                  5.G1虽然也是分代收集器，但整个内存分区不存在物理上的年轻代与老年代的区别，也不需要完全独立的survivor (to space)堆做复制
 *                      准备。G1只有逻辑上的分代概念，或者说每个分区都可能随G1的运行在不同代之间前后切换。
 *        底层原理
 *              Region区域化垃圾收集器：最大好处是化整为零，避免全内存扫描，只需要按照区域来进行扫描即可
 *                      区域化内存划分Region，整体变为了一些列不连续的内存区域，避免了全内存区的GC操作。
 *                      核心思想是将整个堆内存区域分成大小相同的子区域（Region），在JVM启动时会自动设置这些子区域的大小，
 *                      在堆的使用上，G1并不要求对象的存储一定是物理上连续的只要逻辑上连续即可，每个分区也不会固定地为某个代服务，可以按需在年
 *                      轻代和老年代之间切换。启动时可以通过参数-XX:G1HeapRegionSize=n可指定分区大小（1MB~32MB，且必须是2的幂），默认将整堆划
 *                      分为2048个分区。
 *                      大小范围在1MB~32MB，最多能设置2048个区域，也即能够支持的最大内存为：32MB * 2048 = 65536MB = 64G 内存
 *
 *              回收步骤
 *                      G1收集器下的Young GC
 *                      针对Eden区进行收集，Eden区耗尽后会被触发，主要是小区域收集 + 形成连续的内存块，避免内存碎片
 *                          * Eden区的数据移动到Survivor区，假如出现Survivor区空间不够，Eden区数据会部分晋升到Old区
 *                          * Survivor区的数据移动到新的Survivor区，部分数据晋升到Old区
 *                          * 最后Eden区收拾干净了，GC结束，用户的应用程序继续执行
 *              4步过程
 *                      初始标记：只标记GC Roots能直接关联到的对象
 *                      并发标记：进行GC Roots Tracing的过程
 *                      最终标记：修正并发标记期间，因程序运行导致标记发生变化的那一部分对象
 *                      筛选回收：根据时间来进行价值最大化的回收
 *
 *        case案例
 *        常用配置参数（了解）
 *              开发人员仅仅需要声明以下参数即可：
 *              三步归纳： 开始G1 + 设置最大内存 + 设置最大停顿时间
 *              -XX:+UseG1GC    -Xmx32g     -XX:MaxGCPauseMillis=100
 *              -XX:MaxGCPauseMillis=n: 最大GC停顿时间单位毫秒，这是个软目标，JVM将尽可能（但不保证）停顿小于这个时间
 *
 *              -XX:+UseG1GC
 *              -XX:+G1HeapRegionSize=n: 设置的G1区域的大小。值是2的幂，范围是1MB到32MB。目标是根据最小的Java堆大小划分出约2048个区域。
 *              -XX:MaxGCPauseMillis=n:  最大GC停顿时间 ，这是个软目标，JVM将尽可能（但不保证）停顿小于这个时间
 *              -XX:InitiatingHeapOccupancyPercent=n:堆占用了多少的时候触发GC，默认为45
 *              -XX:ConcGCThreads=n:  并发GC使用的线程数
 *              -XX:G1ReservePercent=n: 设置作为空闲空间的预留内存百分比，以降低目标空间溢出的风险，默认值是10%
 *        和CMS相比的优势
 *              比起cms有两个优势：
 *                  1.G1不会产生内存碎片
 *                  2.是可以精确控制停顿。该收集器是把整个堆（新生代、老年代）划分成多个固定大小的区域，
 *                      每次根据允许停顿的时间去收集垃圾最多的区域。
 *        小总结
 *
 *
 * 9.生产环境服务器变慢，诊断思路和性能评估谈谈？
 *          整机：top
 *                  uptime,系统性能命令的精简版   主要看load average和CPU/MEM
 *          CPU: vmstat
 *                  查看cpu（包含不限于）
 *                  查看额外
 *                          查看所有CPU核信息      mpstat -P ALL 2
 *                          每个进程使用cpu的用量分解信息    pidstat -u 1 -p 进程编号
 *                  实操：vmstat -n 2 3  (间隔2秒，共采集3次)
 *                  一般vmstat工具的使用是通过两个数字参数来完成的，第一个参数是采集的时间间隔单位是秒，第二个参数是采集的次数
 *                  - procs
 *                      .r: 运行和等待CPU时间片的进程数，原则上1核的CPU的运行队列不要超过2，整个系统的运行队列不能超过总核数的2倍，
 *                          否则代表系统压力过大
 *                      .b: 等待资源的进程数，比如正在等待磁盘I/O、网络I/O等。
 *                  - cpu
 *                      .us: 用户进程消耗CPU时间百分比，us值高，用户进程消耗CPU时间多，如果长期大于50%，优化程序；
 *                      .sy: 内核进程消耗的CPU时间百分比；
 *                      .us + sy参考值为80%，如果us + sy 大于80%，说明可能存在CPU不足
 *                      id: 处于空闲的CPU百分比
 *                      wa: 系统等待IO的CPU时间百分比
 *                      st: 来自于一个虚拟机偷取的CPU时间的百分比
 *          内存：free
 *          硬盘：df
 *          磁盘IO: iostat
 *          网络IO: ifstat
 * 10.假如生产环境出现CPU占用过高，请谈谈你的分析思路和定位
 *
 * 11.对于JDK自带的JVM监控和性能分析工具用过哪些？一般你是怎么用的？
 *
 */

/**
 * 1 启动串行垃圾收集器
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC      (DefNew + Tenured)
 *
 * 2 启动并行垃圾收集器
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC      (ParNew + Tenured)
 *      备注情况：Java HotSpot(TM) 64-Bit Server VM warning:
 *      Using the ParNew young collector with the Serial old collector is deprecated
 *      and will likely be removed in a future release
 * 3
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC    (PSYoungGen+ParOldGen)
 *
 * 4
 * 4.1
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelOldGC     (PSYoungGen + ParOldGen)
 * 4.2 不加就是默认UseParallelGC
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags                           (PSYoungGen + ParOldGen)
 *
 * 5 CMS垃圾回收
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC  (par new generation+ concurrent)
 * 6
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseG1GC
 *
 * 7 (理论知道即可，实际中已经被优化掉了，没有了。)
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialOldGC
 *
 *
 * 下面是故意繁琐配置，主要是为了学习，一般生产不这么配置；
 * 下面是故意繁琐配置，主要是为了学习，一般生产不这么配置；
 * 下面是故意繁琐配置，主要是为了学习，一般生产不这么配置；
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC -XX:+UseParallelOldGC      (PSYoungGen+Parallel)
 *
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC -XX:+UseConcMarkSweepGC      (par new generation)
 *
 */
public class C_88_102_GCDemo {

    public static void main(String[] args) {
        System.out.println("***************GCDemo hello");
        try {
            String str = "hello world";
            while (true){
                str += str + new Random().nextInt(77777777)+new Random().nextInt(8888888);
                str.intern();
            }
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void method_88() {
        /**
         * 实操：idea - run - vm option输入
         * -XX:+UseSerialGC
         * 运行程序
         *
         * 然后Terminal：输入如下
         * jps -l
         * jinfo -flag -UseSerialGC 6227
         *
         */
        System.out.println("hello world");
        // 暂停一会儿线程
        try { TimeUnit.SECONDS.sleep(Integer.MAX_VALUE); } catch (InterruptedException e){  e.printStackTrace();}
    }
}
