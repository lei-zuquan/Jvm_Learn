package com.jvm.t04_stringtable;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-30 9:41
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 演示串池大小对性能的影响
 * -Xms500m -Xmx500m -XX:+PrintStringTableStatistics -XX:StringTableSize=1009
 * <p>
 * 字符串常量池默认桶数组大小为：60013，对字符串常量池调优主要是调节桶数据大小；如果字符串数量较多，则需要将此调大些，以减少查询复杂度（hash碰撞机率）
 */

public class T09_StringTableSizeForPerformance {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("in/linux.words"), "utf-8"))) {
            String line = null;
            long start = System.nanoTime();
            while (true) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                line.intern();
            }
            System.out.println("cost:" + (System.nanoTime() - start) / 1000000);
        }
    }
}
