package com.zjs.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName IsValid
 * @Description 20. 有效的括号 题目链接: https://leetcode-cn.com/problems/valid-parentheses/
 * 栈
 * @Author hul-cyber
 * @Date 2021/2/20 15:18
 * @Version 1.0
 */
public class IsValid {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        Deque<Character> stack = new ArrayDeque<>();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (!stack.isEmpty() && isMatch(stack.peekLast(), c)) {
                stack.removeLast();
            } else {
                stack.addLast(c);
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isMatch(char a, char b) {
        if ((a == '{' && b == '}') || (a == '[' && b == ']') || (a == '(' && b == ')')) {
            return true;
        } else {
            return false;
        }
    }
}
