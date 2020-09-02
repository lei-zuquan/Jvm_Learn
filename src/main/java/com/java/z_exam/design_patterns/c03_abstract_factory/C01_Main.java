package com.java.z_exam.design_patterns.c03_abstract_factory;

import com.java.z_exam.design_patterns.c03_abstract_factory.bean.C01_AK47;
import com.java.z_exam.design_patterns.c03_abstract_factory.bean.C01_Bread;
import com.java.z_exam.design_patterns.c03_abstract_factory.bean.C01_Car;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 1:09 下午 2020/8/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C01_Main {
    public static void main(String[] args) {
        C01_Car c = new C01_Car();
        c.go();
        C01_AK47 w = new C01_AK47();
        w.shoot();

        C01_Bread b = new C01_Bread();
        b.printName();

        // 上述代码属于产品一族，如果需要变更产品一族，则相关代码需要变更
    }
}


