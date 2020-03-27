package com.java.basic.c07_file;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:49 下午 2020/3/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * day23_08文件和目录创建删除
 *
 * 文件的创建：
 *      createNewFile
 * 目录的创建：
 *      mkdir
 *      mkdirs
 * 删除文件：delete()
 * 删除目录：delete()删除空目录
 *      如何删除非空目录？
 *
 * 重命名：renameTo(File 新文件/目录）
 *
 */
public class c03_TestCreateDelete {

    @Test
    public void test3() throws IOException {
        File f = new File("d:/新建文件夹/tt/dd/kk");
        f.mkdirs();
    }
    @Test
    public void test2() throws IOException {
        File f = new File("d:/新建文件夹/tt/dd/kk");
        f.mkdir();
    }

    @Test
    public void test1() throws IOException {
        File f = new File("d:/1.txt");
        f.createNewFile();
    }
}
