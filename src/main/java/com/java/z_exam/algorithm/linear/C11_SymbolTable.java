package com.java.z_exam.algorithm.linear;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:19 上午 2020/5/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
符号表
        符号表最主要的目的就是将一个键和一个值联系起来，符号表能够将存储的数据元素是一个键和一个值共同组成的
        键值对数据，我们可以根据键来查找对应的值。


符号表中，键具有唯一性。
符号表在实际生活中的使用场景是非常广泛的，见下表：

应用          查找目的                        键               值
字典          找出单词的释义                 单词              释义
图书索引       找出某个术语相关的页码          术语              一串页码
网络搜索       找出某个关键字对应的网页         关键字             网页名称

符号表API设计
结点类：
    类名 Node<Key,Value>
    构造方法 Node(Key key,Value value,Node next)：创建Node对象
成员变量
    1.public Key key:存储键
    2.public Value value:存储值
    3.public Node next:存储下一个结点


符号表：
类名 SymbolTable<Key,Value>
构造方法 SymbolTable()：创建SymbolTable对象
成员方法
    1.public Value get(Key key)：根据键key，找对应的值
    2.public void put(Key key,Value val):向符号表中插入一个键值对
    3.public void delete(Key key):删除键为key的键值对
    4.public int size()：获取符号表的大小
成员变量
    1.private Node head:记录首结点
    2.private int N:记录符号表中键值对的个数

 */
public class C11_SymbolTable<Key, Value> {

    private class Node {
        public Key key; // 存储键
        public Value value; // 存储值
        public Node next; // 存储下一个节点

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node head; // 记录首结点
    private int N; // 记录符号表中键值对的个数

    public C11_SymbolTable() {
        head = new Node(null, null, null);
        N = 0;
    }

    // 根据键key，找对应的值
    public Value get(Key key){
        Node currNode = head;
        while (currNode.next != null) {
            currNode = currNode.next;
            if (currNode.key.equals(key)){
                return currNode.value;
            }

        }
        return null;
    }

    // 向符号表中插入一个键值对，注意：符号表中，键具有唯一性。
    public void put(Key key,Value val){
        //先从符号表中查找键为key的键值对
        Node currNode = head;
        while (currNode.next != null){

            currNode = currNode.next;
            if (currNode.key.equals(key)) {
                return;
            }

        }

        //符号表中没有键为key的键值对
        // 方式一：
        Node newNode = new Node(key, val, null);
        currNode.next = newNode;
        N++;
        // 方式二：
        /*Node oldFirst = head.next;
        Node newNode = new Node(key, val, oldFirst);
        head.next = newNode;
        N++;*/
    }

    // 删除键为key的键值对
    public void delete(Key key){
        Node currNode = head;
        while (currNode.next!= null){
            Node currNodeNext = currNode.next;

            if (currNodeNext.key.equals(key)) {
                currNode.next = currNodeNext.next;
                N--;
                return;
            }

        }
    }

    // 获取符号表的大小
    public int size() {
        return N;
    }

    public static void main(String[] args) {
        C11_SymbolTable<Integer, String> st = new C11_SymbolTable<>();
        st.put(1, "张三");
        st.put(3, "李四");
        st.put(5, "王五");
        System.out.println(st.size());
        st.put(1,"老三");

        System.out.println(st.get(1));
        System.out.println(st.size());
        st.delete(1);
        System.out.println(st.size());
    }

}















