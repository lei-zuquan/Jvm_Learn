package com.java.meet.c72_80_reference;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:12 上午 2020/4/13
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C_01M {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        // finalize 对象回收时，调用证明被回收了

        // finalize()是Object中的方法，当垃圾回收器将要回收对象所占内存之前被调用，
        // 即当一个对象被虚拟机宣告死亡时会先调用它finalize()方法，让此对象处理它生前的最后事情（这个对象可以趁这个时机挣脱死亡的命运）
        System.out.println("finalize");
    }
}
