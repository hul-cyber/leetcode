package com.zjs.unclassified;

/**
 * @ClassName Rotate1
 * @Description 189. 旋转数组 题目链接: https://leetcode-cn.com/problems/rotate-array/
 * 三次反转
 * @Author zhangjusheng
 * @Date 2021/1/5 22:50
 * @Version 1.0
 */
public class Rotate1 {
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
        reverse(nums, 0, length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
