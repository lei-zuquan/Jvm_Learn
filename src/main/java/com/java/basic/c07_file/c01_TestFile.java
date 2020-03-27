package com.java.basic.c07_file;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:17 下午 2020/3/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * day23_06文件和目录：java.io.File类
 *
 * I/O:
 *      Input: 输入
 *      Output: 输出
 *
 * 针对当前的应用程序，把数据输出到"控制台"、"文件"、"网络"、"打印机"...
 * 针对当前的应用程序，从"键盘输入"、"文件"、"网络"...输入数据
 *
 * java.io.File类：文件和目录路径的抽象表示形式。
 *      文件和目录（文件夹）都是用File类的对象表示。
 *      并且表示文件或目录都要用对应的路径名来表示。
 *
 * 1、获取文件的常见属性
 *      (1) getPath(): 构造器怎么指定，就是什么值
 *          getAbsolutePath(): 绝对路径
 *          getCanonicalPath(): 规范路径，会正确解析../
 *
 *      (2) getName(): 文件名
 *      (3) length(): 可以获取文件的大小(字节数)，不能直接获取文件夹（目录）的大小
 *      (4) lastModified(): 毫秒数
 *      (5) 父目录： getParent()
 *                  File getParentFile()
 *          下一级： String[] list
 *                  File[] listFiles
 *      (6) 判断信息
 *              exists(): 是否存大
 *              isFile(): 是否是文件
 *              isDirectory(): 是否是目录
 *
 */
public class c01_TestFile {

    @Test
    public void test9() {
        File file4 = new File("D:/1.txt");

        // 如果不存在，就全部是默认值
        System.out.println("是否存在：" + file4.exists());
        System.out.println("是文件吗：" + file4.isFile());
        System.out.println("是目录吗：" + file4.isDirectory());
        System.out.println("大小：" + file4.length());
        System.out.println("修改时间：" + file4.lastModified());

        // 除了可以从"路径名"中获取的信息，不会是默认值
        System.out.println("路径：" + file4.getPath());
        System.out.println("文件名：" + file4.getName());
    }

    @Test
    public void test8() {
        File file4 = new File("D:/node_book/day_01/javase/");

        System.out.println("是否存在：" + file4.exists());
        System.out.println("是文件吗：" + file4.isFile());
        System.out.println("是目录吗：" + file4.isDirectory());
    }

    @Test
    public void test7() {
        File file4 = new File("D:/node_book/day_01/javase/1.txt");
        System.out.println("下一级：");

        /**
        String[] list = file4.list();
        for (String sub : list) {
            System.out.println(sub);
        } */
        File[] listFiles = file4.listFiles();
        for (File sub : listFiles) {
            System.out.println(sub);
        }

    }
    @Test
    public void test6() {
        File file4 = new File("D:/node_book/day_01/javase/1.txt");
        System.out.println("父目录：" + file4.getParent());
    }

    @Test
    public void test5() {
        File file4 = new File("D:/node_book/day_01/javase/1.txt");
        System.out.println("文件大小：" + file4.length()); // 4433字节

        // 常用类的方法
        Date date = new Date(file4.lastModified());
        System.out.println("最后修改时间:" + date);

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println("最后修改时间：" + sf.format(date));

        File dir = new File("D:/node_book/day_01/javase"); // 文件夹
        System.out.println("文件夹大小：" + dir.length());
    }
    @Test
    public void test4(){
        File file4 = new File("D:/node_book/day_01/javase/1.txt");
        String fileName = file4.getName();
        System.out.println(fileName);

        int index = fileName.lastIndexOf(".");
        String ext = fileName.substring(index);
        System.out.println("扩展名：" + ext);
    }
    @Test
    public void test3() throws IOException {
        File file1 = new File("../../javase/1.txt");
        File file2 = new File("/javase/1.txt");
        File file3 = new File("javase/1.txt");
        File file4 = new File("D:/node_book/day_01/javase/1.txt");

        System.out.println("path1 = " + file1.getPath()); // 和创建这个对象时，如何指定路径
        System.out.println("path2 = " + file2.getPath());
        System.out.println("path3 = " + file3.getPath());
        System.out.println("path4 = " + file4.getPath());
        System.out.println();

        System.out.println("AbsolutePath1 = " + file1.getAbsolutePath()); // 绝对路径
        System.out.println("AbsolutePath2 = " + file2.getAbsolutePath()); // 绝对路径
        System.out.println("AbsolutePath3 = " + file3.getAbsolutePath()); // 绝对路径
        System.out.println("AbsolutePath4 = " + file4.getAbsolutePath()); // 绝对路径
        System.out.println();

        System.out.println("CanonicalPath1 = " + file1.getCanonicalPath());
        System.out.println("CanonicalPath2 = " + file2.getCanonicalPath());
        System.out.println("CanonicalPath3 = " + file3.getCanonicalPath());
        System.out.println("CanonicalPath4 = " + file4.getCanonicalPath());

    }
    @Test
    public void test2(){
        // 文件
        //File file = new File("d:\\tt\\dd\\bb.dox");

        // 建议使用/， 因为这种表示方式，在不同的操作系统，网络中表示路径都支持/，而\ 只有windows
        // File file = new File("d:/tt/dd/bb.dox");
        File file = new File("d:" + File.separator + "tt" + File.separator + "dd" + File.separator + "bb.dox");

        System.out.println("路径：" + file);
    }

    @Test
    public void test1(){
        // 文件
        File file = new File("d:\\tt\\dd\\bb.dox");

        // 目录
        File dir = new File("d:\\tt\\dd");
    }
}
