package com.java.z_exam.algorithm.c09_graph;

import com.java.z_exam.algorithm.c04_linear.C10_Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:21 下午 2020/6/20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C16_DijkstraSPTest {
    public static void main(String[] args) throws Exception {
        // 创建一副加权有向图
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        C16_DijkstraSPTest.class.getClassLoader().getResourceAsStream("min_route_test.txt")));
        int total = Integer.parseInt(br.readLine());
        C15_EdgeWeightedDigraph G = new C15_EdgeWeightedDigraph(total);

        int edgeNumbers = Integer.parseInt(br.readLine());
        for (int i = 0; i < edgeNumbers; i++) {
            String line = br.readLine();
            String[] split = line.split(" ");
            int v = Integer.parseInt(split[0]);
            int w = Integer.parseInt(split[1]);

            double weight = Double.parseDouble(split[2]);

            C15_DirectedEdge e = new C15_DirectedEdge(v, w, weight);
            G.addEdge(e);
        }

        // 创建DijkstraSP对象，查找最短路径树
        C16_DijkstraSP dijkstraSP = new C16_DijkstraSP(G, 0);

        // 查找最短路径， 0->6的最短路径
        C10_Queue<C15_DirectedEdge> edges = dijkstraSP.pathTo(6);

        // 遍历打印
        for (C15_DirectedEdge edge : edges) {
            System.out.println(edge.from() + "->" +edge.to() + " :: " + edge.weight());
        }
    }
}
