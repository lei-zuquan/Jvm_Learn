package com.jvm.t11_runtime_optimize;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:08 下午 2020/8/19
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 运行期优化 —— 字段优化

// 热身，先热身再优化
@Warmup(iterations = 5, time = 1)
// 5轮测试
@Measurement(iterations = 5, time = 1)
@State(Scope.Benchmark)
public class T03_RunTime_FieldOptimize {

    int[] elements = randomInts(1_000);

    private static int[] randomInts(int size) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int[] values = new int[size];
        for (int i = 0; i < size; i++) {
            values[i] = random.nextInt();
        }
        return values;
    }

    @Benchmark
    public void test1() {
        for (int i = 0; i < elements.length; i++) {
            doSum(elements[i]);
        }
    }

    @Benchmark
    public void test2() {
        int[] local = this.elements;
        for (int i = 0; i < elements.length; i++) {
            doSum(elements[i]);
        }
    }

    @Benchmark
    public void test3() {
        for (int element : elements) {
            doSum(element);
        }
    }

    static int sum = 0;

    @CompilerControl(CompilerControl.Mode.INLINE)  // 控制调用方法时是不是要进行方法内联；允许内联
    static void doSum(int x) { sum += x;}

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(T03_RunTime_FieldOptimize.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

}
