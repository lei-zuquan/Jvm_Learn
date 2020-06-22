package com.java.z_exam.algorithm.c09_graph;

import com.java.z_exam.algorithm.c04_linear.C10_Queue;
import com.sun.javafx.geom.Edge;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 3:11 下午 2020/6/20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 加权无向图

public class C12_EdgeWeightedGraph {
    // 顶点总数
    private final int V;
    // 边的总数
    private int E;
    // 邻接表
    private C10_Queue<C11_Edge>[] adj;

    // 创建一个含有V个顶点的空加权无向图
    public C12_EdgeWeightedGraph(int V) {
        // 初始化顶点数量
        this.V = V;
        // 初始化边的数量
        this.E = 0;

        // 初始化邻接表
        this.adj = new C10_Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new C10_Queue<C11_Edge>();
        }

    }

    // 获取图中顶点的数量
    public int V() {
        return this.V;
    }

    // 获取图中边的数量
    public int E() {
        return this.E;
    }

    // 向加权无向图中添加一条边e
    public void addEdge(C11_Edge e) {
        // 需要让边e 同时出现e这个边的两个项点的邻接表中
        int v = e.either();
        int w = e.other(v);

        adj[v].enqueue(e);
        adj[w].enqueue(e);

        // 边的数量+1
        E++;
    }

    // 获取和顶点v关联的所有边
    public C10_Queue<C11_Edge> adj(int v) {
        return adj[v];
    }

    // 获取加权无向图的所有边
    public C10_Queue<C11_Edge> edges() {
        // 创建一个队列对象，存储所有的边
        C10_Queue<C11_Edge> allEdges = new C10_Queue<>();

        // 遍历图的每一顶点，找到该顶点的邻接表，邻接表中存储了该项点关联的每一条加农炮

        // 因为这是无向图，所以同一条边同时出现在了它关联的两个顶点的邻接表中，需要让一条边只记录一次；
        for (int v = 0; v < V; v++) {
            // 遍历v顶点的邻接表，找到每一条和v关联的边
            for (C11_Edge e : adj(v)) {
                if (e.other(v) < v) {
                    allEdges.enqueue(e);
                }
            }
        }
        return allEdges;
    }
}
