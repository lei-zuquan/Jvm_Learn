package com.java.basic.c03_lambda_expression.stream;

import com.java.basic.c03_lambda_expression.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * 二、中间操作
 * 1、filter(Predicate p)    : 按照p的条件过滤
 * 2、distinct()             : 去重复
 * 3、limit(long maxSize)    : 取流中的前maxSize个
 * 4、skip(long n)           : 跳过前n个
 * 5、peek(Consumer action)  : 对流中的元素，挨个执行Consumer接口的action操作
 * 6、sorted()
 *      sorted(Comparator com) : 产生一个新流，其中按比较器顺序排序
 * 7、map(Function f)        : 对流中的每一个元素，都映射f指定的操作
 * 8、flatMap(Function f)    :
 */
public class TestMiddleStream {
    @Test
    public void test11(){
        Stream.of("hello,world,java","张三,李四,王五")
                .flatMap(t -> Stream.of(t.split(",")))
                .forEach(System.out::println);
    }
    @Test
    public void test10(){
        Stream.of(1,2,3,4,5,6,7,8,9,10)
                /**
                 * Function: R apply(T t)
                 */
                .map(t -> t*10)
                .forEach(System.out::println);
    }
    @Test
    public void test9(){
        Stream.of(3,1,2,4,5,6,7,8,9,10)
                .sorted((t1,t2) -> -Integer.compare(t1,t2))
                .forEach(System.out::println);
    }
    @Test
    public void test7(){
        Stream.of(3,1,2,4,5,6,7,8,9,10).sorted().forEach(System.out::println);
    }
    @Test
    public void test6(){
        long count = Stream.of(1,2,3,4,5,6,7,8,9,10)
                .filter(t -> t%2 == 0)
                .peek(System.out::println) // Consumer消费型接口
                .count();
        System.out.println("偶数的个数有：" + count);
    }
    @Test
    public void test5(){
        Stream.of(1,2,3,4,5,6,7,8,9,10)
                .limit(3)
                .forEach(System.out::println);
    }
    @Test
    public void test4(){
        Stream.of(1,2,3,4,5,6,7,8,9,10)
                .skip(3)
                .forEach(System.out::println);
    }

    @Test
    public void test3(){
        ArrayList<Employee> list = new ArrayList<Employee>();
        list.add(new Employee(1,"张三",10000));
        list.add(new Employee(1,"张三",10000));
        list.add(new Employee(2,"李四",8000));
        list.add(new Employee(3,"张三",6000));

        System.out.println(list.size());

        // 1、创建Stream对象
        list.stream()                                  // 1、创建stream
                .filter(t -> t.getSalary() >= 10000)   // 2、（1）先去掉薪资 低于10000的
                .distinct()                            // 2、（2）去重
                .forEach(System.out::println);         // 3、终结 遍历

    }
    @Test
    public void testDistinct(){
        ArrayList<Employee> list = new ArrayList<Employee>();
        list.add(new Employee(1,"张三",10000));
        list.add(new Employee(1,"张三",10000));

        System.out.println(list.size());

        // 1、创建Stream对象
        Stream<Employee> stream = list.stream();

        // 2、distinct去重，依赖于元素的equals方法

        stream.distinct().forEach(System.out::println);
    }
    @Test
    public void testFilter(){
        ArrayList<Employee> list = new ArrayList<Employee>();
        list.add(new Employee(1,"张三",10000));
        list.add(new Employee(1,"张三",10000));

        System.out.println(list.size());

        // 1、创建Stream对象
        Stream<Employee> stream = list.stream();

        // 2、过滤，过滤掉"名字为张三的"
        /**
         * Predicate: 判断型接口 boolean test(T t)
         *
         */

        stream.filter(t -> !"张三".equals(t.getName())).forEach(System.out::println);
    }
}
