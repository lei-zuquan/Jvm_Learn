package com.test.leetcode;

/**
 * @Author:
 * @Date: Created in 12:09 下午 2020/9/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


/**
         [5]
        / \
     [4]   [8]
      /   / \
    [11]  13 [4]
    /  \     / \
   7  [2]  [5]  1

 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 */
public class C113 {
    LinkedList<List<Integer>> ret = new LinkedList<List<Integer>>();
    LinkedList<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }

    private void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }

        sum -= root.val;
        path.offerLast(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new LinkedList<>(path));
        }

        dfs(root.left, sum);
        dfs(root.right, sum);

        path.pollLast();
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l1Left = new TreeNode(4);
        TreeNode l1Right = new TreeNode(8);

        TreeNode l2Left = new TreeNode(11);
        TreeNode l2Left2 = new TreeNode(13);
        TreeNode l2Right = new TreeNode(4);

        TreeNode l3Left = new TreeNode(7);
        TreeNode l3Right = new TreeNode(2);
        TreeNode l3Left2 = new TreeNode(5);
        TreeNode l3Right2 = new TreeNode(1);

        root.left = l1Left;
        root.right = l1Right;

        l1Left.left = l2Left;
        l1Right.left = l2Left2;
        l1Right.right = l2Right;

        l2Left.left = l3Left;
        l2Left.right = l3Right;

        l2Right.left = l3Left2;
        l2Right.right = l3Right2;

        C113 c113 = new C113();
        List<List<Integer>> lists = c113.pathSum(root, 22);

        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j) + "\t");
            }
            System.out.println("============= way:" + (i+1));
        }

    }
}
