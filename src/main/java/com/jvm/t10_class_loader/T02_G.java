package com.jvm.t10_class_loader;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:37 上午 2020/8/18
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T02_G {
    static {
        // 1、打包：jar -cvf my.jar com\jvm\t10_class_loader\T02_G.class
        // 2、放入：jdk\jre\lib\ext\  下
        System.out.println("ext G init");
        //System.out.println("classpath G init");
    }
}