package com.java.z_exam.rpc.rpc01;

import com.java.z_exam.rpc.common.User;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 3:03 下午 2020/6/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("127.0.0.1", 8888);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        dos.writeInt(123);

        s.getOutputStream().write(baos.toByteArray());
        s.getOutputStream().flush();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        int id = dis.readInt();
        String name = dis.readUTF();
        User user = new User(id, name);

        System.out.println(user);

        dos.close();
        s.close();
    }
}
