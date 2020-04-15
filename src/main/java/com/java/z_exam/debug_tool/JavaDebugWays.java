package com.java.z_exam.debug_tool;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:29 下午 2020/4/13
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * JAVA 调试工具
 * 注意权限问题
 *      jps
 *          输出java 进程pid以及启动参数
 *          -q：只输出进程 ID
 *          -m：输出传入 main 方法的参数
 *          -l：输出完全的包名，应用主类名，jar的完全路径名
 *          -v：输出jvm参数
 *          -V：输出通过flag文件传递到JVM中的参数
 *      jstack pid
 *          输出java 进程中各线程状态
 *          会检测线程间是否有死锁
 *      jmap
 *          dump java进程内存状态快照
 *      jhat
 *          可以建立用于分析jmap dump出的快照文件的web ui
 *          内存泄漏分析
 *      gc log
 *
 *      jstat
 *          实时输出堆内存各区域使用情况
 */
public class JavaDebugWays {

}
