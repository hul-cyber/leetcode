package com.zjs.slidingwindow;

/**
 * @ClassName CharacterReplacement
 * @Description 424. 替换后的最长重复字符 题目链接: https://leetcode-cn.com/problems/longest-repeating-character-replacement/
 * 滑动窗口
 * @Author hul-cyber
 * @Date 2021/1/29 17:08
 * @Version 1.0
 */
public class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (len == 0)
            return 0;
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = 0;
        int[] window = new int[26];
        int maxRepeat = 0;
        while (right < len) {
            int curR = charArray[right] - 'A';
            window[curR]++;
            right++;
            maxRepeat = Math.max(window[curR], maxRepeat);
            if (right - left > maxRepeat + k) {
                // 如果此时长度超过了maxRepeat + k,就左移
                int curL = charArray[left] - 'A';
                window[curL]--;
                left++;
            }
        }
        return maxRepeat + k > len ? len : maxRepeat + k;
    }
}
