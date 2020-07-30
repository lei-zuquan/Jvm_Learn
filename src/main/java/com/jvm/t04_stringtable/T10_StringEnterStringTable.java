package com.jvm.t04_stringtable;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-07-30 10:15
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * 演示 intern 减少内存占用
 * -XX:StringTableSize=200000 -XX:+PrintStringTableStatistics
 * -Xms500m -Xmx500m -XX:+PrintStringTableStatistics -XX:StringTableSize=200000
 */

/*
    一个典型的案例是推特记录用个用户的联系地址，因为存在大量相同的地址字符串，当时他们团队估记得38G 内存容量才能放下
    后面他们将这些数据放入字符串常量池中，解决大量重复地址存储的问题；最终使用了几百兆的内存空间解决了此问题；

    此案例未证实
 */
public class T10_StringEnterStringTable {
    public static void main(String[] args) throws IOException {

        List<String> address = new ArrayList<>();
        System.in.read();
        for (int i = 0; i < 10; i++) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("in/linux.words"), "utf-8"))) {
                String line = null;
                long start = System.nanoTime();
                while (true) {
                    line = reader.readLine();
                    if (line == null) {
                        break;
                    }

                    //address.add(line);
                    address.add(line.intern());
                }
                System.out.println("cost:" + (System.nanoTime() - start) / 1000000);
            }
        }
        System.in.read();
    }
}
