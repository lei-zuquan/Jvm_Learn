package com.jvm.t07_bytecode;


import java.io.IOException;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:54 上午 2020/8/15
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 从字节码角度来分析：多态原理
/**
 * 演示多态原理，注意加上下面的 JVM参数，禁用指针压缩
 * -XX:-UseCompressedOops -XX:-UseCompressedClassPointers
 */
public class T12_ByteAnalyseDuoTai {
    // 此处，就会有多态应用。
    public static void test(Animal animal) {
        // 因为animal有可能是狗，也可能是猫，且不同对象eat方法实现不一样
        // 后续将演示eat方法是哪个对象调用，从字节码角度对eat方法查找调用过程
        animal.eat();
        System.out.println(animal.toString());
    }

    public static void main(String[] args) throws IOException {
        test(new Cat());
        test(new Dog());
        System.in.read();
    }
}

abstract class Animal {
    public abstract void eat();

    @Override
    public String toString() {
        return "我是" + this.getClass().getSimpleName();
    }
}

class Dog extends Animal {

    @Override
    public void eat() {
        System.out.println("啃骨头");
    }
}


class Cat extends Animal {

    @Override
    public void eat() {
        System.out.println("吃鱼");
    }
}
