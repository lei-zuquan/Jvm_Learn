package com.java.z_exam.rpc.rpc10_kyro;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-29 10:29
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class SerializableRunTimeTest {
    public static void main(String[] args) throws Exception {
        testOriginalSerializable();

        testHessianSerializable();

        testKryoSerializable();
    }

    private static void testOriginalSerializable() throws Exception {
        long start = System.currentTimeMillis();
        OriginalSerializable.setSerializableObject();
        System.out.println("java原生序列化时间:" + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();
        OriginalSerializable.getSerializableObject();
        System.out.println("java原生反序列化时间:" + (System.currentTimeMillis() - start) + " ms");
    }

    private static void testHessianSerializable() throws Exception {
        long start = System.currentTimeMillis();
        HessianSerializable.setSerializableObject();
        System.out.println("Hessian原生序列化时间:" + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();
        HessianSerializable.getSerializableObject();
        System.out.println("Hessian原生反序列化时间:" + (System.currentTimeMillis() - start) + " ms");
    }

    private static void testKryoSerializable() throws Exception {
        long start = System.currentTimeMillis();
        KryoSerializable.setSerializableObject();
        System.out.println("Kryo 序列化时间:" + (System.currentTimeMillis() - start) + " ms");
        start = System.currentTimeMillis();
        KryoSerializable.getSerializableObject();
        System.out.println("Kryo 反序列化时间:" + (System.currentTimeMillis() - start) + " ms");
    }
}
