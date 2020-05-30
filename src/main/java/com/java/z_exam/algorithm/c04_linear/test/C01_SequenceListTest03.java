package com.java.z_exam.algorithm.c04_linear.test;

import com.java.z_exam.algorithm.c04_linear.C01_SequenceList;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:49 下午 2020/5/25
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C01_SequenceListTest03 {
    public static void main(String[] args) {
        C01_SequenceList<String> squence = new C01_SequenceList<>(5);
        //测试遍历
        squence.insert(0, "姚明");
        squence.insert(1, "科比");
        squence.insert(2, "麦迪");
        squence.insert(3, "艾佛森");
        squence.insert(4, "卡特");
        System.out.println(squence.capacity());
        squence.insert(5,"aa");


        System.out.println(squence.capacity());
        squence.insert(5,"aa");
        squence.insert(5,"aa");
        squence.insert(5,"aa");
        squence.insert(5,"aa");
        squence.insert(5,"aa");
        System.out.println(squence.capacity());
        squence.remove(1);
        squence.remove(1);
        squence.remove(1);
        squence.remove(1);
        squence.remove(1);
        squence.remove(1);
        squence.remove(1);
        System.out.println(squence.capacity());
    }
}
