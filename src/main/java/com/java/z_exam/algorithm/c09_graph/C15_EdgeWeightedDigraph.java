package com.java.z_exam.algorithm.c09_graph;

import com.java.z_exam.algorithm.c04_linear.C10_Queue;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:14 下午 2020/6/20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 加权有向图 实现

public class C15_EdgeWeightedDigraph {
    // 顶点总数
    private final int V;
    // 边的总数
    private int E;
    // 邻接表
    private C10_Queue<C15_DirectedEdge>[] adj;

    // 创建一个含有V个顶点的空加权有向图
    public C15_EdgeWeightedDigraph(int V) {
        // 初始化顶点数量
        this.V = V;
        // 初始化边的数量
        this.E = 0;
        // 初始化邻接表
        this.adj = new C10_Queue[V];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new C10_Queue<C15_DirectedEdge>();
        }
    }

    // 获取图中顶点的数量
    public int V(){
        return V;
    }

    // 获取图中边的数量
    public int E() {
        return E;
    }

    // 向加权有向图中添加一条边e
    public void addEdge(C15_DirectedEdge e) {
        // 边e 是有方向的，所以只需要让e出现在起点的邻接表中即可
        int v = e.from();
        adj[v].enqueue(e);

        E++;
    }

    // 获取由顶点v指出的所有的边
    public C10_Queue<C15_DirectedEdge> adj(int v){
        return adj[v];
    }

    // 获取加权有向图的所有边
    public C10_Queue<C15_DirectedEdge> edges() {
        // 遍历图中的每个顶点，得到该顶点的邻接表，遍历得到每一条边，添加到队列中返回即可
        C10_Queue<C15_DirectedEdge> allEdges = new C10_Queue<>();
        for (int v = 0; v < V; v++) {
            for (C15_DirectedEdge edge : adj[v]) {
                allEdges.enqueue(edge);
            }
        }
        return allEdges;
    }
}
