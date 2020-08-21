package com.jvm.t12_juc;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 12:53 下午 2020/8/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// java 内存模型 —— CAS 底层
public class T08_Juc_Cas_Unsafe {
    public static void main(String[] args) throws InterruptedException {
        DataContainer dc = new DataContainer();
        int count = 5;
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                dc.increase();
            }
        }, "input thread name");
        t1.start();
        t1.join();

        System.out.println(dc.getData());
    }
}
class DataContainer {
    private volatile int data;
    static final Unsafe unsafe;
    static final long DATA_OFFSET;

    static {
        try {
            // Unsafe 对象不能直接调用，只能通过反射获得
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe)theUnsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new Error(e);
        }

        try {
            // data 属性在 DataContainer 对象中的偏移量，用于 Unsafe 直接访问该属性
            DATA_OFFSET = unsafe.objectFieldOffset(DataContainer.class.getDeclaredField("data"));
        } catch (NoSuchFieldException e) {
            throw new Error(e);
        }
    }

    public void increase() {
        int oldValue;
        while (true) {
            // 获取共享变量旧值，可以在这一行加入断点，修改 data 调试来加深理解
            oldValue = data;
            // cas 尝试修改 data 为 旧值 + 1，如果期间旧值被别的线程改了，返回 false
            if (unsafe.compareAndSwapInt(this, DATA_OFFSET, oldValue, oldValue+1)) {
                return;
            }
        }
    }

    public void decrease() {
        int oldValue;
        while (true) {
            oldValue = data;
            if (unsafe.compareAndSwapInt(this, DATA_OFFSET, oldValue, oldValue -1)) {
                return;
            }
        }
    }

    public int getData() {
        return data;
    }
}
































