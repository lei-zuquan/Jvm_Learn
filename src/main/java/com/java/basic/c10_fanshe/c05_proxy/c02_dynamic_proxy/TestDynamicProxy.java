package com.java.basic.c10_fanshe.c05_proxy.c02_dynamic_proxy;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 11:09 下午 2020/3/29
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * day27_16动态代理
 *
 * 动态代理：
 *
 * 代理模式：
 *      1、主题接口
 *      2、被代理类
 *      3、代理类 (变化)
 * 代理类分为两个部分：
 * 1、
 * 不直接写代理类，而是写一个"代理工作处理器"的类
 * 代理工作处理器：这个代理类要替被代理者完成xx事
 * 这个代理工作处理器必须实现一个接口：java.lang.reflect.InvocationHandler
 *
 * 2、动态的生成代理类及其它的对象
 * 这个时候就需要借助java.lang.reflect.Proxy
 *      Proxy 提供用于创建动态代理类和实例的静态方法
 *          public static Object newProxyInstance(ClassLoader loader,
 *                                           Class<?>[] interfaces,
 *                                           InvocationHandler h)
 *          第一个参数：传入被代理者的类加载器
 *          第二个参数：传入被代理者实现的接口们
 *          第三个参数：传入代理者要替被代理者完成的工作的处理器对象
 *
 * 不同的类加载器加载的Class，JVM认为是不同的类型。
 */
public class TestDynamicProxy {
    public static void main(String[] args) {
        // (1)创建被代理者的对象
        UserDaoImpl u = new UserDaoImpl();
        // (2)获取被代理者的类加载器对象
        ClassLoader loader = u.getClass().getClassLoader();
        // (3)获取被代理者实现的接口们
        Class<?>[] interfaces = u.getClass().getInterfaces();
        // (4)创建代理者要替被代理者完成的工作的处理器对象
        Handler h = new Handler(u); // 传入被代理者

        // 动态的创建代理类和它的对象
        // 得到的就是代理类的对象，代理类在内存中自动生成
        UserDao ud = (UserDao)Proxy.newProxyInstance(loader, interfaces, h);
        ud.insert();
        ud.delete();
        ud.update();

        System.out.println("--------------------------------------");

        /**
         * 同时也可以给OrderDaoImpl代理
         */
        OrderDaoImpl od = new OrderDaoImpl();
        ClassLoader loader2 = od.getClass().getClassLoader();
        Class<?>[] interfaces2 = od.getClass().getInterfaces();
        Handler h2 = new Handler(od);
        OrderDao dao = (OrderDao) Proxy.newProxyInstance(loader2, interfaces2, h2);
        dao.add();
        dao.remove();
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
class UserDaoImpl implements UserDao{

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



interface OrderDao{
    void add();
    void remove();
    void modify();
    void query();

}

// 如果还有这样的需求，给OrderDaoImpl的所有方法，增加求运行时间的功能，如果用静态代理类，还要再写一套
class OrderDaoImpl implements OrderDao {

    @Override
    public void add() {
        System.out.println("订单的创建");
    }

    @Override
    public void remove() {
        System.out.println("订单的删除");
    }

    @Override
    public void modify() {
        System.out.println("订单的修改");
    }

    @Override
    public void query() {
        System.out.println("订单的查询");
    }
}

// 3、代理工作处理器
class Handler implements InvocationHandler{
    private Object target;

    public Handler(Object target) {
        this.target = target;
    }

    /**
     * 这个方法：
     * （1）它不是由程序员手动调用的，这个方法的代码会被编译器自动生成到代理类的对应方法中，当你调用代理类的方法时，自动执行这个方法的代码
     * （2）参数列表
     * 第一个参数：proxy  代理类对象
     * 第二个参数：method  代理类要执行的真正的方法，例如：insert,update,...
     * 第三个参数：给method方法的实参列表，如果有的话
     * 返回值：method方法的返回值，就是invoke的返回值 或者说invoke方法的返回值将来就是作为method方法的返回值
     *
     * （3）编写代理类要替被代理者完成的工作
     *
     * 例如：给所有方法都增加一个功能，统计该方法的运行时间
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("开始执行" + method.getName() + "方法");
        System.out.println("代理类型：" + proxy.getClass().getName());

        // 执行真正的业务代码
        Object returnValue = method.invoke(target, args);

        long end = System.currentTimeMillis();
        System.out.println("结束执行" + method.getName() + "方法");
        System.out.println("耗时：" + (end - start));

        return returnValue;
    }
}