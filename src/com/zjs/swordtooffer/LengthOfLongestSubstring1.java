package com.zjs.swordtooffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LengthOfLongestSubstring1
 * @Description 剑指Offer 48 最长不含重复字符的子字符串 题目链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
 * 暴力法求解
 * @Author zhangjusheng
 * @Date 2020/10/29 14:40
 * @Version 1.0
 **/
public class LengthOfLongestSubstring1 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;


        int resLength = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (!set.add(s.charAt(j))) {
                    set.clear();
                    break;
                } else {
                    if (resLength < set.size())
                        resLength = set.size();
                }
            }
        }

        return resLength;
    }
}
