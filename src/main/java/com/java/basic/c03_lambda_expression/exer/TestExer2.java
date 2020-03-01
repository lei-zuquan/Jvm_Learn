package com.java.basic.c03_lambda_expression.exer;

import java.util.ArrayList;

/**
 * 练习2：
 *      使用removeIf(Predicate p) 方法删除元素
 *      创建一个ArrayList集合，保存本组学员的对象（Student)
 *      删除成绩不合格的学员
 *
 *      Student类型：学号，姓名，成绩
 */
public class TestExer2 {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student(1, "zhangsan", 56));
        list.add(new Student(2, "lisi", 45));
        list.add(new Student(3, "wangwu", 90));

        /**
         * Predicate: 判断型接口  boolean xxx(T t)
         * Lambda表达式的形参列表：（T t)， 省略后t
         * Lambda体，就一个判断条件，这个判断为真true，要删除
         *
         */

        list.removeIf(t -> t.getScore() < 60);
        list.forEach(t -> System.out.println(t));
    }
}
