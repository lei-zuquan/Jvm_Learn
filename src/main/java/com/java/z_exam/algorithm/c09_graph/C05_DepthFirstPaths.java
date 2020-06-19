package com.java.z_exam.algorithm.c09_graph;

import com.java.z_exam.algorithm.c04_linear.C09_Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:21 上午 2020/6/19
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 图路径查找

public class C05_DepthFirstPaths {
    // 索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    // 起点
    private int s;
    // 索引代表顶点，值代表从起点s到当前顶点路径上的最后一个顶点
    private int[] edgeTo;

    // 构造深度优先搜索对象，使用深度优先搜索找出G图中起点为s的所有路径
    public C05_DepthFirstPaths(C01_Graph G, int v) {
        // 初始化marked数组
        this.marked = new boolean[G.V()];
        // 初始化起点
        this.s = s;
        // 初始化edgeTo数组
        this.edgeTo = new int[G.V()];

        dfs(G, s);
    }

    // 使用深度优先搜索找出G衅中v顶点的所有相邻顶点
    private void dfs(C01_Graph G, int v) {
        // 把v标识为已搜索
        marked[v] = true;

        // 遍历顶点v的邻接表，拿到每一个相邻的顶点，继续递归搜索
        for (Integer w : G.adj(v)) {
            // 如果顶点w没有被搜索，则继续递归搜索
            if (!marked[w]) {
                edgeTo[w] = v; // 到达顶点w的路径上的最后一个顶点是v
                dfs(G, w);
            }
        }
    }

    // 判断w顶点与s顶点是否存在路径
    public boolean hashPathTo(int v) {
        return marked[v];
    }

    // 找出从起点s到顶点v的路径（就是该路径经过的顶点）
    public C09_Stack<Integer> pathTo(int v) {
        if (!hashPathTo(v)) {
            return null;
        }

        // 创建栈对象，保存路径中的所有顶点
        C09_Stack<Integer> path = new C09_Stack<>();

        // 通过循环，从顶点v开始，一直往前找，到找到起点为止
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }

        // 把起点s放到栈中
        path.push(s);

        return path;
    }


    public static void main(String[] args) throws Exception {
        // 构建缓冲读取流BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(
                C05_DepthFirstPaths.class.getClassLoader().getResourceAsStream("road_find.txt")
        ));

        // 读取第一行数据6
        int total = Integer.parseInt(br.readLine());

        // 根据第一行数据构建一幅图Graph
        C01_Graph G = new C01_Graph(total);

        // 读取第二行数据8
        int edgeNumbers = Integer.parseInt(br.readLine());

        // 继续通过循环读取每一条边关联的两个顶点，调用addEdge方法，添加边
        for (int i = 1; i <= edgeNumbers; i++) {
            String edge = br.readLine(); // 0 1
            String[] str = edge.split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            G.addEdge(v, w);
        }

        // 构建路径查对对象，并设置起点为0
        C05_DepthFirstPaths paths = new C05_DepthFirstPaths(G, 0);

        // 调用pathTo(4), 找到从起点0到终点4的路径，返回Stack
        C09_Stack<Integer> path = paths.pathTo(4);

        StringBuilder sb = new StringBuilder();
        // 遍历栈对象
        for (Integer v : path) {
            sb.append(v + "-");
        }
        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb);

    }
}
