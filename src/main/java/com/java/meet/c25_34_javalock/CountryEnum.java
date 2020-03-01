package com.java.meet.c25_34_javalock;


import lombok.Getter;

/**
 * 枚举，相当于简易版的数据库
 * mysql dbName = CountryEnum
 *
 * table
 * one
 * id   userName    age birth   userEmail
 *
 */
public enum CountryEnum {

    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),
    FOUR(4,"赵"),FIVE(5,"魏"),SIX(6,"韩");

    @Getter private Integer retCode;
    @Getter private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static CountryEnum forEach_CountryEnum(int index){
        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum element: myArray){
            if (index == element.getRetCode()){
                return element;
            }
        }
        return null;
    }
}
