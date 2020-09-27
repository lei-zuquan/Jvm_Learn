package com.test.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author:
 * @Date: Created in 4:46 下午 2020/9/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

// 给定两个数组，编写一个函数来计算它们的交集。
//
// 
//
//示例 1：
//
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
//示例 2:
//
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9]
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class C350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        List<Integer> poolData = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (length1 > length2) {
            for (int i = 0; i < nums1.length; i++) {
                poolData.add(nums1[i]);
            }
            for (int i = 0; i < nums2.length; i++) {
                if (poolData.contains(nums2[i])) {
                    list.add(nums2[i]);
                    poolData.remove(new Integer(nums2[i]));
                }
            }
        } else {
            for (int i = 0; i < nums2.length; i++) {
                poolData.add(nums2[i]);
            }
            for (int i = 0; i < nums1.length; i++) {
                if (poolData.contains(nums1[i])) {
                    list.add(nums1[i]);
                    poolData.remove(new Integer(nums1[i]));
                }
            }
        }

        int[] resArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            resArr[i] = list.get(i);
        }

        return resArr;
    }

    public static void main(String[] args) {
        C350 c350 = new C350();

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] intersect = c350.intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersect));

        int[] nums11 = {4,9,5};
        int[] nums22 = {9,4,9,8,4};
        int[] intersect1 = c350.intersect(nums11, nums22);
        System.out.println(Arrays.toString(intersect1));

        int[] nums33 = {3,2,1};
        int[] nums44 = {1,1};
        int[] intersect33 = c350.intersect(nums33, nums44);
        System.out.println(Arrays.toString(intersect33));
    }
}
