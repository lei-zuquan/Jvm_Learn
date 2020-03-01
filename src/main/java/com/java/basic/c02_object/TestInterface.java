package com.java.basic.c02_object;

/**
 * 接口：
 *      代表一种标准
 *
 * 例如：
 *   1、   JDBC:   Java Database Connectivity, 用JAVA连接各种数据库。
 *      数据库有很多种：sql server, access, mysql, oracle, redis, mangodb...
 *      这些数据是由不同的公司（产商）来生产，开发的。
 *      Java程序：去连接不同的数据库时，使用相同的代码。
 *      Java连接和操作mysql数据库的代码，同样可以用来连接和操作oracle数据库，sql server
 *      希望这个Java代码具有通用性，那么Java就要指定一个标准。
 *
 *      这些标准通常就是一些接口。这些接口公布出来，由各个数据库的厂商来实现它。
 *      Connection, Statement,...接口
 *      mysql: MysqlConnection, MysqlStatement...
 *      oracle: OracleConnection, OracleStatement...
 *      这些实现类，通过jar更换就可以实现，而编程的代码中，面向接口编程。
 *
 *   2、现在我想设计一个数组的工具类MyArrays，这个工具类中有一个方法，可以为任意的对象数组进行排序，从小到大排序。
 *   public void sort(Object[] arr){
 *
 *   }
 */
public class TestInterface {

}
