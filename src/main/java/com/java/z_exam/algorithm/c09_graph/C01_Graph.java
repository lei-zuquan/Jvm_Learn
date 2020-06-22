package com.java.z_exam.algorithm.c09_graph;

import com.java.z_exam.algorithm.c04_linear.C10_Queue;

import javax.jnlp.IntegrationService;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:15 下午 2020/6/17
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 使用邻接表实现图
public class C01_Graph {
    // 顶点数目
    private final int V;

    // 边的数目
    private int E;

    // 邻接表
    private C10_Queue<Integer>[] adj;

    public C01_Graph(int V) {
        // 初始化顶点数量
        this.V = V;
        // 初始化边的数量
        this.E = 0;
        // 初始化邻接表
        this.adj = new C10_Queue[V];

        for (int i = 0; i < adj.length; i++) {
            adj[i] = new C10_Queue<Integer>();
        }
    }

    // 获取顶点的数目
    public int V() {
        return V;
    }

    // 获取边的数目
    public int E(){
        return E;
    }

    // 向图中添加一条边 v-w
    public void addEdge(int v, int w) {
        // 在无向图中，边是没有方向的，所以该边既可以说是从v到w的边，又可以说是w到v的边，因此，需要让w出现在v的邻接表中，并且还要让v出现在w的邻接表中
        adj[v].enqueue(w);
        adj[w].equals(v);

        // 边的数量+1
        E++;
    }

    // 获取和顶点v 相邻的所有顶点
    public C10_Queue<Integer> adj(int v) {
        return adj[v];
    }






















}
