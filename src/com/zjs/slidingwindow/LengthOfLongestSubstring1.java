package com.zjs.slidingwindow;

/**
 * @ClassName LengthOfLongestSubstring1
 * @Description 3. 无重复字符的最长子串 题目链接: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 滑动窗口(使用字频数组来优化)
 * @Author hul-cyber
 * @Date 2021/1/27 11:09
 * @Version 1.0
 */
public class LengthOfLongestSubstring1 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2) {
            return len;
        }
        char[] charArray = s.toCharArray();
        int res = 1;
        int[] freq = new int[128];
        for (int left = 0, right = 0; right < len; right++) {
            freq[charArray[right]]++;
            while (freq[charArray[right]] == 2) {
                freq[charArray[left]]--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
