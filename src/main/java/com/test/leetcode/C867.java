package com.test.leetcode;

/**
 * @Author:
 * @Date: Created in 3:13 下午 2020/9/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 给定一个矩阵 A， 返回 A 的转置矩阵。
//
//矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。

/*
示例 1：

输入：[[1,2,3],
      [4,5,6],
      [7,8,9]]
输出：[[1,4,7],
      [2,5,8],
      [3,6,9]]
示例 2：

输入：[[1,2,3],
      [4,5,6]]
输出：[[1,4],
      [2,5],
      [3,6]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/transpose-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class C867 {
    public int[][] transpose(int[][] A) {
        int bigArrLength = A.length;
        int smallArrLength = A[0].length;

        int[][] ints = new int[smallArrLength][bigArrLength];
        for (int i = 0; i < bigArrLength; i++) {
            for (int j = 0; j < smallArrLength; j++) {
                ints[j][i] = A[i][j];
            }
        }

        return ints;
    }

    public static void main(String[] args) {
        int[][] ints = {{1,2,3},{4,5,6},{7,8,9}};
        C867 c867 = new C867();
        int[][] transpose = c867.transpose(ints);

        println(transpose);

        System.out.println("------------------");
        int[][] t2 = {{1,2,3},{4,5,6}};
        c867 = new C867();
        int[][] r2 = c867.transpose(t2);

        println(r2);
    }

    public static void println(int[][] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int i1 = 0; i1 < ints[i].length; i1++) {
                System.out.print(ints[i][i1] + "\t");
            }
            System.out.println("============");
        }
    }

}
