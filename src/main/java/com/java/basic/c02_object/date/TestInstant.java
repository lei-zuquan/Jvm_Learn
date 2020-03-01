package com.java.basic.c02_object.date;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Instant: 默认的是本初子线的绝对时间
 */
public class TestInstant {
    @Test
    public void test(){
        Instant i = Instant.now();
        System.out.println(i);

        LocalDateTime z = LocalDateTime.now();
        System.out.println(z);

        OffsetDateTime atOffset = i.atOffset(ZoneOffset.ofHours(8));
        System.out.println(atOffset);

        OffsetDateTime atOffset2 = i.atOffset(ZoneOffset.ofHours(-8));
        System.out.println(atOffset2);
    }
}
