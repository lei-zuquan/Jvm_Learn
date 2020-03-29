package com.java.basic.c10_fanshe.c05_proxy.c01_static_proxy;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 10:50 下午 2020/3/29
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * day27_15静态代理（复习）
 *
 * 代理模式：
 *      1、静态代理
 *      2、动态代理
 *
 * 静态代理：
 *      让代理类替被代理类完成一些"非业务"代码，核心业务代码还是交给被代理者自己完成。
 *
 *      例如：给所有方法都增加一个功能，统计该方法的运行时间
 *
 * 代理模式：
 *      1、主题接口
 *      2、被代理类
 *      3、代理类
 *
 */
public class TestStaticProxy {
    public static void main(String[] args) {
        // new UserDaoImpl()被代理者对象
        // new UserDaoProxy(xx)是代理者对象
        UserDao ud = new UserDaoProxy(new UserDaoImpl());
        ud.insert();
    }
}

// 1、主题接口
interface UserDao{
    void insert();
    void delete();
    void update();
    void select();
}

// 2、被代理类
class UserDaoImpl implements UserDao {

    @Override
    public void insert() {
        System.out.println("添加用户");
    }

    @Override
    public void delete() {
        System.out.println("删除用户");
    }

    @Override
    public void update() {
        System.out.println("更新用户");
    }

    @Override
    public void select() {
        System.out.println("查询用户");
    }
}

// 3、代理类
// (1)和被代理类必须实现同样的主题接口
// (2)因为要把核心业务代码交换给被代理者自己完成，因此，需要在代理类中，保存（持有）被代理者对象的引用
class UserDaoProxy implements UserDao {
    private UserDao target;

    public UserDaoProxy(UserDao target) {
        //super();
        this.target = target;
    }

    @Override
    public void insert() {
        long start = System.currentTimeMillis();
        System.out.println("开始执行insert方法");

        // 执行真正的业务代码
        target.select();

        long end = System.currentTimeMillis();
        System.out.println("结束执行insert方法");
        System.out.println("耗时：" + (end - start));
    }

    @Override
    public void delete() {
        long start = System.currentTimeMillis();
        System.out.println("开始执行delete方法");

        // 执行真正的业务代码
        target.select();

        long end = System.currentTimeMillis();
        System.out.println("结束执行delete方法");
        System.out.println("耗时：" + (end - start));
    }

    @Override
    public void update() {
        long start = System.currentTimeMillis();
        System.out.println("开始执行update方法");

        // 执行真正的业务代码
        target.select();

        long end = System.currentTimeMillis();
        System.out.println("结束执行update方法");
        System.out.println("耗时：" + (end - start));
    }

    @Override
    public void select() {
        long start = System.currentTimeMillis();
        System.out.println("开始执行select方法");

        // 执行真正的业务代码
        target.select();

        long end = System.currentTimeMillis();
        System.out.println("结束执行select方法");
        System.out.println("耗时：" + (end - start));
    }
}


interface OrderDao{
    void add();
    void remove();
    void modify();
    void query();

}

// 如果还有这样的需求，给OrderDaoImpl的所有方法，增加求运行时间的功能，如果用静态代理类，还要再写一套
class OrderDaoImpl implements OrderDao{

    @Override
    public void add() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void modify() {

    }

    @Override
    public void query() {

    }
}