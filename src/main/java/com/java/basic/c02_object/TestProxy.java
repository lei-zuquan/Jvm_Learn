package com.java.basic.c02_object;

/**
 * 静态代理模式：（了解）
 *
 * 代理：
 *      代理可以帮助被代理者完成一些前期的准备工作，后期的善后工作。核心的业务逻辑仍然由被代理者完成。
 *
 * 代码结构：
 *      1）接口：主题
 *      2）被代理者
 *      3）代理者
 * 要求：代理类和被代理类实现同一个主题接口
 *          代理类中要有一个被代理类的的属性（target），这样才能把核心业务代码交给被代理者完成
 *
 * 这些需求和核心逻辑无关的代码，而且多变，那么这样的代码可以交给代理完成。
 * 需求：
 *      1、要计算add()的运行时间
 *      2、记录add()的开始执行，已经结束执行的时间到日志中
 *      3、可能在测试阶段使用
 */
public class TestProxy {
    public static void main(String[] args) {
        // 使用代理类和被代理类来完成工作
        UserDAO bei = new UserDAO(); //  被代理者
        UserDAOProxy up = new UserDAOProxy(bei);// 代理者
        up.add();
    }
}

// 操作数据库的数据
// 接口
interface DAO{
    void add();
}

// 被代理者
class UserDAO implements DAO{

    @Override
    public void add() {
        System.out.println("添加用户");
    }
}

// 代理者
class UserDAOProxy implements DAO{

    private DAO target; // 被代理者

    public UserDAOProxy(DAO target) {
        this.target = target;
    }

    @Override
    public void add() {
        System.out.println("add方法开始执行");
        long start = System.currentTimeMillis();

        //核心业务逻辑要交还给被代理者完成
        target.add();

        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        System.out.println("add方法结束执行");
    }
}