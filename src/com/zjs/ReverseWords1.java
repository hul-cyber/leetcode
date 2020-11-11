package com.zjs;

import java.util.Stack;

/**
 * @ClassName ReverseWords1
 * @Description 剑指Offer 58 - I 翻转单词顺序 题目链接：https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
 * 后进先出, 栈
 * @Author zhangjusheng
 * @Date 2020/11/11 12:46
 * @Version 1.0
 **/
public class ReverseWords1 {
    public String reverseWords(String s) {
        Stack<StringBuilder> stack = new Stack<>();

        int index = 0;
        StringBuilder strBuilder = new StringBuilder();
        while (index < s.length()) {
            if (s.charAt(index) == ' ') {
                if (strBuilder.length() != 0) {
                    stack.push(strBuilder);
                    strBuilder = new StringBuilder();
                }
            } else {
                strBuilder.append(s.charAt(index));
            }
            index++;
            if (index == s.length())
                if (strBuilder.length() != 0)
                    stack.push(strBuilder);
        }

        StringBuilder res = new StringBuilder();
        while (!stack.empty()) {
            res.append(stack.pop());
            res.append(' ');
        }

        if (res.length() == 0)
            return "";
        return res.substring(0, res.length() - 1).toString();
    }
}
