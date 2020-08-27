package com.java.z_exam.design_patterns.c01_singleton;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:04 下午 2020/8/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public enum Singleton_08_V2_Enum_ByteCodeAnalyse {
    INSTANCE;

    public void m() {}

    public static void main(String[] args) {
        System.out.println(Singleton_08_V2_Enum_ByteCodeAnalyse.INSTANCE.hashCode());
    }
}
