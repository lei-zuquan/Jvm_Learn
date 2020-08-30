package com.java.z_exam.design_patterns.c00_priciple.c03_inversion;

/**
 * @Author:
 * @Date: Created in 2:48 下午 2020/8/30
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class DependecyInversion {
    public static void main(String[] args) {
        Person person = new Person();
        person.receive(new Email());
    }
}

class Email {
    public String getInfo() {
        return "电子邮件信息：hello, word";
    }
}

// 完成Person 接收消息的功能
// 方式1 分析
// 1. 简单，比较容易想到
// 2. 如果我们获取的对象是微信，短信等等，则新增类，同时Person 也要增加相应的接收方法
// 3. 解决思路：引入一个抽象的接口IReceiver，表示接收者，这样Person 类与接口IReceiver 发生依赖（使用）
//    因为Email，WeiXin 等等属于接收的范围，他们各自实现IReceiver 接口就ok，这样我们就符合依赖倒转原则
class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}

























