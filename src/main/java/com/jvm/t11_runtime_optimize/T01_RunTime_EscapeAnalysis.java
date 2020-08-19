package com.jvm.t11_runtime_optimize;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 1:39 下午 2020/8/19
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 运行期优化 —— 逃逸分析
// -XX:+PrintCompilation -XX:-DoEscapeAnalysis
public class T01_RunTime_EscapeAnalysis {
    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < 1000; j++) {
                new Object(); // 循环创建对象
            }
            long end = System.nanoTime();
            System.out.printf("%d\t%d\n", i, (end - start));
        }
    }
}
