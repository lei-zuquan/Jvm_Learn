package com.java.z_exam.algorithm.linear;

import java.util.Iterator;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:27 下午 2020/5/25
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
get(i):不难看出，不论数据元素量N有多大，只需要一次eles[i]就可以获取到对应的元素，所以时间复杂度为O(1);
insert(int i,T t):每一次插入，都需要把i位置后面的元素移动一次，随着元素数量N的增大，移动的元素也越多，时
间复杂为O(n);
remove(int i):每一次删除，都需要把i位置后面的元素移动一次，随着数据量N的增大,移动的元素也越多，时间复
杂度为O(n);
由于顺序表的底层由数组实现，数组的长度是固定的，所以在操作的过程中涉及到了容器扩容操作。这样会导致顺
序表在使用过程中的时间复杂度不是线性的，在某些需要扩容的结点处，耗时会突增，尤其是元素越多，这个问题
越明显

 */
//顺序表代码
public class C01_SequenceList<T> implements Iterable<T> {
    //存储元素的数组
    private T[] eles;
    //记录当前顺序表中的元素个数
    private int N;
    //构造方法
    public C01_SequenceList(int capacity){
        eles = (T[])new Object[capacity];
        N=0;
    }
    //将一个线性表置为空表
    public void clear(){
        N=0;
    }
    //判断当前线性表是否为空表
    public boolean isEmpty(){
        return N==0;
    }

    //获取线性表的长度
    public int length(){
        return N;
    }
    //获取指定位置的元素
    public T get(int i){
        if (i<0 || i>=N){
            throw new RuntimeException("当前元素不存在！");
        }
        return eles[i];
    }
    //向线型表中添加元素t
    public void insert(T t){
        if (N==eles.length){
            resize(eles.length*2);
        }

        eles[N++] =t;
    }

    //在i元素处插入元素t
    public void insert(int i,T t){
        if (i==eles.length){
            throw new RuntimeException("当前表已满");
        }if (i<0 || i>N){
            throw new RuntimeException("插入的位置不合法");
        }

        //元素已经放满了数组，需要扩容
        if (N==eles.length){
            resize(eles.length*2);
        }


        //把i位置空出来，i位置及其后面的元素依次向后移动一位
        for (int index=N;index>i;index--){
            eles[index]=eles[index-1];
        }
        //把t放到i位置处
        eles[i]=t;
        //元素数量+1
        N++;
    }

    //删除指定位置i处的元素，并返回该元素
    public T remove(int i){
        if (i<0 || i>N-1){
            throw new RuntimeException("当前要删除的元素不存在");
        }
        //记录i位置处的元素
        T result = eles[i];
        //把i位置后面的元素都向前移动一位
        for (int index=i;index<N-1;index++){
            eles[index]=eles[index+1];
        }
        //当前元素数量-1
        N--;

        //当元素已经不足数组大小的1/4,则重置数组的大小
        if (N>0 && N<eles.length/4){
            resize(eles.length/2);
        }

        return result;
    }
    //查找t元素第一次出现的位置
    public int indexOf(T t){
        if(t==null){
            throw new RuntimeException("查找的元素不合法");
        }
        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }



    //打印当前线性表的元素
    public void showEles(){
        for (int i = 0; i < N; i++) {
            System.out.print(eles[i]+" ");
        }
        System.out.println();
    }

    @Override
    public Iterator iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{

        private int cur; public SIterator(){
            this.cur=0;
        }

        @Override
        public boolean hasNext() {
            return cur<N;
        }

        @Override
        public T next() {
            return eles[cur++];
        }
    }


    //改变容量
    private void resize(int newSize){
        //记录旧数组
        T[] temp = eles;
        //创建新数组
        eles = (T[]) new Object[newSize];
        //把旧数组中的元素拷贝到新数组
        for (int i = 0; i < N; i++) {
            eles[i] = temp[i];
        }
    }

    public int capacity(){
        return eles.length;
    }
}
