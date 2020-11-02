package com.zjs;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LengthOfLongestSubstring2
 * @Description 剑指Offer 48 最长不含重复字符串的子字符串 题目链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 * 动态规划 + 哈希表
 * @Author zhangjusheng
 * @Date 2020/10/29 15:48
 * @Version 1.0
 **/
public class LengthOfLongestSubstring2 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Integer tmp = 0;
        Integer resLength = 0;

        for (int j = 0; j < s.length(); j++) {
            int i = map.getOrDefault(s.charAt(j), -1);
            map.put(s.charAt(j), j);
            tmp = tmp + 1 > j - i ? j - i : tmp + 1;
            if (resLength < tmp)
                resLength = tmp;
        }

        return resLength;
    }

}
