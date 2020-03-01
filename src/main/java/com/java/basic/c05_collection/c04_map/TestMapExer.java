package com.java.basic.c05_collection.c04_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 把如下信息添加到Map中，并遍历显示
 *
 * 浙江省
 *      绍兴市
 *      温州市
 *      湖州市
 *      嘉兴市
 *      台州市
 *      舟山市
 *      丽水市
 * 海南省
 *      海口市
 *      三亚市
 * 北京市
 *      北京市
 */
public class TestMapExer {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        // key：省份名称
        // value：该省所有城市
        ArrayList bj = new ArrayList();
        bj.add("北京市");

        ArrayList hn = new ArrayList();
        hn.add("海口市");
        hn.add("三亚市");

        ArrayList zj = new ArrayList();
        zj.add("绍兴市");
        zj.add("温州市");
        zj.add("湖州市");
        zj.add("嘉兴市");
        zj.add("台州市");
        zj.add("舟山市");
        zj.add("丽水市");

        map.put("北京市", bj);
        map.put("海南省", hn);
        map.put("浙江省", zj);


        for (Object entry : map.entrySet()) {
            System.out.println(entry);
        }

        for (Object object : map.entrySet()) {
            Map.Entry entry = (Map.Entry)object;
            Object key = entry.getKey();
            System.out.println(key); // 省份
            ArrayList value = (ArrayList) entry.getValue();
            for (Object city : value) {
                System.out.println("\t" + city);
            }
        }
    }
}
