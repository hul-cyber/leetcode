package com.zjs.twopoints;

import java.util.List;

/**
 * @ClassName FindLongestWord
 * @Description 524 通过删除字母匹配到字典里最长单词 题目链接: https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 * 双指针
 * @Author zhangjusheng
 * @Date 2020/11/25 21:03
 * @Version 1.0
 */
public class FindLongestWord {
    public String findLongestWord(String s, List<String> d) {
        // 获取长度最长的字符串
        String longestString = "";
        for (String ss : d) {
            if (ss.length() < longestString.length() || (ss.length() == longestString.length() && ss.compareTo(longestString) >= 0)) {
                continue;
            }
            if (match(s, ss))
                longestString = ss;
        }
        return longestString;
    }
    // 匹配字符串
    public boolean match(String s, String target) {
        int m = 0, n = 0;
        while (m < s.length() && n < target.length()) {
            if (s.charAt(m) == target.charAt(n)) {
                n++;
            }
            m++;
        }
        return n == target.length();
    }
}