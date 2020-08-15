package com.jvm.t07_bytecode;

import org.apache.commons.math3.exception.ZeroException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.FileAlreadyExistsException;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 4:42 下午 2020/8/15
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 从字节码角度来分析：multi-catch 的情况
// jdk1.7 新增multi catch
public class T15_ByteAnalyseMulti_Catch {
    public static void main(String[] args) {
        try {
            Method test = T15_ByteAnalyseMulti_Catch.class.getMethod("test");
            test.invoke(null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public static void test() {
        System.out.println("ok");
    }
}
