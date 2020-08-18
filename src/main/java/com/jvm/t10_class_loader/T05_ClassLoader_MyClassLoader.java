package com.jvm.t10_class_loader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:48 下午 2020/8/18
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 类加载器 —— 自定义类加载器
public class T05_ClassLoader_MyClassLoader extends ClassLoader {

    public static void main(String[] args) throws Exception {
        T05_ClassLoader_MyClassLoader classLoader = new T05_ClassLoader_MyClassLoader();
        Class<?> c1 = classLoader.loadClass("T05_ClassLoader_DefineV1");
        Class<?> c2 = classLoader.loadClass("T05_ClassLoader_DefineV1");
        System.out.println(c1 == c2); // true, 类文件只会加载一次，第一次加载放在自定义类加载器缓存中，第二次加载时发现缓存中已经有了

        // 如果使用不同的类加载器；确认唯一类，要包名、类名相同，同时类加载器也得相同，它会加载两次
        T05_ClassLoader_MyClassLoader classLoader2 = new T05_ClassLoader_MyClassLoader();
        Class<?> c3 = classLoader2.loadClass("T05_ClassLoader_DefineV1");
        System.out.println(c1 == c3); // false

        c1.newInstance();
    }


    @Override // name 就是类名称
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = "/Users/leizuquan/class_dir/" + name + ".class";

        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            Files.copy(Paths.get(path), os);

            // 得到字节数组
            byte[] bytes = os.toByteArray();

            // byte[]  ->  *.class
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ClassNotFoundException("类文件未找到", e);
        }
    }

}
