package com.java.z_exam.algorithm.c09_graph;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:08 下午 2020/6/20
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 加权有向图  加权有向边的表示

public class C15_DirectedEdge {
    private final int v; // 起点
    private final int w; // 终点
    private final double weight; // 当前边的权重

    // 通过顶点v和w，以及权重weight值构造一个边对象

    public C15_DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    // 获取边的权重值
    public double weight() {
        return weight;
    }

    // 获取有向边的起点
    public int from() {
        return v;
    }

    // 获取有向边的终点
    public int to() {
        return w;
    }
}
