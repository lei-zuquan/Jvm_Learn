package com.jvm.t11_runtime_optimize;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:15 下午 2020/8/19
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 运行期优化 —— 方法内联
public class T02_RunTime_Inlining {

    // -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining    // 查看 JVM 对代码的内联情况
    // -XX:CompileCommand=dontinline,*T02_RunTime_Inlining.square   // 禁用内联
    // -XX:+PrintCompilation

    public static void main(String[] args) {
        int x = 0;
        for (int i = 0; i < 500; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < 1000; j++) {
                x = square(9);
            }
            long end  = System.nanoTime();
            System.out.printf("%d\t%d\t%d\n", i, x, (end - start));
        }
    }

    private static int square(final int i) {
        return i * i;
    }
}
