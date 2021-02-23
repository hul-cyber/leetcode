package com.zjs.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName NextGreaterElement
 * @Description 496. 下一个更大的元素I 题目链接: https://leetcode-cn.com/problems/next-greater-element-i/
 * 单调栈
 * @Author hul-cyber
 * @Date 2021/2/22 15:46
 * @Version 1.0
 */
public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0 || len2 == 0) {
            return new int[0];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len2; i++) {
            while (!stack.isEmpty() && stack.peekLast() < nums2[i]) {
                map.put(stack.removeLast(), nums2[i]);
            }
            stack.addLast(nums2[i]);
        }
        int[] result = new int[len1];
        for (int i = 0; i < len1; i++) {
            result[i] = map.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}
