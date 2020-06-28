package com.java.z_exam.rpc.rpc04;

import com.java.z_exam.rpc.common.User;
import com.java.z_exam.rpc.rpc01.UserServiceImpl;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 3:06 下午 2020/6/28
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class Server {
    private static boolean running = true;

    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(8888);
        while (running) {
            Socket s = ss.accept();
            process(s);
            s.close();
        }
        ss.close();
    }

    private static void process(Socket s) throws Exception {
        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();
        ObjectInputStream oos = new ObjectInputStream(in);
        DataOutputStream dos = new DataOutputStream(out);

        String methodName = oos.readUTF();
        Class[] parameterTypes = (Class[]) oos.readObject();
        Object[] args = (Object[]) oos.readObject();

        UserServiceImpl service = new UserServiceImpl();
        // 通过反射的方法获取到方法 （方法名、参数类型）
        Method method = service.getClass().getMethod(methodName, parameterTypes);
        User user = (User) method.invoke(service, args);

        dos.writeInt(user.getId());
        dos.writeUTF(user.getName());
        dos.flush();
    }
}
