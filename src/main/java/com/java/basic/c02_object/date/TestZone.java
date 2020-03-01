package com.java.basic.c02_object.date;

import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * ZonedDateTime: 某个时区的时期时间
 * ZoneId：用来包装时区的
 */
public class TestZone {
    @Test
    public void test2(){
        ZonedDateTime z = ZonedDateTime.now(ZoneId.of("Japan"));
        System.out.println(z);
    }
    @Test
    public void test(){
        // 集合Set， 是一个容器，装对象
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        // 遍历集合
        for (String string : availableZoneIds ) {
            System.out.println(string);
        }
    }
}
