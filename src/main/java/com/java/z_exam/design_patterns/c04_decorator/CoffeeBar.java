package com.java.z_exam.design_patterns.c04_decorator;

/**
 * @Author:
 * @Date: Created in 10:44 上午 2020/9/2
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class CoffeeBar {
    public static void main(String[] args) {
        // 装饰者模式下的订单：2份巧克力 + 一份牛奶的LongBlack

        // 1. 点一份 LongBlack
        AbstractDrink order = new LongBlack();
        System.out.println("费用1=" + order.getPrice());
        System.out.println("描述=" + order.getDes());

        // 2. order 加入一份牛奶
        order = new Milk(order);
        System.out.println("order 加入一份牛奶 费用 = " + order.cost());
        System.out.println("order 加入一份牛奶 描述 = " + order.getDes());

        // 3. order 加入一份巧克力
        order = new Chocolate(order);
        System.out.println("order 加入一份巧克力 费用 = " + order.cost());
        System.out.println("order 加入一份巧克力 描述 = " + order.getDes());

        // 4. order 加入2份巧克力
        order = new Chocolate(order);
        System.out.println("order 加入2份巧克力 费用 = " + order.cost());
        System.out.println("order 加入2份巧克力 描述 = " + order.getDes());

        System.out.println("======================================");

        AbstractDrink order2 = new Decaf();
        System.out.println("order2 无因咖啡 费用 = " + order2.cost());
        System.out.println("order2 无因咖啡 描述 = " + order2.getDes());

        order2 = new Milk(order2);
        System.out.println("order2 无因咖啡 加入一份牛奶 费用 = " + order2.cost());
        System.out.println("order2 无因咖啡 加入一份牛奶 描述 = " + order2.getDes());

    }
}
