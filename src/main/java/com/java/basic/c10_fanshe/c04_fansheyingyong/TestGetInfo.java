package com.java.basic.c10_fanshe.c04_fansheyingyong;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 7:18 上午 2020/3/29
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * day27_08使用Class获取类型详细信息
 *
 * 反射在开发的应用有如下几个方面：
 *      1、在运行期间，动态的获取某个类的详细信息
 *      2、在运行期间，动态的创建任意类型的对象
 *      3、在运行期间，动态的为对象的属性赋值
 *      4、在运行期间，动态的调用任意对象的任意方法
 *      ...
 *
 * 一、在运行期间，动态的获取某个类的详细信息
 * 步骤：
 *      1、获取某个类型的Class对象
 *      2、使用Class和java.lang.reflect包下面的其他类型的API
 *
 *      Class类的API：
 *           (1) Package getPackage()
 *           (2) int getModifiers()
 *           (3) getName()
 *           (4) getSuperclass()
 *           (5) getInterfaces()
 *           (6) Field[] getFields() : 此方法返回该类及其所有超类的公共字段。
 *               Field getField(String name) ：所表示的类或接口的"指定"公共成员字段
 *               Field[] getDeclaredFields() ：反映此Class 对象所表示的类或接口所声明的所有字段。包括公共、保护、默认（包）访问和私有字段，但不包括继承的字段。
 *               Field getDeclaredField(String name) ：返回指定的...
 *          （7）Constructor<?> getConstructors()
 *              Constructor<T> getConstructor(Class<?>... parameterTypes)
 *              Constructor<?>[] getDeclaredConstructors()
 *              Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
 *           (8) Method[] getMethods()
 *               Method getMethod(String name, Class<?>... parameterTypes)
 *               Method[] getDeclaredMethods()
 *               Method getDeclaredMethod(String name, Class<?>... parameterTypes)
 *
 *
 *      java.lang.reflect包：
 *          （1）Package类型
 *              getName()
 *          （2）Modifier类型
 *          （3）Field类型
 *                  Field代表属性，每个Field的对象代表某个一个类中的某一个属性。
 *                  所有的属性有共同特点：
 *                      【修饰符】数据类型 属性名；
 *                      get / set 值；
 *                  类的定义：一类具有相同特性的事物的抽象描述。
 *              A: getModifiers()
 *              B: getName()
 *              C: getType()
 *              D: get/set值
 *
 *           （4）Constructor类型
 *                  所有的构造器的共同特征：
 *                      【修饰符】 构造器名（形参列表）{}
 *                      创建对象
 *
 *           （5）Method类型
 *                  所有的方法们的共同特征：
 *                      【修饰符】 返回值类型 方法名（【形参列表】）throws 异常列表{}
 *                      被调用invoke
 *
 *
  *
  */
 public class TestGetInfo {

    @Test
    public void test1() throws Exception{
        // 1、获取某个类型的Class对象
        Class<?> clazz = Class.forName("com.lei.java.Student");
        // 2、获取包信息
        Package pk = clazz.getPackage();
        System.out.println(pk.getName());

        // 3、获取类的修饰符
        int mod = clazz.getModifiers();
        System.out.println(mod);
        System.out.println(Modifier.toString(mod));

        // 4、获取类名
        System.out.println(clazz.getName());

        // 5、获取父类
        Class<?> parent = clazz.getSuperclass();
        System.out.println("父类："+ parent.getName());

        // 6、获取父接口
        System.out.println("父接口们：");
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> inter : interfaces) {
            System.out.println(inter);
        }

        // 7、获取属性们
        Field[] allFields = clazz.getDeclaredFields();
        System.out.println("所有的属性们：");
        for (Field field : allFields) {
            System.out.print("属性的修饰符：");
            int fmod = field.getModifiers();
            System.out.println(Modifier.toString(fmod));

            System.out.print("属性的数据类型：");
            Class<?> ftype = field.getType();
            System.out.println(ftype.getName());

            System.out.println("属性名：" + field.getName());
        }

        // 8、获取构造器们
        Constructor<?>[] allCons = clazz.getDeclaredConstructors();
        System.out.println("所有的构造器们：");
        for (Constructor<?> constructor :allCons){
            System.out.println("构造器的修饰符：");
            int cmod = constructor.getModifiers();
            System.out.println(Modifier.toString(cmod));

            System.out.println("构造器名：" + constructor.getName());

            System.out.println("构造器的形参列表：");
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> param : parameterTypes) {
                System.out.println(param.getName());
            }
        }

        // 9、获取所有的方法们
        Method[] allMethods = clazz.getDeclaredMethods();
        System.out.println("所有的构造器们：");
        for (Method method :allMethods){
            System.out.println("方法的修饰符：");
            int cmod = method.getModifiers();
            System.out.println(Modifier.toString(cmod));

            System.out.println("返回值类型：");
            Class<?> returnType = method.getReturnType();
            System.out.println(returnType.getName());

            System.out.println("方法名：" + method.getName());

            System.out.println("方法的形参列表：");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> param : parameterTypes) {
                System.out.println(param.getName());
            }
        }
    }
}
