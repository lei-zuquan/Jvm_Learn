package com.java.z_exam.algorithm.c08_uf;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-04 13:05
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C04_Traffic_Project {
    public static void main(String[] args) throws Exception {
        //创建输入流
        String filePath = "traffic_project.txt";
        InputStream resourceAsStream = C04_Traffic_Project.class.getClassLoader().getResourceAsStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        //读取城市数目，初始化并查集
        int number = Integer.parseInt(reader.readLine());
        C03_UF_Tree_Weighted uf = new C03_UF_Tree_Weighted(number);
        //读取已经修建好的道路数目
        int roadNumber = Integer.parseInt(reader.readLine());
        //循环读取已经修建好的道路，并调用union方法
        for (int i = 0; i < roadNumber; i++) {
            String line = reader.readLine();
            int p = Integer.parseInt(line.split(" ")[0]);
            int q = Integer.parseInt(line.split(" ")[1]);
            uf.union(p, q);
        }
        //获取剩余的分组数量
        int groupNumber = uf.count();
        //计算出还需要修建的道路
        System.out.println("还需要修建" + (groupNumber - 1) + "道路，城市才能相通");
    }
}
