package com.zjs.twopoints;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @ClassName ReverseVowels2
 * @Description 345 反转字符串中的元音字母 题目链接: https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * 双指针 + 哈希表
 * @Author zhangjusheng
 * @Date 2020/11/25 8:37
 * @Version 1.0
 */
public class ReverseVowels2 {

    private final static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        if (s == null) return null;
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i <= j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)) {
                result[i++] = ci;
            } else if (!vowels.contains(cj)) {
                result[j--] = cj;
            } else {
                result[i++] = cj;
                result[j--] = ci;
            }
        }
        return new String(result);
    }
}
