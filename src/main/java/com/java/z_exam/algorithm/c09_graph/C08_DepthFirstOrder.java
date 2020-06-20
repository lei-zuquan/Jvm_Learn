package com.java.z_exam.algorithm.c09_graph;

import com.java.z_exam.algorithm.c04_linear.C09_Stack;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:14 上午 2020/6/20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C08_DepthFirstOrder {
    // 索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    // 使用栈，存储顶点序列
    private C09_Stack<Integer> reversePost;

    // 创建一个检测环对象，检测图G中是否有环
    public C08_DepthFirstOrder(C06_Digraph G) {
        // 初始化marked数组
        this.marked = new boolean[G.V()];
        // 初始化reversePost栈
        this.reversePost = new C09_Stack<>();

        // 遍历图中的每一个顶点，让每个顶点作为入口，完成一次深度优先搜索
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    // 基于深度优先搜索，把顶点排序
    private void dfs(C06_Digraph G, int v) {
        // 标记当前v 已经被搜索
        marked[v] = true;
        // 通过循环深度搜索顶点v
        for (Integer w : G.adj(v)) {
            // 如果当前顶点w没有搜索，则递归调用dfs进行搜索
            if (!marked[w]) {
                dfs(G, w);
            }

        }

        // 让顶点v进栈
        reversePost.push(v);
    }


    // 获取顶点线性序列
    public C09_Stack<Integer> reversePost() {
        return reversePost;
    }
}
