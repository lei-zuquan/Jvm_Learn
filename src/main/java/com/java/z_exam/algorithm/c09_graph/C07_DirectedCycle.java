package com.java.z_exam.algorithm.c09_graph;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:26 上午 2020/6/20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 拓扑排序

public class C07_DirectedCycle {
    // 索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    // 记录图中是否有环
    private boolean hasCycle;
    // 索引代表顶点，使用栈的思想，记录当前顶点有没有已经处于正在搜索的有向路径上
    private boolean[] onStack;

    // 创建一个检测环对象，检测图G中是否有环
    public C07_DirectedCycle(C06_Digraph G) {
        // 初始化marked数组
        this.marked = new boolean[G.V()];
        // 初始化hasCycle
        this.hasCycle = false;
        // 初始化onStack数组
        this.onStack = new boolean[G.V()];

        // 找到图中每个顶点，让每一个顶点作为入口，调用一个dfs进行搜索
        for (int v = 0; v < G.V(); v++) {
            // 判断如果当前顶点还没有搜索过，则调用dfs进行搜索
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    // 基于深度优先搜索，检测图G中是否有环
    private void dfs(C06_Digraph G, int v) {
        // 把顶点v表示为已搜索
        marked[v] = true;

        // 把当前顶点进栈
        onStack[v] = true;

        // 进行深度搜索
        for (Integer w : G.adj(v)) {
            // 判断如果当前顶点w没有被搜索过，则继续递归调用dfs方法完成深度优先搜索
            if (marked[w]) {
                dfs(G, w);
            }

            // 判断当前顶点出w是否已经在栈中，如果已经在栈中，证明当前顶点之前处于正在搜索的的状态，那么现在又要搜索一次，证明检测到环了。
            if (onStack[w]) {
                hasCycle = true;
                return;
            }
        }

        // 把当前顶点出栈
        onStack[v] = false;

    }

    // 判断当前有向图G中是否有环
    public boolean hasCycle() {
        return hasCycle;
    }






















}
