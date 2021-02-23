package com.zjs.stackandqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @ClassName NextGreaterElements2
 * @Description 503. 下一个更大的元素II 题目链接: https://leetcode-cn.com/problems/next-greater-element-ii/
 * 单调栈(正着遍历元素)
 * @Author hul-cyber
 * @Date 2021/2/22 15:49
 * @Version 1.0
 */
public class NextGreaterElements2 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[len];
        Arrays.fill(res, -1);
        for (int i = 0; i < (2 * len - 1); i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i % len]) {
                res[stack.removeLast()] = nums[i % len];
            }
            stack.add(i % len);
        }
        return res;
    }
}
