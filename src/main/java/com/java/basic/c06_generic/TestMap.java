package com.java.basic.c06_generic;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 6:25 下午 2020/3/21
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * day22_15泛型练习（3）
 *
 * 练习3
 *      把本组学员的姓名，和他的女（男）朋友们的姓名存在到一个HashMap中，并且用entrySet遍历显示
 */
public class TestMap {
    public static void main(String[] args) {
        HashMap<String, String[]> map = new HashMap<>();

        map.put("1", new String[]{"11", "22"});
        map.put("2", null);
        map.put("3", new String[]{"33"});

        // Set中的元素是Map.Entry类型
        // Entry的key是String, value是String[]
        Set<Map.Entry<String, String[]>> entrySet = map.entrySet();
        for (Map.Entry<String, String[]> entry : entrySet) {
            String key = entry.getKey();
            System.out.println(key + ",他的对象们：");
            String[] value = entry.getValue();
            if (value != null){
                for (String name : value) {
                    System.out.println("\t" + name);
                }
            } else {
                System.out.println("\t" + "没有");
            }
        }
    }
}
