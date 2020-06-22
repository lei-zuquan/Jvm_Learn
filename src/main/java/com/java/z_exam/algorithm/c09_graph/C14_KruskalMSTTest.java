package com.java.z_exam.algorithm.c09_graph;

import com.java.z_exam.algorithm.c04_linear.C10_Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 4:50 下午 2020/6/20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C14_KruskalMSTTest {
    public static void main(String[] args) throws Exception {
        // 准备一别加权无向图
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        C14_KruskalMSTTest.class.getClassLoader().getResourceAsStream("min_create_tree_test.txt")));

        int total  = Integer.parseInt(br.readLine());
        C12_EdgeWeightedGraph G = new C12_EdgeWeightedGraph(total);

        int edgeNumbers = Integer.parseInt(br.readLine());
        for (int e = 0; e < edgeNumbers; e++) {
            String line = br.readLine(); // 4 5 0.35

            String[] split = line.split(" ");

            int v = Integer.parseInt(split[0]);
            int w = Integer.parseInt(split[1]);

            double weight = Double.parseDouble(split[2]);

            // 构建加权无向边
            C11_Edge edge = new C11_Edge(v, w, weight);
            G.addEdge(edge);
        }

        // 创建一个PrimMST对象，计算加权无向图中的最小生成树
        C14_KruskalMST kruskalMST = new C14_KruskalMST(G);

        // 获取最小生成树
        C10_Queue<C11_Edge> edges = kruskalMST.edges();

        // 遍历打印所有的边
        for (C11_Edge e : edges) {
            int v = e.either();
            int w = e.other(v);
            double weight = e.weight();
            System.out.println(v + "-" + w + " :: " + weight);
        }
    }
}
