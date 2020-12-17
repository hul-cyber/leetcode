package com.zjs.greedyalgorithm;

/**
 * @ClassName IsSubsequence1
 * @Description 329 判断子序列 题目链接：https://leetcode-cn.com/problems/is-subsequence/description/
 * 模拟法
 * @Author zhangjusheng
 * @Date 2020/12/5 9:10
 * @Version 1.0
 */
public class IsSubsequence1 {

    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (t.length() < s.length()) {
            return false;
        }
        int i = 0, j = 0;
        while (i < t.length()) {
            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }
            if (j == s.length()) {
                return true;
            }
            i++;
        }
        return false;
    }
}
