package com.java.basic.c08_io;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:44 上午 2020/3/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * day23_10文件IO流：FileInputStream
 *
 * 1、IO流的程序的步骤：
 *      （1）选择一个合适IO流类型
 *          例如：读取一个文件，FileInputStream或FileReader
 *
 *       (2) 调用合适的方法
 *          例如：
 *              读：read系列
 *              写：write系列
 *       （3）关闭IO流
 *              比喻生活：
 *                  a，打开水流
 *                  b，进行xxx
 *                  c，关闭水流
 *
 *   一、读一个文件
 *      （1）选择一个合适IO流类型：读取一个文件，FileInputStream或FileReader
 *          这里我选择FileInputStream
 *
 *       (2) 调用read方法
 *
 *       （3）关闭IO流
 *
 *          InputStream系列的读的方法：
 *          （1）int read(): 一次读取一个字节，返回的是该字节的值
 *          （2）【一般使用这种方式】int read(byte[] data): 一次读取多个字节，返回本次实际读取的字节的个数
 *                  把数据读取后，存到data中，从data[0]位置开始存储，data有多长，就读多少个，如果不够，全部读取。
 *          （3）int read(byte[] data,int offset, int len): 一次读取多个字节，返回本次实际读取的字节的个数
 *                  把数据读取后，存到data中，从data[offset]位置开始存储，最多读取len个，如果不够len个，全部读取
 *
 *           如果流中没有数据了，read方法，返回-1
 *
 */
public class C02_TestFileInputStream {
    @Test
    public void test3() throws IOException {
        // 1、创建IO流
        // 需要指定一个参数，表明从哪个文件读取
        FileInputStream fis = new FileInputStream("in/1.txt");

        // 2、进行读取操作
        byte[] data = new byte[10];
        // 如果data数组无法装下文件的所有内容，可以用循环，反复读
        int len;
        /* while (true){
            len = fis.read(data);
            if (len == -1){
                break;
            }
            System.out.print(new String(data, 0, len));
        } */
        while ((len = fis.read(data)) != -1){
            System.out.print(new String(data, 0, len));
        }


        // 3、关闭
        fis.close();
    }
    @Test
    public void test2() throws IOException {
        // 1、创建IO流
        // 需要指定一个参数，表明从哪个文件读取
        FileInputStream fis = new FileInputStream("in/1.txt");

        // 2、进行读取操作
        byte[] data = new byte[10];
        int len = fis.read(data); // 从fis流中读取，到data数组中
        String string = new String(data, 0, len);
        System.out.println(string);

        // 3、关闭
        fis.close();
    }
    @Test
    public void test1() throws IOException {
        // 1、创建IO流
        FileInputStream fis = new FileInputStream("in/1.txt");

        // 2、进行读取操作
        int read = fis.read();
        System.out.println(read);

        // 3、关闭
        fis.close();
    }
}
