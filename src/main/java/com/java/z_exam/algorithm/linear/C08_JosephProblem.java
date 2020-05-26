package com.java.z_exam.algorithm.linear;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:29 下午 2020/5/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
/*
问题描述：
传说有这样一个故事，在罗马人占领乔塔帕特后，39 个犹太人与约瑟夫及他的朋友躲到一个洞中，39个犹太人决
定宁愿死也不要被敌人抓到，于是决定了一个自杀方式，41个人排成一个圆圈，第一个人从1开始报数，依次往
后，如果有人报数到3，那么这个人就必须自杀，然后再由他的下一个人重新从1开始报数，直到所有人都自杀身亡
为止。然而约瑟夫和他的朋友并不想遵从。于是，约瑟夫要他的朋友先假装遵从，他将朋友与自己安排在第16个与
第31个位置，从而逃过了这场死亡游戏 。
问题转换：
41个人坐一圈，第一个人编号为1，第二个人编号为2，第n个人编号为n。
1.编号为1的人开始从1报数，依次向后，报数为3的那个人退出圈；
2.自退出那个人开始的下一个人再次从1开始报数，以此类推；
3.求出最后退出的那个人的编号。


解题思路：
1.构建含有41个结点的单向循环链表，分别存储1~41的值，分别代表这41个人；
2.使用计数器count，记录当前报数的值；
3.遍历链表，每循环一次，count++；
4.判断count的值，如果是3，则从链表中删除这个结点并打印结点的值，把count重置为0；
 */
public class C08_JosephProblem {
    public static void main(String[] args) {
        //1.构建循环链表
        Node<Integer> first = null;
        //记录前一个结点
        Node<Integer> pre = null;
        for (int i = 1; i <= 41; i++) {
            //第一个元素
            if (i==1){
                first = new Node(i,null);
                pre = first;
                continue;
            }

            Node<Integer> node = new Node<>(i,null);
            pre.next = node;
            pre = node;
            if (i==41){
                //构建循环链表，让最后一个结点指向第一个结点
                pre.next=first;
            }
        }

        //2.使用count，记录当前的报数值
        int count=0;
        //3.遍历链表，每循环一次，count++
        Node<Integer> n = first;
        Node<Integer> before = null;
        while(n!=n.next){
            //4.判断count的值，如果是3，则从链表中删除这个结点并打印结点的值，把count重置为0；
            count++;
            if (count==3){
                //删除当前结点
                before.next = n.next;
                System.out.print(n.item+",");
                count=0;
                n = n.next;
            } else {
                before=n;
                n = n.next;
            }
        }
        /*打印剩余的最后那个人*/
        System.out.println(n.item);

    }

    //结点类
    private static class Node<T> {
        //存储数据
        T item;
        //下一个结点
        Node next;
        public Node(T item, Node next) {
            this.item = item; this.next = next;
        }
    }
}
