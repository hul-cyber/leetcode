package com.zjs.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName RemoveDuplicateLetters
 * @Description 316. 去除重复字母 题目链接: https://leetcode-cn.com/problems/remove-duplicate-letters/
 * 栈
 * @Author hul-cyber
 * @Date 2021/2/20 21:23
 * @Version 1.0
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if (s.length() == 0) {
            return "";
        }
        char[] chars = s.toCharArray();
        int[] lastIndex = new int[26];
        int[] ifExist = new int[26];
        for (int i = 0; i < chars.length; i++) {
            lastIndex[chars[i] - 'a'] = i;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];
            if (ifExist[currentChar - 'a'] == 1) {
                continue;
            }
            char topElement;
            while (!stack.isEmpty() && lastIndex[(topElement = stack.peekLast()) - 'a'] > i && currentChar < topElement) {
                stack.removeLast();
                ifExist[topElement - 'a'] = 0;
            }
            stack.addLast(currentChar);
            ifExist[currentChar - 'a'] = 1;
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0,stack.removeLast());
        }
        return result.toString();
    }
}
