package com.jvm.t07_bytecode;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 5:21 下午 2020/8/15
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 从字节码角度分析：异常_finally
public class T16_ByteAnalyseFinally {
    public static void main(String[] args) {
        int i = 0;
        try {
            i = 10;
        } catch (Exception e){
            i = 20;
        } finally {
            i = 30;
        }
    }
}
