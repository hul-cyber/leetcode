package com.zjs.slidingwindow;

/**
 * @ClassName LengthOfLongestSubstring2
 * @Description 3. 无重复字符的最长子串 题目链接: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 滑动窗口(使用下标数组来优化)
 * @Author hul-cyber
 * @Date 2021/1/27 14:23
 * @Version 1.0
 */
public class LengthOfLongestSubstring2 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len < 2)
            return len;
        int res = 1;
        char[] charArray = s.toCharArray();
        int[] pos = new int[128];
        for (int i = 0; i < 128; i++)
            pos[i] = -1;
        for (int left = 0, right = 0; right < len; right++) {
            // 当新添加进来的元素之前出现在当前的窗口中
            while (pos[charArray[right]] >= left) {
                // left向右移动到之前的位置 + 1
                left = pos[charArray[right]] + 1;
            }
            pos[charArray[right]] = right;
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
