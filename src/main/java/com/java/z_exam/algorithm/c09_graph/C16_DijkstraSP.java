package com.java.z_exam.algorithm.c09_graph;

import com.java.z_exam.algorithm.c04_linear.C10_Queue;
import com.java.z_exam.algorithm.c07_priority.C03_IndexMinPriorityQueue;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:43 下午 2020/6/20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 最短路径 Dijstra算法实现

public class C16_DijkstraSP {
    // 索引代表顶点，值表示从顶点s到当前顶点的最短路径上的最后一条边
    private C15_DirectedEdge[] edgeTo;
    // 索引代表顶点，值从顶点s到当前顶点的最短路径的总权重
    private double[] distTo;
    // 存放树中顶点与非树中顶点之间的有效横切边
    private C03_IndexMinPriorityQueue<Double> pq;

    // 根据一副加权有向图G和顶点S，创建一个计算顶点为S的最短路径树对象
    public C16_DijkstraSP(C15_EdgeWeightedDigraph G, int s){
        // 初始化edgeTo
        this.edgeTo = new C15_DirectedEdge[G.V()];
        // 初始化distTo
        this.distTo = new double[G.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        // 初始化pq
        this.pq = new C03_IndexMinPriorityQueue<>(G.V());

        // 找到图G中以顶点S为起点的最短路径树

        // 默认让顶点s进入到最短路径树中
        distTo[s] = 0.0;
        pq.insert(s, 0.0);

        // 遍历pq
        while (!pq.isEmpty()) {
            relax(G, pq.delMin());
        }

    }

    // 松弛图G中的顶点v
    private void relax(C15_EdgeWeightedDigraph G, int v) {
        for (C15_DirectedEdge edge : G.adj(v)) {
            // 获取到该边的终点w
            int w = edge.to();

            // 通过松弛技术，判断从起点s到顶点w的最短路径是否需要先从顶点s到顶点w, 然后再由顶点v到顶点w
            if (distTo(v) + edge.weight() < distTo(w)) {
                distTo[w] = distTo[v] + edge.weight();
                edgeTo[w] = edge;

                // 判断pq中是否已经存在顶点w，如果存在，则更新权重，如果不存在，则直接添加
                if (pq.contains(w)) {
                    pq.changeItem(w, distTo(w));
                } else {
                    pq.insert(w, distTo(w));
                }
            }
        }
    }

    // 获取从顶点s到顶点v的最短路径的总权重
    public double distTo(int v) {
        return distTo[v];
    }

    // 判断从顶点s到顶点v是否可达
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    // 查询从起点s到顶点v的最短路径中所有的边
    public C10_Queue<C15_DirectedEdge> pathTo(int v) {
        // 判断从顶点s到顶点v是否可达，如果不可达，直接返回null
        if (!hasPathTo(v)) {
            return null;
        }

        // 创建队列对象
        C10_Queue<C15_DirectedEdge> allEdges = new C10_Queue<>();

        while (true) {
            C15_DirectedEdge e = edgeTo[v];
            if (e == null) {
                break;
            }

            allEdges.enqueue(e);

            v = e.from();
        }

        return allEdges;
    }
}
