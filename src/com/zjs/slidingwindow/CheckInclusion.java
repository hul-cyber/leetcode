package com.zjs.slidingwindow;

/**
 * @ClassName CheckInclusion
 * @Description 567. 字符串的排列 题目链接: https://leetcode-cn.com/problems/permutation-in-string/
 *
 * @Author hul-cyber
 * @Date 2021/1/29 15:35
 * @Version 1.0
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        char[] s1CharArray = s1.toCharArray();
        char[] s2CharArray = s2.toCharArray();
        int[] needs = new int[128];
        int[] window = new int[128];
        for (int i = 0; i < s1CharArray.length; i++) {
            needs[s1CharArray[i]]++;
        }
        int left = 0;
        int right = 0;
        while (right < s2CharArray.length) {
            char curR = s2CharArray[right];
            window[curR]++;
            right++;
            while (window[curR] > needs[curR]) {
                char curL = s2CharArray[left];
                window[curL]--;
                left++;
            }
            if (right - left == s1CharArray.length)
                return true;
        }
        return false;
    }
}
