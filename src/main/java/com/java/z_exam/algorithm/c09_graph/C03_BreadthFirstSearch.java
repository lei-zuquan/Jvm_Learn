package com.java.z_exam.algorithm.c09_graph;

import com.java.z_exam.algorithm.c04_linear.C10_Queue;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:26 下午 2020/6/17
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C03_BreadthFirstSearch {
    // 索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    // 记录有多少个项点与s顶点相通
    private int count;
    // 用来存储待搜索邻接表的点
    private C10_Queue<Integer> waitSearch;

    // 构造广度优先搜索对象，使用广度优先搜索找出G图中s顶点的所有相邻顶点
    public C03_BreadthFirstSearch(C01_Graph G, int s) {
        this.marked = new boolean[G.V()];
        this.count = 0;
        this.waitSearch = new C10_Queue<>();

        bfs(G, s);
    }

    // 使用广度优先搜索找出G图中v顶点的所有相邻顶点
    private void bfs(C01_Graph G, int v) {
        // 把当前顶点v标识为已搜索
        marked[v] = true;

        // 让顶点v进入队列，待搜索
        waitSearch.enqueue(v);

        // 通过循环，如果队列不为空，则从队列中弹出一个待搜索的顶点进行搜索
        while (!waitSearch.isEmpty()) {
            // 弹出一个待搜索的顶点
            Integer wait = waitSearch.dequeue();

            // 遍历wait顶点的邻接表
            for (Integer w : G.adj(wait)) {
                if (!marked[w]) {
                    bfs(G, w);
                }
            }
        }

        // 让相通的顶点+1
        count++;

    }

    // 判断w顶点与s顶点是否相通
    public boolean marked(int w) {
        return marked[w];
    }

    // 获取与顶点相通的所有顶点的总数
    public int count() {
        return count;
    }

    public static void main(String[] args) {
        // 准备Graph 对象
        C01_Graph G = new C01_Graph(13);
        G.addEdge(0, 5);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(0, 6);
        G.addEdge(5, 3);
        G.addEdge(5, 4);
        G.addEdge(3, 4);
        G.addEdge(4, 6);

        G.addEdge(7, 8);

        G.addEdge(9, 11);
        G.addEdge(9, 10);
        G.addEdge(9, 12);
        G.addEdge(11, 12);

        // 准备深度优先搜索对象
        C03_BreadthFirstSearch search = new C03_BreadthFirstSearch(G, 0);

        // 测试与某个项点相通的顶点数量
        int count = search.count;
        System.out.println("与起点0相通的顶点的数量为：" + count);

        // 测试某个顶点与起点是否相通
        boolean marked1 = search.marked(5);
        System.out.println("顶点5和顶点0是否相通：" + marked1);

        boolean marked2 = search.marked(7);
        System.out.println("顶点5和顶点0是否相通：" + marked2);
    }

}
