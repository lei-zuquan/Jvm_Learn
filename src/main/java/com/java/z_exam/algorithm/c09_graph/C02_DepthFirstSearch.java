package com.java.z_exam.algorithm.c09_graph;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:49 下午 2020/6/17
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C02_DepthFirstSearch {
    // 索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    // 记录有多少个项点与s项点相通
    private int count;

    // 构造深度优先搜索对象，使用深度优先搜索找出G图中s顶点的所有相邻顶点
    public C02_DepthFirstSearch(C01_Graph G, int s) {
        // 初始化marked数组
        this.marked = new boolean[G.V()];
        // 初始化跟顶点s相通的顶点的数量
        this.count = 0;

        dfs(G, s);
    }

    // 使用深度优先搜索找出G图中发v顶点的所有相通顶点
    private void dfs(C01_Graph G, int v) {
        // 把v顶点标识为已搜索过
        marked[v] = true;

        for (Integer w : G.adj(v)) {
            // 判断当前w顶点有没有被搜索过，如果没有被搜索过，则递归调用dfs方法进行深度搜索
            if (!marked[w]) {
                dfs(G, w);
            }
        }

        // 相通顶点数量+1
        count++;
    }

    // 判断w顶点与s顶点是否相通
    public boolean marked(int w) {
        return marked[w];
    }

    // 获取与顶点s相通的所有顶点的总数
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
        C02_DepthFirstSearch search = new C02_DepthFirstSearch(G, 0);

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
