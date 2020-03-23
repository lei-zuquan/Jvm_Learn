package com.java.basic.c06_generic;

import java.util.*;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 8:34 下午 2020/3/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/**
 * day22_15泛型练习（3）
 *
 * 练习3
 *      把本组学员的姓名，和他的女（男）朋友们的姓名存在到一个HashMap中，并且用entrySet遍历显示
 */

public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("11");
        list1.add("22");
        map.put("1", list1);

        ArrayList<String> list2 = new ArrayList<>();
        map.put("2", list2);

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("33");
        map.put("3", list3);


        Set<Map.Entry<String, ArrayList<String>>> entrySet = map.entrySet();
        for (Map.Entry<String, ArrayList<String>> entry : entrySet) {
            String key = entry.getKey();
            System.out.println(key);

            ArrayList<String> value = entry.getValue();
            for (String string : value) {
                System.out.println("\t" + string);
            }
        }
    }
}
