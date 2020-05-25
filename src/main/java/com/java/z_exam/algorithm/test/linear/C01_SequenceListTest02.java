package com.java.z_exam.algorithm.test.linear;

import com.java.z_exam.algorithm.linear.C01_SequenceList;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:42 下午 2020/5/25
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C01_SequenceListTest02 {
    public static void main(String[] args) {
        C01_SequenceList<String> squence = new C01_SequenceList<>(5);
        //测试遍历
        squence.insert(0, "姚明");
        squence.insert(1, "科比");
        squence.insert(2, "麦迪");
        squence.insert(3, "艾佛森");
        squence.insert(4, "卡特");
        for (String s : squence) {
            System.out.println(s);
        }
    }
}
