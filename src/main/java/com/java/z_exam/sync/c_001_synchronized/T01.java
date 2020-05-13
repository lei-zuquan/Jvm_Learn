package com.java.z_exam.sync.c_001_synchronized;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-04-29 9:12
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T01 {

    private int count = 10;
    private Object o = new Object();

    public void m () {
        synchronized (o) { //任何线程要执行下面的代码，必须先拿到o的锁
            count--;
            System.out.println(Thread.currentThread().getName() + " count = " + count);
        }
    }

}

/*
第一个是多个线程去访问同一个资源的时候，对这个资源要上锁。为什么要上锁呢？访问某一段代码或者某临界资源的时候是需要有一把锁的概念的。

比如：我们对一个数字做递增，两个程序对它一块儿来做递增，递增就是把一个程序往上加1，如果两个线程共同访问的时候，第一个线程读它是0，
然后把它加1，在自己线程内部内存里面算还没有写回去的时候，第二个线程读到了它还是0，加1再写回去，本来加了两次，但是还是1。

那么我们在对这个数字递增的过程中上把锁，就是说第一个线程对这个数字访问的时候是独占的，不允许别的线程来访问，不允许别的线程来对它进行计算，
我必须加完1再释放锁，其他线程才能对它继续加。

实质上，这把锁并不是对数字进行锁定的，你可以任意指定，想锁谁就锁谁。

我第一个程序是这么写的，如果说你想上了把锁之后才能对count进行减减访问，你可以new一个Object，所以这里锁定就是0，当我拿到这把锁的时候才能执行这段代码。
 */