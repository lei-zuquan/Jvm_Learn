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
public class T09_CompileTime_TryWithResources2 {
    public T09_CompileTime_TryWithResources2() {

    }
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("in/1.txt");
            Throwable t  = null;
            try {
                System.out.println(is);
            } catch (Throwable e1) {
                // t 是我们代码出现的异常
                t = e1;
                throw e1;
            } finally {
                // 判断了资源不为空
                if (is != null) {
                    // 如果我们代码有异常
                    if (t != null) {
                        try {
                            is.close();
                        } catch (Throwable e2) {
                            // 如果 close 出现异常，作为被压制异常添加; 这样异常不会丢
                            t.addSuppressed(e2);
                        }
                    } else {
                        // 如果我们代码没有异常，close 出现的异常就是最后的 catch 块中的 e
                        is.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
