package com.java.z_exam.algorithm.c05_tree;

import com.java.z_exam.algorithm.c04_linear.C10_Queue;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:43 上午 2020/6/1
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
需求：
        请把一段纸条竖着放在桌子上，然后从纸条的下边向上方对折1次，压出折痕后展开。此时 折痕是凹下去的，即折
        痕突起的方向指向纸条的背面。如果从纸条的下边向上方连续对折2 次，压出折痕后展开，此时有三条折痕，从上
        到下依次是下折痕、下折痕和上折痕。
        给定一 个输入参数N，代表纸条都从下边向上方连续对折N次，请从上到下打印所有折痕的方向 例如：N=1时，打
        印： down；N=2时，打印： down down up

分析：
        我们把对折后的纸张翻过来，让粉色朝下，这时把第一次对折产生的折痕看做是根结点，那第二次对折产生的下折
        痕就是该结点的左子结点，而第二次对折产生的上折痕就是该结点的右子结点，这样我们就可以使用树型数据结构
        来描述对折后产生的折痕。

这棵树有这样的特点：
        1.根结点为下折痕；
        2.每一个结点的左子结点为下折痕；
        3.每一个结点的右子结点为上折痕；

实现步骤：
        1.定义结点类
        2.构建深度为N的折痕树；
        3.使用中序遍历，打印出树中所有结点的内容；

构建深度为N的折痕树：
        1.第一次对折，只有一条折痕，创建根结点；
        2.如果不是第一次对折，则使用队列保存根结点；
        3.循环遍历队列：
        3.1从队列中拿出一个结点；
        3.2如果这个结点的左子结点不为空，则把这个左子结点添加到队列中；
        3.3如果这个结点的右子结点不为空，则把这个右子结点添加到队列中；
        3.4判断当前结点的左子结点和右子结点都不为空，如果是，则需要为当前结点创建一个值为down的左子结点，一个值为up的右子结点。


 */
public class C02_PagerFoldingTest {

    private static class Node<T> {
        public T item; // 记录当前折痕产up,还是down
        public Node left;
        public Node right;

        public Node(T item, Node<T> left, Node<T> right) {
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }



    //2.构建深度为N的折痕树；
    private static Node createTree(int N) {
        Node<String> root = null; // 根结点

        for (int i = 0; i < N; i++) {
            if (i == 0 ) {
                root = new Node<String>("down", null, null);
            } else {
                //3.1从队列中拿出一个结点；
                C10_Queue<Node> queue = new C10_Queue<Node>();
                queue.enqueue(root);

                while (!queue.isEmpty()) {
                    //3.2如果这个结点的左子结点不为空，则把这个左子结点添加到队列中；
                    Node<String> temp = queue.dequeue();
                    if (temp.left != null) {
                        queue.enqueue(temp.left);
                    }

                    //3.3如果这个结点的右子结点不为空，则把这个右子结点添加到队列中；
                    if (temp.right != null) {
                        queue.enqueue(temp.right);
                    }

                    //3.4 如果同时没有左子结点和右子结点，那么证明该节点是叶子节点，只需要给该节点添加左子结点和右子结点即可
                    if (temp.left == null && temp.right == null) {
                        temp.left = new Node<String>("down", null, null);
                        temp.right = new Node<String>("up", null, null);
                    }
                }
            }
        }

        return root;
    }

    //3.使用中序遍历，打印出树中所有结点的内容；
    private static void printTree(Node tree) {
        if (tree == null) {
            return;
        }

        if (tree.left != null) {
            printTree(tree.left);
        }

        System.out.print(tree.item + " ");

        if (tree.right != null) {
            printTree(tree.right);
        }
    }

    public static void main(String[] args) {
        //构建折痕树
        Node tree = createTree(2);
        //遍历折痕树，并打印
        printTree(tree);
    }
}
