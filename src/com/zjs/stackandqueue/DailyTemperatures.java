package com.zjs.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName DailyTemperatures
 * @Description 739. 每日温度 题目链接: https://leetcode-cn.com/problems/daily-temperatures/
 * 单调栈
 * @Author hul-cyber
 * @Date 2021/2/22 13:20
 * @Version 1.0
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        if (len == 0) {
            return new int[0];
        }
        int[] result = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && T[stack.peekLast()] < T[i]) {
                int topIndex = stack.removeLast();
                result[topIndex] = i - topIndex;
            }
            stack.addLast(i);
        }
        return result;
    }
}
