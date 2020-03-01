package com.java.basic.c03_lambda_expression.exer;

// EnglistStudent类型：学号、姓名（用英文名）、成绩，
public class EnglishStudent implements Comparable<EnglishStudent>{

    private int id;
    private String name;
    private int score;

    public EnglishStudent(int id, String name, int score) {
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
        return "EnglishStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(EnglishStudent o) {
        return this.id - o.id;
    }
}
