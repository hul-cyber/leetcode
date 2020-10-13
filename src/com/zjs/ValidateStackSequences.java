package com.zjs;

import java.util.Stack;

/**
 * @ClassName ValidateStackSequences
 * @Description 剑指Offer 31 栈的压入、弹出序列 题目链接:https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * 使用一个栈来模拟 最坏情况下:时间复杂度O(N) 空间复杂度O(N)
 * @Author zhangjusheng
 * @Date 2020/10/13 17:29
 * @Version 1.0
 **/
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length)
            return false;

        boolean flag = true;
        int popIndex = 0;
        int pushIndex = 0;
        Stack<Integer> s = new Stack();

        while (popIndex < popped.length) {
            if (s.empty() || (s.peek() != popped[popIndex]))
                if (pushIndex < pushed.length)
                    s.push(pushed[pushIndex++]);
                else {
                    flag = false;
                    break;
                }
            else {
                s.pop();
                popIndex++;
            }
        }

        return flag;
    }
}
