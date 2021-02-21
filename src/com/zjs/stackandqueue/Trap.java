package com.zjs.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName Trap
 * @Description 42. 接雨水 题目链接: https://leetcode-cn.com/problems/trapping-rain-water/
 * 单调栈
 * @Author hul-cyber
 * @Date 2021/2/21 11:26
 * @Version 1.0
 */
public class Trap {
    public int trap(int[] height) {
        int length = height.length;
        if (length < 3) {
            return 0;
        }
        int capacity = 0;
        Deque<Integer> stack = new ArrayDeque<>(length);
        for (int i = 0; i < length; i++) {
            // 有可能形成凹槽
            while (!stack.isEmpty() && height[stack.peekLast()] < height[i]) {
                int bottomIndex = stack.removeLast();
                if (stack.isEmpty()) {
                    break;
                }
                int curHeight = Math.min(height[i], height[stack.peekLast()]) - height[bottomIndex];
                int width = i - stack.peekLast() - 1;
                capacity += (curHeight * width);
            }
            stack.addLast(i);
        }
        return capacity;
    }
}
