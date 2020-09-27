package com.test.leetcode;

/**
 * @Author:
 * @Date: Created in 4:04 下午 2020/9/27
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
// 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
public class C459 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        C459 c459 = new C459();
        System.out.println(c459.repeatedSubstringPattern("abab"));
        System.out.println(c459.repeatedSubstringPattern("aba"));
        System.out.println(c459.repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(c459.repeatedSubstringPattern("abababab"));
        System.out.println(c459.repeatedSubstringPattern("ababab"));
        System.out.println(c459.repeatedSubstringPattern("ababba"));
    }
}
