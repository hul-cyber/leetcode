package com.zjs.divideandconquer;

/**
 * @ClassName FindMin2
 * @Description 153 寻找旋转排序数组中的最小值 题目链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 分治法(优化版)
 * @Author zhangjusheng
 * @Date 2021/1/5 23:20
 * @Version 1.0
 */
public class FindMin2 {
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int low, int high) {
        if (low == high)
            return nums[low];

        if (low + 1 == high)
            return Math.min(nums[low], nums[high]);

        if (nums[low] < nums[high])
            return nums[low];

        int mid = low + (high - low) / 2;
        if (nums[low] < nums[mid]) {
            return findMin(nums, mid + 1, high);
        } else {
            return findMin(nums, low, mid);
        }
    }
}
