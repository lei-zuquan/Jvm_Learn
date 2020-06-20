package com.java.z_exam.algorithm.c09_graph;

import com.java.z_exam.algorithm.c04_linear.C10_Queue;
import com.java.z_exam.algorithm.c07_priority.C02_MinPriorityQueue;
import com.java.z_exam.algorithm.c08_uf.C03_UF_Tree_Weighted;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:42 下午 2020/6/20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// KruskalMST 求最小生成树

public class C14_KruskalMST {
    // 保存最小生成树的所有边
    private C10_Queue<C11_Edge> mst;
    // 索引代表顶点，使用uf.connect(v,w) 可以判断顶点和顶点w是否在同一颗树中，使用uf.union(v,w)可以把顶点v所在的树和顶点w所在的树合并
    private C03_UF_Tree_Weighted uf;
    // 存储图中所有的边，使用最小优先队列，对边按照权重进行排序
    private C02_MinPriorityQueue<C11_Edge> pq;

    // 根据一副加权无向图，创建最小生成树计算对象
    public C14_KruskalMST(C12_EdgeWeightedGraph G){
        // 初始化mst
        this.mst = new C10_Queue<C11_Edge>();
        // 初始化uf
        this.uf = new C03_UF_Tree_Weighted(G.V());
        // 初始化pq
        this.pq = new C02_MinPriorityQueue<>(G.E() + 1);

        // 把图中所有的边存储到pq中
        for (C11_Edge e : G.edges()) {
            pq.insert(e);
        }

        // 遍历pq队列，拿到最小权重的边，进行处理
        // 如果最小生成树所有边的数量达到点数量 -1，代表最小生成树已经生成
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            //  找到权重最小的边
            C11_Edge e = pq.delMin();

            // 找到该边的两个顶点
            int v = e.either();
            int w = e.other(v);

            // 判断这两个顶点是否已经在同一颗树中，如果在同一颗树中，则不对该边做处理，如果
            // 不在一颗树中，则让这两个顶点属于的两颗树合并成一颗树
            if (uf.connected(v, w)) {
                continue;
            }

            uf.union(v, w);

            // 让边e进入到mst队列中
            mst.enqueue(e);
        }
    }

    // 获取最小生成树的所有边
    public C10_Queue<C11_Edge> edges() {
        return mst;
    }
}
