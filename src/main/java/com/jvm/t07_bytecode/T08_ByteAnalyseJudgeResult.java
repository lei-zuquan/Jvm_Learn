package com.jvm.t07_bytecode;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:45 上午 2020/8/14
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 从字节码角度来分析：判断结果
public class T08_ByteAnalyseJudgeResult {
    public static void main(String[] args) {
        int i = 0 ;
        int x = 0;
        while (i < 10) {
            x = x++;
            i++;
        }

        System.out.println(x); // 结果是0
    }
}
