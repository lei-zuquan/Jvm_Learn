package com.java.basic.c10_fanshe;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 5:27 下午 2020/3/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * day27_06类加载器加载资源文件
 *
 * 类加载器的作用：
 * 1、最主要的作用：加载类
 * 2、辅助的作用：可以用它来加载"类路径下"的资源文件
 *      JavaSE: 例如：bin中     src下文件 --> bin目录下
 *
 * classLoader:
 *      (1) 静态方法
 *          ClassLoader.getSystemResourceAsStream("src1.properties")
 *          但是这个适用于JavaSE阶段，因为它用应用程序类加载器去加载的
 *          如果是WEB阶段，用这个方法是有问题的，因为WEB阶段的类路径在WEB-INF/classes下，必须由它自定义类加载器
 *     （2）非静态方法
 *          类加载器对象.getResourceAsStream("src_in.properties")
 *          WEB阶段用（2）这个方法
 *
 * Properties:
 *      Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。属性列表中每个键及其对应值都是一个字符串。
 *      一个属性列表可包含另一个属性列表作为它的"默认值"；如果未能在原有的属性列表中搜索到属性键，则搜索第二个属性列表。
 *
 */
public class C03_TestLoaderFile {

    @Test
    public void test5(){
        // 1、创建一个Properties对象，用来装加载建立的数据（key, value）
        Properties pro = new Properties();

        try{
            // 2、要从src1.properties文件中加载
            // 先获取当前类的加载器对象
            ClassLoader loader = C03_TestLoaderFile.class.getClassLoader();

            // config是一个Source Folder，等价于src
            pro.load(loader.getResourceAsStream("other.properties"));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        // 3、遍历显示
        System.out.println(pro);
    }
    @Test
    public void test4(){
        // 1、创建一个Properties对象，用来装加载建立的数据（key, value）
        Properties pro = new Properties();

        try{
            // 2、要从src1.properties文件中加载
            // 先获取当前类的加载器对象
            ClassLoader loader = C03_TestLoaderFile.class.getClassLoader();

            pro.load(loader.getResourceAsStream("com/java/basic/c10_fanshe/src_in.properties"));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        // 3、遍历显示
        System.out.println(pro);
    }
    @Test
    public void test3(){
        // 1、创建一个Properties对象，用来装加载建立的数据（key, value）
        Properties pro = new Properties();

        try{
            // 2、要从src1.properties文件中加载
            // 先获取当前类的加载器对象
            ClassLoader loader = C03_TestLoaderFile.class.getClassLoader();

            pro.load(loader.getResourceAsStream("src_in.properties"));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        // 3、遍历显示
        System.out.println(pro);
    }
    @Test
    public void test2(){
        // 1、创建一个Properties对象，用来装加载建立的数据（key, value）
        Properties pro = new Properties();

        try{
            // 2、要从src1.properties文件中加载
            pro.load(ClassLoader.getSystemResourceAsStream("src_in.properties"));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        // 3、遍历显示
        System.out.println(pro);
    }

    @Test
    public void test1(){
        // 1、创建一个Properties对象，用来装加载建立的数据（key, value）
        Properties pro = new Properties();

        try{
            // 2、要从src1.properties文件中加载
            //pro.load(new FileReader("src/src1.properties"));
            pro.load(new FileReader("src1.properties"));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        // 3、遍历显示
        System.out.println(pro);
    }
}



















