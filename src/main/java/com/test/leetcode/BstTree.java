package com.test.leetcode;

/**
 * @Author:
 * @Date: Created in 5:29 下午 2020/9/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class BstTree {



    public static void main(String[] args) {
        Node root = new Node(5);
        Node l1Left = new Node(3);
        Node l1Right = new Node(7);
        root.left = l1Left;
        root.right = l1Right;

        Node l2Left1 = new Node(2);
        Node l2Right1 = new Node(4);
        l1Left.left = l2Left1;
        l1Left.right = l2Right1;

        Node l2Left2 = new Node(6);
        Node l2Right2 = new Node(8);
        l1Right.left = l2Left2;
        l1Right.right = l2Right2;


        // 中序输出
        println(root);
    }

    private static void println(Node root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            println(root.left);
        }

        System.out.println(root.val);

        if (root.right != null) {
            println(root.right);
        }
    }
}