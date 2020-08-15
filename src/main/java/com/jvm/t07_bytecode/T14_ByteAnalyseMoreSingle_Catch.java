package com.jvm.t07_bytecode;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 4:30 下午 2020/8/15
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 从字节码角度来分析：多个 single-catch 块的情况
public class T14_ByteAnalyseMoreSingle_Catch {
    public static void main(String[] args) {
        int i = 0;
        try {
            i = 10;
        } catch (ArithmeticException e) {
            i = 30;
        } catch (NullPointerException e) {
            i = 40;
        } catch (Exception e) {
            i = 50;
        }
    }
}
