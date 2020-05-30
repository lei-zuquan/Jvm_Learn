package com.java.z_exam.algorithm.c02_sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: Created in 9:35 下午 2020/5/18
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T_0009_CountSortTest {

    int[] generateRandomArray() {
        Random r = new Random();

        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(10);
        }

        return arr;
    }

    @Test
    public void testSort(){
        int[] a = generateRandomArray();
        int[] result = T_0009_CountSort.countSort(a);
        Arrays.sort(a);
        boolean same = true;

        for (int i = 0; i < a.length; i++) {
            if (result[i] != a[i]) same = false;
        }

        assertEquals(true, same);
    }
}
