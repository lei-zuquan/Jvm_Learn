package com.java.z_exam.algorithm.linear;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:51 下午 2020/5/26
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
查找有环链表中环的入口结点

当快慢指针相遇时，我们可以判断到链表中有环，这时重新设定一个新指针指向链表的起点，且步长与慢指针一样
为1，则慢指针与“新”指针相遇的地方就是环的入口。证明这一结论牵涉到数论的知识，这里略，只讲实现。
 */
public class C05_FastSlowPointer_CircleListIn {
    public static void main(String[] args) {
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> six = new Node<String>("ff", null);
        Node<String> seven = new Node<String>("gg", null);

        //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;
        //产生环
        seven.next = third;
        //查找环的入口结点
        Node<String> entrance = getEntrance(first);
        System.out.println("first链表中环的入口结点元素为："+entrance.item);
    }

    /**
     * 查找有环链表中环的入口结点
     * @param first 链表首结点
     * @return 环的入口结点
     */
    public static Node getEntrance(Node<String> first) {
        Node<String> slow = first;
        Node<String> fast = first;
        Node<String> temp = null;

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow=slow.next;
            if (fast.equals(slow)){
                temp = first; continue;
            }
            if (temp!=null){
                temp=temp.next;
                if (temp.equals(slow)){
                    return temp;
                }
            }
        }
        return null;
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
