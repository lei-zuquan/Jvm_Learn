package com.java.basic.c04_data;

import java.util.Arrays;

/**
 * 自定义一个容器类型：MyArrayList
 * 希望底层是用数组
 *
 */
public class MyArrayList {

    private Object[] data;
    private int total;

    public MyArrayList(){
        data = new Object[10]; // 默认初始化大小
    }

    // 添加元素
    public void add(Object obj){
        // 是否已满
        if (total >= data.length){
            // 扩容
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[total++] = obj;
    }

    // 获取有效元素的个数
    public int size(){
        return total;
    }

    // 把数据用数组返回
    public Object[] toArray(){
        return Arrays.copyOf(data, total);
    }

    // 获取index位置的元素
    public Object get(int index){
        if (index < 0 || index >= total){
            throw new IndexOutOfBoundsException(index + "不合法");
        }
        return data[index];
    }

    // 查找obj在当前容器中的索引，如果没有，返回-1
    public int indexOf(Object obj){
        int index = -1;
        if (obj == null){
            for (int i = 0; i < total; i++) {
                if (obj == data[i]){
                    index = i;
                    break;
                }
            }
        } else {
            for (int i = 0; i < total; i++) {
                if (obj.equals(data[i])){
                    index = i;
                    break;
                }
            }
        }


        return index;
    }

    // 删除当前容器中的obj对象
    public void remove(Object obj){
        // 1)找obj的位置
        int index = indexOf(obj);
        // 2)删除
        if (index != 1){
            System.arraycopy(data, index+1, data, index, total-index-1);
            data[--total] = null;
        }
    }

    // 把当前容器中的old替换为dest
    // 只限定只替换第一个找到
    public void set(Object old, Object dest){
        int index = indexOf(old);
        if (index != -1){
            data[index] = dest;
        }
    }
}
