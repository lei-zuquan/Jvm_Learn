package com.java.z_exam.rpc.rpc08_Hessian01;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.java.z_exam.rpc.common.User;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:35 下午 2020/6/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class HelloHessian {
    public static void main(String[] args) throws Exception {
        User u = new User(1, "zhangSan");
        byte[] bytes = serialize(u);
        System.out.println(bytes.length);
        User u1 = (User) deserialize(bytes);
        System.out.println(u1);
    }

    public static byte[] serialize(Object o) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Hessian2Output output = new Hessian2Output(baos);
        output.writeObject(o);
        output.flush();
        byte[] bytes = baos.toByteArray();
        baos.close();
        output.close();
        return bytes;
    }

    public static Object deserialize(byte[] bytes) throws Exception {
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        Hessian2Input input = new Hessian2Input(bais);
        Object o = input.readObject();
        bais.close();
        input.close();
        return o;
    }
}
