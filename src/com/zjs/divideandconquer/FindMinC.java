package com.zjs.divideandconquer;

/**
 * @ClassName FindMinC
 * @Description 154 寻找旋转排序数组中的最小值 II 题目链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * @Author zhangjusheng
 * @Date 2021/1/5 23:40
 * @Version 1.0
 */
public class FindMinC {
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
        } else if (nums[low] > nums[mid]) {
            return findMin(nums, low, mid);
        } else {
            low++;
            return findMin(nums, low, high);
        }
    }}
