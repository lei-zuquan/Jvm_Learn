package com.java.basic.c08_io;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:42 上午 2020/3/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 *
 * day23_09IO流的概述
 *
 * IO流：
 *      最基础的四个抽象类：
 *      1、InputStream：字节输入流
 *      2、OutputStream：字节输出流
 *      3、Reader：字符输入流
 *      4、Writer：字符输出流
 *
 * IO流的分类：
 *      1、按照方向分：
 *          输入流：读
 *          输出流：写
 *
 *      2、按照数据处理的单位：
 *          字节流：以字节的为单位，适用于所有类型的数据
 *          字符流：以字符为单位，仅仅能用于处理纯文本的数据
 *                 例如：纯文本的文件：.txt，.java， .css，.js，.html...
 *
 *      3、按照IO流的角色分
 *          节点流：像文件流
 *          处理流：像缓冲流，编码与解码IO流，序列化与反序列化等
 *                  处理流是在其他流（包括节点流和处理流）的基础上增加功能用的，依赖于节点流。
 *          读取文件：
 *              文件输入流（节点流，基本功能是文件读取数据）+ 缓冲流（提高效率）+ 反序列化（把文件中的数据解析为Java对象） + ...
 *          穿衣服：
 *              基本衣服（基本功能，遮羞闭体，保暖）+ 领带 + 胸针 + ...
 *
 * 常见的IO流：
 *      1、文件IO流
 *          （1）FileInputStream：文件字节输入流      --> 可以读取任意类型的文件
 *          （2）FileOutputStream：文件字节输出流     --> 可以把数据写到任意类型的文件
 *          （3）FileReader：文件字符输入流           --> 只能读取纯文本的文件
 *          （4）FileWriter：文件字符输入流           --> 只能把数据写到纯文件的文件
 *      2、缓冲流
 *          1、BufferedInputStream：字节缓冲输入流   --> 给InputStream系列的IO流增加缓冲功能
 *          2、BufferedOutputStream：字节缓冲输出流  --> 给OutputStream系列的IO流增加缓冲功能
 *          3、BufferedReader：字符缓冲输入流        --> 给Reader系列的IO流增加缓冲功能
 *          4、BufferedWriter：字符缓冲输出流        --> 给Writer系列的IO流增加缓冲功能
 *
 *      3、数据IO流
 *          1、DataInputStream：数据字节输入流
 *          2、DataOutSteam：数据字节输出流
 *
 *      4、字符串IO流
 *          1、StringReader
 *          2、StringWriter
 *
 *      5、数组IO流
 *          1、ByteArrayInputStream：从byte[] 数组中读取
 *          2、ByteArrayOutputStream：写到byte[] 数组
 *          3、CharArrayReader：从char[] 数组中读取
 *          4、CharArrayWriter：写到char[] 数组中
 *
 *      6、对象IO流
 *          1、ObjectInputStream：对象字节输入流，反序列化（把字节序列解析为Java对象）
 *          2、ObjectOutputStream：对象字节输出流，序列化（把Java对象转为字节序列）
 *
 *      7、打印流
 *          1、PrintStream
 *          2、PrintWriter
 */
public class C01_TestIO {

}
