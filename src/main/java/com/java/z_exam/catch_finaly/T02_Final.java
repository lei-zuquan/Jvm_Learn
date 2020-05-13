package com.java.z_exam.catch_finaly;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-03-27 10:07
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T02_Final {

    public static void main(String[] args) {
        // 虽然被final修饰，但list是集合。集合存储地址，可以继续往地址里添加内容
        final List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
    }
}
