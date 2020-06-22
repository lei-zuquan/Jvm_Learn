package com.java.z_exam.algorithm.c09_graph;

import com.java.z_exam.algorithm.c04_linear.C10_Queue;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:16 下午 2020/6/19
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C06_Digraph {
    // 顶点数目
    private final int V;
    // 边的数目
    private int E;
    // 邻接表
    private C10_Queue<Integer>[] adj;

    public C06_Digraph(int v) {
        // 初始化顶点数量
        this.V = v;
        // 初始化边的数量
        E = 0;
        // 初始化邻接表
        this.adj = new C10_Queue[V];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new C10_Queue<>();
        }
    }

    // 获取顶点数目
    public int V(){
        return V;
    }

    // 获取边的数目
    public int E() {
        return E;
    }

    // 向有向图中添加一条边v -> w
    public void addEdge(int v, int w) {
        // 只需要让顶点w出现在顶点v的邻接表中，因为边是有方向的，最终，顶点v的邻接表中存储的相邻顶点的含义是：v -> 其他顶点
        adj[v].enqueue(w);
        E++;
    }

    // 获取由v指出的边所连接的所有顶点
    public C10_Queue<Integer> adj(int v) {
        return adj[v];
    }

    // 该图的反向图
    private C06_Digraph reverse() {
        // 创建有向图对象
        C06_Digraph r = new C06_Digraph(V);

        for (int v = 0; v < V; v++) {
            // 获取由该顶点v指出的顶点
            for (Integer w : adj[v]) { // 原图中表示的是由顶点v->w的边
                r.addEdge(w, v); // w -> v
            }
        }

        return r;
    }
}
