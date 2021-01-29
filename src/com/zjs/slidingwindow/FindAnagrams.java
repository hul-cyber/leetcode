package com.zjs.slidingwindow;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FindAnagrams
 * @Description 438. 找到字符串中所有字母异位词 题目链接: https://leetcode-cn.com/leetbook/read/learning-algorithms-with-leetcode/x1vsvd/
 * 滑动窗口
 * @Author hul-cyber
 * @Date 2021/1/29 10:38
 * @Version 1.0
 */
public class FindAnagrams {
    public List<Integer> findAnagrams (String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();
        int[] pattern = new int[128];
        int[] window = new int[128];
        for (int i = 0; i < pLen; i++) {
            pattern[pCharArray[i]]++;
        }
        int left = 0;
        int right = 0;
        List<Integer> res = new ArrayList<>();
        while (right < sLen) {
            window[sCharArray[right]]++;
            while (window[sCharArray[right]] > pattern[sCharArray[right]]) {
                window[sCharArray[left]]--;
                left++;
            }
            right++;
            if (right - left == pLen) {
                res.add(left);
            }
        }
        return res;
    }
}
