package com.java.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 04_集合类不安全
 * 05_集合类不安全2
 *
 * 1 故障现象
 *      Exception in thread "9" java.util.ConcurrentModificationException
 *
 * 2 导致原因
 *
 *
 * 3 解决方法
 *      3.1 new Vector<>();
 *      3.2 Collections.synchronizedList(new ArrayList<>());
 *      3.3 new CopyOnWriteArrayList();  // 写时复制
 *
 * 4 优化建议（同样的错误不犯第2次）
 *
 */
public class C_04_05_NotSafeDemo03 {

    public static void main(String[] args) {
        //Map<String,String> map = new HashMap<String, String>();
        Map<String,String> map = new ConcurrentHashMap<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {new Vector<>();
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }

    }

    private static void setNotSafe() {
        //Set<String> set = new HashSet<>();
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {new Vector<>();
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }

    private static void listNotSafe() {
        // new arrayList java8默认 10个元素，底层会发生扩容；如果存放14个元素，它扩容扩到多少，15，
        // 请问第一次扩容到多少 15 + 15/2 = 22; ArrayList是线程不安全；请写一个case证明线程不安全，解决方案

        //List<String> list = new ArrayList<>();
        //List<String> list = new Vector<>();
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList();

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {new Vector<>();
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
