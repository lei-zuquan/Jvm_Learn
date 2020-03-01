package com.java.basic.c05_collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 数组：
 *      缺点：1）长度固定，如果要扩容等需要程序自己维护，如果要删除和插入，程序员要移动元素等
 *           2）数组只支持"可重复，顺序存储"特点，比较单一
 * 集合：很多容器
 *      实际开发，数据的存储特点：1）有序的  2）无序的   3）可以重复的 4）不能重复的 5）一对一的  6）一对多...
 *      JDK在1）数组    2）链式结构基础上，重新设计出了很多的容器类型。
 *
 * 主要是两大类：
 *      1、Collection: 一组对象，比喻"单身party"
 *      2、Map: 键值对，（key,value), 比喻"情侣party"，"家庭party"
 *
 * 容器有共同的行为特征，操作方式：
 * 增、删、改、查...
 *
 * 把对容器的操作的行为标准化，用接口来声明。
 *
 * 一、java.util.Collection
 *  （一）Collection概述
 *      Collection 层次结构中的根接口。Collection表示一组对象。
 *      一些collection允许有重复的元素，而另一些则不允许。一些collection是有序的；而另一些则是无序的
 *
 *      1、List
 *          列表：可重复，有序的（按顺序存储）
 *          实现类：例如ArrayList(动态数组)
 *      2、Set
 *          集：不可重复的，无序的（和添加顺序无关）
 *
 *  （二）Collection方法
 *      1、添加
 *          （1）add(Object obj)  : 一次添加一个
 *          （2）addAll(Collection other) : 一次添加多个，把other中的元素都添加到当前集合中
 *                  this = this U (并) other
 *
 *      2、删除
 *          1）remove(Object c)
 *          2）removeAll(Collection other): 一次删除多个
 *                      this = this - this （交）other
 *          3) clear()
 *      3、修改: Collection根接口中没有提供修改的方法
 *
 *      4、查询:
 *          1）boolean contains(Object o): 判断o是否在当前集合中
 *          2）boolean containsAll(Collection<?> c):判断c中的元素都在当前集合中
 *                  即判断c是否是this的子集
 *          3）boolean isEmpty()
 *
 *          Collection根接口中没有提供获取一个元素的方法。
 *
 *      5、获取有效元素的个数
 *          int size()
 *
 *      6、遍历
 *          1) 老方法
 *          Object[] toArray():如果该集合的底层实现就是数组，那么比较简单，但是如果该集合的底层不是数组，那么比较麻烦
 *              无论底层怎么样，都会返回一个size长度的数组，所以比较浪费空间。
 *          2) foreach
 *          3) Iterator迭代器遍历
 *
 *      7、其他
 *          retainAll(Collection<?> c) : 保留当前集合和c集合的交集
 */
public class TestCollection {
    @SuppressWarnings("all")
    @Test
    public void test1(){
        // 多态引用，关注Collection的方法，ArrayList是Collection子接口List的实现类
        Collection c = new ArrayList();
        c.add("zhangsan");
        c.add("lisi");

        Collection other = new ArrayList();
        other.add("wangwu");
        other.add("zhaoliu");

        //c.addAll(other);
        c.add(other);
        System.out.println(c.size());

        Object[] array = c.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
