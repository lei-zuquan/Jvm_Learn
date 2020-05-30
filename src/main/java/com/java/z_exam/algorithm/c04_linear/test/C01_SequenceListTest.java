package com.java.z_exam.algorithm.c04_linear.test;

import com.java.z_exam.algorithm.c04_linear.C01_SequenceList;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:35 下午 2020/5/25
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C01_SequenceListTest {
    public static void main(String[] args) {
        //创建顺序表对象
        C01_SequenceList<String> sl = new C01_SequenceList<>(10);
        //测试插入
        sl.insert("姚明");
        sl.insert("科比");
        sl.insert("麦迪");
        sl.insert(1,"詹姆斯");
        //测试获取
        String getResult = sl.get(1);
        System.out.println("获取索引1处的结果为："+getResult);
        //测试删除
        String removeResult = sl.remove(0);
        System.out.println("删除的元素是："+removeResult);
        //测试清空
        sl.clear();
        System.out.println("清空后的线性表中的元素个数为:"+sl.length());
    }
}
