package com.zjs.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName NextGreaterElements1
 * @Description 503. 下一个更大的元素II 题目链接: https://leetcode-cn.com/problems/next-greater-element-ii/
 * 单调栈(倒着遍历元素)
 * @Author hul-cyber
 * @Date 2021/2/22 15:47
 * @Version 1.0
 */
public class NextGreaterElements1 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[len];
        for (int i = (2 * len - 1); i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peekLast()] <= nums[i % len]) {
                stack.removeLast();
            }
            res[i % len] = stack.isEmpty() ? -1 : nums[stack.peekLast()];
            stack.add(i % len);
        }
        return res;
    }
}
