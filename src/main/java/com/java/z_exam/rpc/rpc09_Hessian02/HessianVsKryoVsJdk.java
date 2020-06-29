package com.java.z_exam.rpc.rpc09_Hessian02;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.java.z_exam.rpc.common.User;
import com.java.z_exam.rpc.rpc10_kyro.Simple;
import org.objenesis.strategy.StdInstantiatorStrategy;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:40 下午 2020/6/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class HessianVsKryoVsJdk {
    public static void main(String[] args) throws Exception {
        User u = new User(1, "zhangsan");
        System.out.println("hessian:" + hessianSerialize(u).length);
        System.out.println("kryo:" + kryoSerialize(u).length);
        System.out.println("jdk:" + jdkSerialize(u).length);

        // TODO HessianVsKryoVsJdk 序列化测试结果
        /*
            hessian:53
            kryo:10
            jdk:195
         */
    }

    public static byte[] hessianSerialize(Object o) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(baos);
        output.writeObject(o);
        output.flush();
        byte[] bytes = baos.toByteArray();
        baos.close();
        output.close();
        return bytes;
    }

    public static Object hessianDeserialize(byte[] bytes) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        Hessian2Input input = new Hessian2Input(bais);
        Object o = input.readObject();
        bais.close();
        input.close();
        return o;
    }

    public static byte[] kryoSerialize(Object o) throws IOException {
        Kryo kryo = new Kryo();
        kryo.setReferences(false);
        kryo.setRegistrationRequired(false);
        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());
        kryo.register(Simple.class);
        byte[] bytes;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Output output = new Output(byteArrayOutputStream, 100000000);
        Map<String, Integer> map = new HashMap<String, Integer>();
        kryo.writeObject(output, o);

//    kryo.writeObject(output, simple);
//    错误用法：bytes = byteArrayOutputStream.toByteArray();
//    注意是output.toBytes()，而不是byteArrayOutputStream.toByteArray(),这里是kryo和java原生序列化框架的区别
        bytes = output.toBytes();
        output.close();
        byteArrayOutputStream.close();
        return bytes;
    }


    public static Object kryoDeserialize(byte[] bytes) {
        Kryo kryo = new Kryo();
        kryo.setReferences(false);
        kryo.setRegistrationRequired(false);
        kryo.setInstantiatorStrategy(new StdInstantiatorStrategy());

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        Input input = null;
        input = new Input(byteArrayInputStream);
        Object o = null;
        o = kryo.readObject(input, Object.class);

        input.close();
        return o;
    }

    private static byte[] jdkSerialize(Object o) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream output = new ObjectOutputStream(baos);
        output.writeObject(o);
        output.flush();
        byte[] bytes = baos.toByteArray();
        baos.close();
        output.close();
        return bytes;
    }

    public static Object jdkDeserialize(byte[] bytes) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream input = new ObjectInputStream(bais);
        Object o = input.readObject();
        bais.close();
        input.close();
        return o;
    }
}
