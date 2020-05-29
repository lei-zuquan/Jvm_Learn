package com.java.z_exam.algorithm.sort.sort_with_design;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-05-29 9:03
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T00_DataChecker {

    static Integer[] generateRandomArray() {
        Random r = new Random();
        Integer[] arr = new Integer[20];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(20);
        }

        return arr;
    }

    static void check() {
        boolean same = true;

        for (int times = 0; times < 10; times++) {
            Integer[] arr = generateRandomArray();
            Integer[] arr2 = new Integer[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);

            Arrays.sort(arr);
            //T03_Insertion.sort(arr2);
            //T04_Shell.sort(arr2);
            T05_Merge.sort(arr2);

            for (int i = 0; i < arr2.length; i++) {
                if (arr[i].compareTo(arr2[i]) != 0) {
                    same = false;
                    break;
                }
            }

            if (!same) break;
        }


        System.out.println(same == true ? "right" : "wrong");
    }

    public static void main(String[] args) {
        check();
    }
}
