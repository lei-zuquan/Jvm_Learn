package com.java.z_exam.algorithm.c09_graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 6:49 上午 2020/6/19
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 使用图来解决城市道路相通问题

public class C04_Traffic_Project_Test2 {
    public static void main(String[] args) throws Exception {
        // 构建一个缓冲读取流BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(
                C04_Traffic_Project_Test2.class.getClassLoader().getResourceAsStream("traffic_project.txt")
        ));

        // 读取第一行数据20
        int totalNumber = Integer.parseInt(br.readLine());

        // 构建一个Graph对象
        C01_Graph G = new C01_Graph(totalNumber);

        // 读取第二行数据7
        int roadNumber = Integer.parseInt(br.readLine());

        // 循环读取有限次（7），读取已经修改的道路
        for (int i = 0; i < roadNumber; i++) {
            String road = br.readLine(); // "0,1"
            String[] city = road.split(" ");
            int v = Integer.parseInt(city[0]);
            int w = Integer.parseInt(city[1]);

            // 调用图的addEdge方法，把边添加到图中，表示已经修改好的道路
            G.addEdge(v, w);
        }

        // 构建一个深度优先搜索对象，起点设置为顶点9
        C02_DepthFirstSearch search = new C02_DepthFirstSearch(G, 9);

        // 调用marked方法，判断8顶点和10顶点是否与起点9相通
        System.out.println("顶点8和顶点9是否相通：" + search.marked(8));
        System.out.println("顶点10和顶点9是否相通：" + search.marked(10));

    }
}
