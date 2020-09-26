package com.test.leetcode;

/**
 * @Author:
 * @Date: Created in 4:00 下午 2020/9/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
//将二叉搜索树转化为有序的双向链表, 不需要额外的辅助空间。
public class BST2List {

    private class BinaryNode implements Comparable<BinaryNode>{
        int ele;
        BinaryNode left;
        BinaryNode right;

        public BinaryNode(int ele) {
            this.ele = ele;
            left = right = null;
        }

        @Override
        public int compareTo(BinaryNode node) {
            return this.ele - node.ele;
        }

        @Override
        public String toString() {
            return this.ele + " ";
        }

    }

    private BinaryNode root;

    public void buildTree(int[] ele){
        for (int i : ele) {
            insert(i);
        }
    }
    private void insert(int ele){
        root = insert(root, ele);
    }
    private BinaryNode insert(BinaryNode root, int ele){
        if(root == null)
            return new BinaryNode(ele);
        if(root.ele > ele)
            root.left = insert(root.left, ele);
        else if(root.ele < ele)
            root.right = insert(root.right, ele);
        return root;
    }

    //将二叉搜索树转化成双向链表,返回链表的头结点
    public BinaryNode bstConvert2List(BinaryNode root){
        if(root == null)
            return null;

        BinaryNode lastNode = null;
        lastNode = convertNode(root, lastNode);

        // 回到链表最左，表示链表最小节点，为了遍历方便一直向右遍历
        BinaryNode head = null;
        while(lastNode != null)
        {
            head = lastNode;
            lastNode = lastNode.left;
        }
        return head;
    }
    /**
     * 采用中序遍历思想将二叉搜索树的结点转化为双向链表的结点
     * @param root 从二叉搜索树的根开始转换
     * @param lastMinNode 当前链表的最后一个结点
     * @return 链表的最后一个结点
     */
    private BinaryNode convertNode(BinaryNode root, BinaryNode lastMinNode){
        if(root == null)
            return null;

        BinaryNode currentNode = root;//当前待转换子树的根结点
        if(root.left != null)
            lastMinNode = convertNode(root.left, lastMinNode); //向根的左子树转换(类似于中序遍历中左子树遍历)

        currentNode.left = lastMinNode;

        if(lastMinNode != null) // 因为第一次是null，后续通过中序遍历找到当前最小值
            lastMinNode.right = currentNode;
        // todo: 通过对搜索二叉树进行中序遍历即得到从小到大的排序，这样每次只需要将最小的数据
        lastMinNode = currentNode;// 将currentNode加入到链表中

        if(root.right != null)
            lastMinNode = convertNode(root.right, lastMinNode);//往根的右子树转换(类似于中序遍历中右子树遍历)

        return lastMinNode;
    }

    public void printList(BinaryNode head){
        if(head == null)
            return;
        BinaryNode current = head;
        while(current != null)
        {
            System.out.print(current);
            current = current.right;
        }
    }

    //hapjin test
    public static void main(String[] args) {
        //int[] eles = {10,6,14,4,8,12,16};
        int[] eles = {2,3,1};
        BST2List obj = new BST2List();
        obj.buildTree(eles);

        BinaryNode head = obj.bstConvert2List(obj.root);
        obj.printList(head);
    }
}
