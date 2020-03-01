package com.java.basic.c03_lambda_expression;


/**
 * JDK1.8增加了很多包，其中一个包java.util.function
 *      Functional interfaces provide target types for lambda expressions and method reference
 *      函数式接口是Lambda表达式的方法引用的目标类型
 *
 *  主要分为四大类：
 *      1、消纲型接口（Consumer）
 *          这类接口的特点是，它的抽象方法：有参无返回值
 *      2、供给型接口（Supplier）
 *          这类接口的特点是，它的抽象方法：无参有返回值
 *      3、判断型接口（Predicate）
 *          这类接口的特点是，它的抽象方法：boolean test(有参) 无论你给我什么参数，都是用来判断条件，结果只有true,false
 *      4、功能型接口（Function）
 *          这类接口的特点是，它的抽象方法：有参有返回值
 *
 *      在java.util.funtion包中提供了，以后开发中能够遇到的所有函数式接口的类型，对于抽象方法是"无参无返回值"的情况，因为
 *      其他的接口，基本上不需要你自己声明，直接用它这里提供的就可以了。
 */
public class C_01JieShao {

}















