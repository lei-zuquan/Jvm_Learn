package com.java.basic.c06_generic;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 6:18 下午 2020/3/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import java.util.ArrayList;
import java.util.Iterator;

/**
 * day22_14泛型练习（2）
 *
 * 2、练习2：
 *      把本组学员的对象（Student）存储到一个ArrayList中，并且用foreach和Iterator分别遍历
 *
 */
public class TestExer2 {
    public static void main(String[] args) {
        ArrayList<StudentExer2> list = new ArrayList<>();

        list.add(new StudentExer2(1, "zhangsan", 8));
        list.add(new StudentExer2(2, "lisi", 12));
        list.add(new StudentExer2(3, "wangwu", 30));

        for (StudentExer2 studentExer2 : list) {
            System.out.println(studentExer2);
        }

        System.out.println();

        Iterator<StudentExer2> iterator = list.iterator();
        while (iterator.hasNext()){
            StudentExer2 next = iterator.next();
            System.out.println(next.getId() + "," + next.getName());
        }

    }
}


class StudentExer2 {
    private int id;
    private String name;
    private int score;

    public StudentExer2(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentExer2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}