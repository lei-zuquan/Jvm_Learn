package com.java.z_exam.design_patterns.c03_factory_method;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:57 上午 2020/8/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C01_Main {
    public static void main(String[] args) {
        /*C01_Car c = new C01_Car();
        c.go();*/
        // 此时，如果需要变更交通工具，比如换成飞机；就需要将之前Car 代码注释掉，重写对应的实现类
        C01_Plane p = new C01_Plane();
        p.go();
        // 如果此时，需要变更为火车类，那又得加火车类，重新变更业务代码；有没有扩展性好一点的方式呢?
        // 这时我们想到为交通工具建一个抽象接口，然后所有的交通工具都去实现这个接口
    }
}
