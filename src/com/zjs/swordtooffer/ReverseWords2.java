package com.zjs.swordtooffer;

/**
 * @ClassName ReverseWords2
 * @Description 剑指Offer 58 - I 翻转单词顺序 题目链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * 双指针
 * @Author zhangjusheng
 * @Date 2020/11/11 12:48
 * @Version 1.0
 **/
public class ReverseWords2 {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder res = new StringBuilder();

        int i = s.length() - 1, j = i;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ')
                i--;
            res.append(s.substring(i + 1, j + 1) + ' ');
            while (i >= 0 && s.charAt(i) == ' ')
                i--;
            j = i;
        }

        return res.toString().trim();
    }
}
