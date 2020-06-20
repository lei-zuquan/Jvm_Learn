package com.java.z_exam.algorithm.c09_graph;

import com.java.z_exam.algorithm.c04_linear.C09_Stack;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:54 上午 2020/6/20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C10_TopoLogicalTest {
    public static void main(String[] args) {
        // 准备有向图
        C06_Digraph digraph = new C06_Digraph(6);
        digraph.addEdge(0, 2);
        digraph.addEdge(0, 3);
        digraph.addEdge(2, 4);
        digraph.addEdge(3, 4);
        digraph.addEdge(4, 5);
        digraph.addEdge(1, 3);

        // 通过TopoLogical对象对有向图中的顶点进行排序
        C09_TopoLogical topoLogical = new C09_TopoLogical(digraph);

        // 获取顶点的线性序列进行打印
        C09_Stack<Integer> order = topoLogical.order();
        StringBuilder sb = new StringBuilder();
        for (Integer w : order) {
            sb.append(w + "->");
        }
        String str = sb.toString();
        int index = str.lastIndexOf("->");
        str = str.substring(0, index);
        System.out.println(str);
    }
}
