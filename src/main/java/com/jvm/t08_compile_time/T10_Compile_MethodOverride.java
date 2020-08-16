package com.jvm.t08_compile_time;

import com.sun.org.apache.bcel.internal.classfile.Synthetic;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 2:27 下午 2020/8/16
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 编译期处理(语法糖) —— 方法重写时的桥接方法
public class T10_Compile_MethodOverride {

}

class A {
    public Number m() {
        return 1;
    }
}

//class B extends A {
//    public Integer m() {
//        return 2;
//    }
//    // 此方法才是真正重写了父类 public Number m() 方法； synthetic bridge 是jvm合成的，对我们不可见
//    public synthetic bridge Number m() {
//        // 调用 public Integer m()
//        return m();
//    }
//}

class C extends A {
    @Override
    // 子类 m 方法的返回值是 Integer 是父类 m 方法返回值 Number 的子类
    public Number m() {
        return 2;
    }
}
