package com.java.z_exam.algorithm.c05_tree;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-06-03 9:08
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
红黑树是含有红黑链接并满足下列条件的二叉查找树：
    1. 红链接均为左链接；
    2. 没有任何一个结点同时和两条红链接相连；
    3. 该树是完美黑色平衡的，即任意空链接到根结点的路径上的黑链接数量相同；

红黑树结点API
    因为每个结点都只会有一条指向自己的链接（从它的父结点指向它），我们可以在之前的Node结点中添加一个布
    尔类型的变量color来表示链接的颜色。如果指向它的链接是红色的，那么该变量的值为true，如果链接是黑色
    的，那么该变量的值为false。

类名 Node<Key,Value>
构造方法 Node(Key key, Value value, Node left, Node right，boolean color)：创建Node对象
成员变量
    1.public Node left:记录左子结点
    2.public Node right:记录右子结点
    3.public Key key:存储键
    4.public Value value:存储值
    5.public boolean color:由其父结点指向它的链接的颜色

平衡化
在对红黑树进行一些增删改查的操作后，很有可能会出现红色的右链接或者两条连续红色的链接，而这些都不满足
红黑树的定义，所以我们需要对这些情况通过旋转进行修复，让红黑树保持平衡。
左旋
    当某个结点的左子结点为黑色，右子结点为红色，此时需要左旋。
    前提：当前结点为h，它的右子结点为x；
左旋过程：
     1.让x的左子结点变为h的右子结点：h.right=x.left;
     2.让h成为x的左子结点：x.left=h;
     3.让h的color属性变为x的color属性值：x.color=h.color;
     4.让h的color属性变为RED：h.color=true;

右旋
    当某个结点的左子结点是红色，且左子结点的左子结点也是红色，需要右旋
    前提：当前结点为h，它的左子结点为x；
右旋过程：
     1. 让x的右子结点成为h的左子结点：h.left = x.right;
     2. 让h成为x的右子结点：x.right=h;
     3. 让x的color变为h的color属性值：x.color = h.color;
     4. 让h的color为RED；

颜色反转
    当一个结点的左子结点和右子结点的color都为RED时，也就是出现了临时的4-结点，此时只需要把左子结点和右子
    结点的颜色变为BLACK，同时让当前结点的颜色变为RED即可。
 */
//红黑树代码 
public class C03_RedBlackTree<Key extends Comparable<Key>, Value> {
    //结点类 
    private class Node {
        //存储键 
        public Key key;
        //存储值 
        private Value value;
        //记录左子结点 
        public Node left;
        //记录右子结点 
        public Node right;
        //由其父结点指向它的链接的颜色 
        public boolean color;

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }


    //根节点
    private Node root;
    //记录树中元素的个数 
    private int N;
    //红色链接 
    private static final boolean RED = true;
    //黑色链接 
    private static final boolean BLACK = false;

    /**
     * 判断当前节点的父指向链接是否为红色
     *
     * @param x
     * @return
     */
    private boolean isRed(Node x) {
        //空结点默认是黑色链接 
        if (x == null) {
            return false;
        }
        //非空结点需要判断结点color属性的值 
        return x.color == RED;
    }


    /**
     * 左旋转
     *
     * @param h
     * @return
     */
    private Node rotateLeft(Node h) {
        //找出当前结点h的右子结点
        Node hRight = h.right;
        //找出右子结点的左子结点
        Node lhRight = hRight.left;
        //让当前结点h的右子结点的左子结点成为当前结点的右子结点
        h.right = lhRight;
        //让当前结点h称为右子结点的左子结点
        hRight.left = h;
        //让当前结点h的color编程右子结点的color
        hRight.color = h.color;
        //让当前结点h的color变为RED
        h.color = RED;
        //返回当前结点的右子结点
        return hRight;
    }

    /**
     * 右旋 *
     *
     * @param h
     * @return
     */
    private Node rotateRight(Node h) {
        //找出当前结点h的左子结点
        Node hLeft = h.left;
        //找出当前结点h的左子结点的右子结点
        Node rHleft = hLeft.right;
        //让当前结点h的左子结点的右子结点称为当前结点的左子结点
        h.left = rHleft;
        //让当前结点称为左子结点的右子结点
        hLeft.right = h;
        //让当前结点h的color值称为左子结点的color值
        hLeft.color = h.color;
        //让当前结点h的color变为RED
        h.color = RED;
        //返回当前结点的左子结点
        return hLeft;
    }


    /**
     * 颜色反转,相当于完成拆分4-节点 *
     *
     * @param h
     */
    private void flipColors(Node h) {
        //当前结点的color属性值变为RED； 
        h.color = RED;
        //当前结点的左右子结点的color属性值都变为黑色 
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    /**
     * 在整个树上完成插入操作
     *
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        //在root整个树上插入key-val
        root = put(root, key, val);
        //让根结点的颜色变为BLACK
        root.color = BLACK;
    }

    /**
     * 在指定树中，完成插入操作,并返回添加元素后新的树
     *
     * @param h
     * @param key
     * @param val
     */
    private Node put(Node h, Key key, Value val) {
        if (h == null) {
            //标准的插入操作，和父结点用红链接相连
            N++;
            return new Node(key, val, null, null, RED);
        }
        //比较要插入的键和当前结点的键
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            //继续寻找左子树插入
            h.left = put(h.left, key, val);
        } else if (cmp > 0) {
            //继续寻找右子树插入
            h.right = put(h.right, key, val);
        } else {
            //已经有相同的结点存在，修改节点的值；
            h.value = val;
        }
        //如果当前结点的右链接是红色，左链接是黑色，需要左旋
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        //如果当前结点的左子结点和左子结点的左子结点都是红色链接，则需要右旋
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        //如果当前结点的左链接和右链接都是红色，需要颜色变换
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        //返回当前结点
        return h;
    }

    //根据key，从树中找出对应的值
    public Value get(Key key) {
        return get(root, key);
    }

    //从指定的树x中，查找key对应的值
    public Value get(Node x, Key key) {
        //如果当前结点为空，则没有找到,返回null
        if (x == null) {
            return null;
        }
        //比较当前结点的键和key
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            //如果要查询的key小于当前结点的key，则继续找当前结点的左子结点；
            return get(x.left, key);
        } else if (cmp > 0) {
            //如果要查询的key大于当前结点的key，则继续找当前结点的右子结点； 
            return get(x.right, key);
        } else {
            //如果要查询的key等于当前结点的key，则树中返回当前结点的value。 
            return x.value;
        }
    }

    //获取树中元素的个数
    public int size() {
        return N;
    }

    public static void main(String[] args) {
        C03_RedBlackTree<Integer, String> bt = new C03_RedBlackTree<>();
        bt.put(4, "二哈");
        bt.put(1, "张三");
        bt.put(3, "李四");
        bt.put(5, "王五");
        System.out.println(bt.size());
        bt.put(1, "老三");
        System.out.println(bt.get(1));
        System.out.println(bt.size());
    }
}