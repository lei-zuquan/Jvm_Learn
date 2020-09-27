package com.test.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * @Author:
 * @Date: Created in 3:31 下午 2020/9/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
public class C1576 {

    private char[] charArr = new char[26];

    public C1576() {
        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = (char)('a' + i);
        }
    }

    public char getCanUseChar(char prevChar, char afterChar) {
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] != prevChar && charArr[i] != afterChar) {
                return charArr[i];
            }
        }

        return 'a';
    }

    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        char prev = '?';
        char after = '?';
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char currChar = chars[i];

            if (currChar == '?') {
                // 如果是遇到'？'
                if (i < length -1) {
                    after = chars[i+1];
                }

                char canUseChar = getCanUseChar(prev, after);
                chars[i] = canUseChar;
            }

            // 如果是没有遇到'?'
            prev = chars[i];
        }

        String res = new String(chars);
        System.out.println("old: " + s + "\t\t\t" + res);
        return res;
    }

    public static void main(String[] args) {
        C1576 c1576 = new C1576();
        c1576.modifyString("?zs");
        c1576.modifyString("ubv?w");
        c1576.modifyString("j?qg??b");
        c1576.modifyString("??yw?ipkj?");
    }
}
