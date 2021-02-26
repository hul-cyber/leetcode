package com.zjs.stackandqueue;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName MaxSlidingWindow
 * @Description 239. 滑动窗口最大值 题目链接: https://leetcode-cn.com/problems/sliding-window-maximum/
 * 单调递减双向队列
 * @Author hul-cyber
 * @Date 2021/2/24 11:57
 * @Version 1.0
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[len - k + 1];
        for (int i = 0; i < len; i++) {
            // 当队首元素移出滑动窗口的时候，判断是不是应该将队列首部元素移除，当进来的元素下标大于
            // 等于k时，表示队首元素离队，判断离队元素是否与队首元素相同
            if (i >= k && i - k == deque.peekFirst()) {
                deque.pollFirst();
            }
            // 将比入队元素小的元素全部移出
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i >= (k - 1)) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
