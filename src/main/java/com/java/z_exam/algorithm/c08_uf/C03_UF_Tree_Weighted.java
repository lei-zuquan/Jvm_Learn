package com.java.z_exam.algorithm.c08_uf;

import java.util.Scanner;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-04 13:00
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class C03_UF_Tree_Weighted {
    //记录结点元素和该元素所的父结点 
    private int[] eleAndGroup;
    //存储每个根结点对应的树中元素的个数 
    private int[] sz;
    //记录并查集中数据的分组个数 
    private int count;

    //初始化并查集 
    public C03_UF_Tree_Weighted(int N) {
        //初始情况下，每个元素都在一个独立的分组中，所以，初始情况下，并查集中的数据默认分为N个组 
        this.count = N;
        //初始化数组 
        eleAndGroup = new int[N];
        sz = new int[N];
        //把eleAndGroup数组的索引看做是每个结点存储的元素，把eleAndGroup数组每个索引处的值看做是该 结点的父结点，那么初始化情况下，i索引处存储的值就是i 
        for (int i = 0; i < N; i++) {
            eleAndGroup[i] = i;
        }
        //把sz数组中所有的元素初始化为1，默认情况下，每个结点都是一个独立的树，每个树中只有一个元素 
        for (int i = 0; i < sz.length; i++) {
            sz[i] = 1;
        }
    }

    //获取当前并查集中的数据有多少个分组
    public int count() {
        return count;
    }


    //元素p所在分组的标识符
    public int find(int p) {
        while (true) {
            //判断当前元素p的父结点eleAndGroup[p]是不是自己，如果是自己则证明已经是根结点了；
            if (p == eleAndGroup[p]) {
                return p;
            }
            //如果当前元素p的父结点不是自己，则让p=eleAndGroup[p]，继续找父结点的父结点,直到找到根 结点为止；
            p = eleAndGroup[p];
        }
    }

    //判断并查集中元素p和元素q是否在同一分组中
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    //把p元素所在分组和q元素所在分组合并
    public void union(int p, int q) {
        //找到p元素所在树的根结点
        int pRoot = find(p);
        //找到q元素所在树的根结点
        int qRoot = find(q);
        //如果p和q已经在同一个树中，则无需合并；
        if (pRoot == qRoot) {
            return;
        }
        //如果p和q不在同一个分组，比较p所在树的元素个数和q所在树的元素个数,把较小的树合并到较大的树 上
        if (sz[pRoot] < sz[qRoot]) {
            eleAndGroup[pRoot] = qRoot;
            //重新调整较大树的元素个数
            sz[qRoot] += sz[pRoot];
        } else {
            eleAndGroup[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        //分组数量-1
        count--;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请录入并查集中元素的个数:");
        int N = sc.nextInt();
        C03_UF_Tree_Weighted uf = new C03_UF_Tree_Weighted(N);
        while (true) {
            System.out.println("请录入您要合并的第一个点:");
            int p = sc.nextInt();
            System.out.println("请录入您要合并的第二个点:");
            int q = sc.nextInt();
            //判断p和q是否在同一个组
            if (uf.connected(p, q)) {
                System.out.println("结点：" + p + "结点" + q + "已经在同一个组");
                continue;
            }

            uf.union(p, q);
            System.out.println("总共还有" + uf.count() + "个分组");
        }
    }
}
