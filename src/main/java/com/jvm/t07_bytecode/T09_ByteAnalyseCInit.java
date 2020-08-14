package com.jvm.t07_bytecode;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:51 下午 2020/8/14
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 从字节码角度来分析：构造方法
public class T09_ByteAnalyseCInit {
    static int i = 10;

    static {
        i = 20;
    }

    static {
        i = 30;
    }

}
