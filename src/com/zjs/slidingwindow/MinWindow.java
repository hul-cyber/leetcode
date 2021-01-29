package com.zjs.slidingwindow;

/**
 * @ClassName MinWindow
 * @Description 76. 最小覆盖子串 题目链接: https://leetcode-cn.com/leetbook/read/learning-algorithms-with-leetcode/x1vsvd/
 * 滑动窗口
 * @Author hul-cyber
 * @Date 2021/1/29 17:12
 * @Version 1.0
 */
public class MinWindow {
    public String minWindow(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        if (sLen < tLen || tLen == 0) {
            return "";
        }
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        int[] window = new int[128];
        int[] pattern = new int[128];
        for (int i = 0; i < tLen; i++) {
            pattern[tCharArray[i]]++;
        }
        int distance = 0;
        for (int i = 0; i < 128; i++) {
            if (pattern[i] > 0)
                distance++;
        }
        int start = 0;
        int left = 0;
        int right = 0;
        int minLen = sLen + 1;
        int match = 0;
        while (right < sLen) {
            if (pattern[sCharArray[right]] > 0) {
                window[sCharArray[right]]++;
                if (pattern[sCharArray[right]] == window[sCharArray[right]])
                    match++;
            }
            right++;
            while (match == distance) {
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }
                if (pattern[sCharArray[left]] > 0) {
                    if (pattern[sCharArray[left]] == window[sCharArray[left]])
                        match--;
                    window[sCharArray[left]]--;
                }
                left++;
            }
        }
        return minLen == sLen + 1 ? "" : s.substring(start, start + minLen);
    }
}
