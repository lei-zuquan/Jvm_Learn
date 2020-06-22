package com.java.z_exam.algorithm.c09_graph;

import com.java.z_exam.algorithm.c04_linear.C10_Queue;
import com.java.z_exam.algorithm.c07_priority.C03_IndexMinPriorityQueue;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 4:21 下午 2020/6/20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// PrimMST 贪心算法实现的一种，求所有路径最短

public class C13_PrimMST {
    // 索引代表顶点，值表示当前顶点和最小生成树之间的最短边
    private C11_Edge[] edgeTo;
    // 索引代表顶点，值表示当前顶点和最小生成树之间的最短边的权重
    private double[] distTo;
    // 索引代表顶点，如果当前顶点已经在树中，则值为true，否则为false
    private boolean[] marked;
    // 存放树中顶点与非树中顶点之间的有效横切边
    private C03_IndexMinPriorityQueue pq;

    // 根据一副加权无向图，创建最小生成树计算对象
    public C13_PrimMST(C12_EdgeWeightedGraph G) {
        // 初始化edgeTo
        this.edgeTo = new C11_Edge[G.V()];
        // 初始化distTo
        this.distTo = new double[G.V()];
        // 为了后续比较边的权重，默认初始化为double的最大值
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        // 初始化marked
        this.marked = new boolean[G.V()];
        // 初始化pq
        pq = new C03_IndexMinPriorityQueue<Double>(G.V());

        // 默认让顶点0进入到树中，但是树中只有一个顶点0，因此，0顶点默认没有和其他的顶点相连，所以让distTo对应位置处的值存储0.0
        distTo[0] = 0.0;
        pq.insert(0, 0.0);

        // 遍历索引最小优先队列，拿到最小和 横切边对应的顶点，把该顶点加入到最小生成树中
        while (!pq.isEmpty()) {
            visit(G, pq.delMin());
        }
    }

    // 将顶点v添加到最小生成树中，并且更新数据
    private void visit(C12_EdgeWeightedGraph G, int v) {
        // 把顶点v添加到最小生成树中
        marked[v] = true;
        // 更新数据
        for (C11_Edge edge : G.adj(v)) {
            // 获取e边的另外一个顶点（当前顶点是v）
            int w = edge.other(v);
            // 判断另外一个顶点是不是已经在树中，如果在树中，则不做任何处理，如果不在树中，更新数据
            if (marked[w]) {
                continue;
            }

            // 判断边e 的权重是否小于从w顶点到树中已经存在的最小边的权重
            if (edge.weight() < distTo[w]) {
                // 更新数据
                edgeTo[w] = edge;
                distTo[w] = edge.weight();
                if (pq.contains(w)) {
                    pq.changeItem(w, edge.weight());
                } else {
                    pq.insert(w, edge.weight());
                }
            }
        }
    }

    // 获取最小生成树的所有边
    public C10_Queue<C11_Edge> edges() {
        // 创建队列对象
        C10_Queue allEdges = new C10_Queue();
        // 遍历edgeTo数组，拿到每一条边，如果不为null，则添加到队列中
        for (int i = 0; i < edgeTo.length; i++) {
            if (edgeTo[i] != null) {
                allEdges.enqueue(edgeTo[i]);
            }
        }
        return allEdges;
    }
}
