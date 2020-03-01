package com.java.basic.c03_lambda_expression;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 三、判断型（断定型）接口
 *      抽象方法：boolean test(参数)
 *
 * 1、最基本的代表
 *      Predicate<T> boolean test(T t)
 * 2、其他的变形
 *      BiPredicate<T, U> boolean test(T t, U u)
 *      DoublePredicate   boolean test(double value)
 *      IntPredicate      boolean test(int value)
 *      LongPredicate     boolean test(long value)
 *
 * 例如：java.util.Collection<E>
 *          default boolean removeIf(Predicate<? super E> filter)
 */
public class TestPredicate {

    @Test
    public void test(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }

        // 删除3的倍数的无素
        /**
        // 如果元素再多，则删除代码行过多
        list.remove(3);
        list.remove(6);
        list.remove(9);
         */

        /**
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer num = iterator.next();
            if (num % 3 == 0){
                iterator.remove();
            }
        }*/

        list.removeIf(t -> t%3 == 0);

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
