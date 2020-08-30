package com.java.z_exam.design_patterns.c00_priciple.c03_inversion.improve;

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
        person.receive(new WeiXin());
    }
}

// 定义接口
interface IReceiver {
    public String getInfo();
}

class Email implements IReceiver {
    public String getInfo() {
        return "电子邮件信息：hello, word";
    }
}

// 增加微信
class WeiXin implements IReceiver {
    public String getInfo() {
        return "微信信息：hello, ok";
    }
}

// 方式二
class Person {
    // 这里我们是对接口的依赖
    public void receive(IReceiver receiver) {
        System.out.println(receiver.getInfo());
    }
}

























