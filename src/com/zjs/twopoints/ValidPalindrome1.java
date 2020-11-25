package com.zjs.twopoints;

/**
 * @ClassName ValidPalindrome1
 * @Description 680 验证回文字符串 ii 题目链接:https://leetcode-cn.com/problems/valid-palindrome-ii/
 * 双指针
 * @Author zhangjusheng
 * @Date 2020/11/25 9:35
 * @Version 1.0
 */
public class ValidPalindrome1 {
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return recur(i, j - 1, s) || recur(i + 1, j, s);
            }
        }
        return true;
    }

    public boolean recur(int left, int right, String s) {
        for (int i = left, j = right; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }
}
