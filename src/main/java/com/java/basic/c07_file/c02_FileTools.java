package com.java.basic.c07_file;

import java.io.File;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:36 下午 2020/3/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * day23_07复习递归
 *
 */
public class c02_FileTools {
    public static void main(String[] args) {
        //File f = new File("D:/tt/dd/test.doc");
        File f = new File("D:/tt/dd/");
        long length = getLength(f);

    }

    /**
     * 可以返回一个文件或目录的总大小
     */
    public static long getLength(File dir){
        if (dir.isFile()){
            return dir.length();
        } else if (dir.isDirectory()){
            // 思路：把dir的所有的下一级的总大小累加起来
            long sum = 0;
            // 获取dir的所有的下一级
            File[] listFiles = dir.listFiles();
            for (File sub : listFiles) {
                // sum += 每一个sub的大小； sub可以是一个文件，也可以是一个目录
                sum += getLength(sub); // 递归，当方法自己调用自己，就叫做递归
            }

            return sum;
        }
        return 0;
    }
}
