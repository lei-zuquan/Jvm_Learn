package com.java.z_exam.algorithm.c09_graph;

import com.java.z_exam.algorithm.c04_linear.C09_Stack;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:40 上午 2020/6/20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C09_TopoLogical {
    // 顶点的拓扑排序
    private C09_Stack<Integer> order = null;

    // 构造拓扑排序对象
    public C09_TopoLogical(C06_Digraph G) {
        // 创建一个检测有向环的对象
        C07_DirectedCycle cycle = new C07_DirectedCycle(G);
        // 判断G图中有没有环，如果没有环，则进行顶点排序：创建一个顶点排序对象
        if (!cycle.hasCycle()) {
            C08_DepthFirstOrder depthFirstOrder = new C08_DepthFirstOrder(G);
            order = depthFirstOrder.reversePost();
        }
    }

    // 判断图G是否有环
    private boolean isCycle() {
        return order == null;
    }

    // 获取拓扑排序的所有顶点
    public C09_Stack<Integer> order() {
        return order;
    }
}
