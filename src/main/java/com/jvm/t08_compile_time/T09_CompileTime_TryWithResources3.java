package com.jvm.t08_compile_time;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 1:55 下午 2020/8/16
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 编译期处理(语法糖) —— try-with-resources
public class T09_CompileTime_TryWithResources3 {
    public static void main(String[] args) {
        try (MyResource resource = new MyResource()) {
            int i = 1/0;
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    static class MyResource implements AutoCloseable {
        //@Override
        public void close() throws Exception {
            throw new Exception("close 异常");
        }
    }
}
