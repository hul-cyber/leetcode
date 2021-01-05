package com.zjs.divideandconquer;

/**
 * @ClassName FindMin1
 * @Description 153 寻找旋转排序数组中的最小值 题目链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 分治法
 * @Author zhangjusheng
 * @Date 2021/1/5 23:08
 * @Version 1.0
 */
public class FindMin1 {
    public int findMin(int[] nums) {
        return recur(nums, 0, nums.length - 1);
    }

    private int recur(int[] nums, int low, int high) {
        if (low == high)
            return nums[low];
        int mid = low + (high - low) / 2;
        return Math.min(recur(nums, low, mid), recur(nums, mid + 1, high));
    }
}
