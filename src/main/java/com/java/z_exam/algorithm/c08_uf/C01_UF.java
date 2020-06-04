package com.java.z_exam.algorithm.c08_uf;

import java.util.Scanner;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-04 12:50
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
并查集是一种树型的数据结构 ，并查集可以高效地进行如下操作：
查询元素p和元素q是否属于同一组
合并元素p和元素q所在的组


并查集结构
并查集也是一种树型结构，但这棵树跟我们之前讲的二叉树、红黑树、B树等都不一样，这种树的要求比较简单：
    1. 每个元素都唯一的对应一个结点；
    2. 每一组数据中的多个元素都在同一颗树中；
    3. 一个组中的数据对应的树和另外一个组中的数据对应的树之间没有任何联系；
    4. 元素在树中并没有子父级关系的硬性要求；

如果我们并查集存储的每一个整数表示的是一个大型计算机网络中的计算机，则我们就可以通过connected(int
p,int q)来检测，该网络中的某两台计算机之间是否连通？如果连通，则他们之间可以通信，如果不连通，则不能通
信，此时我们又可以调用union(int p,int q)使得p和q之间连通，这样两台计算机之间就可以通信了。
一般像计算机这样网络型的数据，我们要求网络中的每两个数据之间都是相连通的，也就是说，我们需要调用很多
次union方法，使得网络中所有数据相连，其实我们很容易可以得出，如果要让网络中的数据都相连，则我们至少
要调用N-1次union方法才可以，但由于我们的union方法中使用for循环遍历了所有的元素，所以很明显，我们之
前实现的合并算法的时间复杂度是O(N^2)，如果要解决大规模问题，它是不合适的，所以我们需要对算法进行优
化。

 */
//并查集代码
public class C01_UF {
    //记录结点元素和该元素所在分组的标识
    private int[] eleAndGroup;
    //记录并查集中数据的分组个数
    private int count;

    //初始化并查集
    public C01_UF(int N) {
        //初始情况下，每个元素都在一个独立的分组中，所以，初始情况下，并查集中的数据默认分为N个组
        this.count = N;
        //初始化数组
        eleAndGroup = new int[N];
        //把eleAndGroup数组的索引看做是每个结点存储的元素，把eleAndGroup数组每个索引处的值看做是该
        //结点所在的分组，那么初始化情况下，i索引处存储的值就是i
        for (int i = 0; i < N; i++) {
            eleAndGroup[i] = i;
        }
    }

    //获取当前并查集中的数据有多少个分组
    public int count() {
        return count;
    }

    //元素p所在分组的标识符
    public int find(int p) {
        return eleAndGroup[p];
    }

    //判断并查集中元素p和元素q是否在同一分组中
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    //把p元素所在分组和q元素所在分组合并
    public void union(int p, int q) {
        //如果p和q已经在同一个分组中，则无需合并；
        if (connected(p, q)) {
            return;
        }
        //如果p和q不在同一个分组，则只需要将p元素所在组的所有的元素的组标识符修改为q元素所在组的标识 符即可
        int pGroup = find(p);
        int qGroup = find(q);
        for (int i = 0; i < eleAndGroup.length; i++) {
            if (eleAndGroup[i] == pGroup) {
                eleAndGroup[i] = qGroup;
            }
        }
        //分组数量-1
        count--;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请录入并查集中元素的个数:");
        int N = sc.nextInt();
        C01_UF uf = new C01_UF(N);
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
