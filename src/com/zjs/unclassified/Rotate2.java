package com.zjs.unclassified;

/**
 * @ClassName Rotate2
 * @Description 189. 旋转数组 题目链接: https://leetcode-cn.com/problems/rotate-array/
 * 环形替换
 * @Author zhangjusheng
 * @Date 2021/1/5 22:51
 * @Version 1.0
 */
public class Rotate2 {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        int count = 0;
        for (int start = 0; count < length; start++) {
            int i = start, previous = nums[i], next = 0, temp = 0;
            do {
                next = (i + k) % length;
                temp = nums[next];
                nums[next] = previous;
                previous = temp;
                i = next;
                count++;
            } while (i != start);
        }
    }
}
