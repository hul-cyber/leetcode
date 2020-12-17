package com.zjs.binarysearch;

/**
 * @ClassName FindMinC1
 * @Description 154 寻找旋转排序数组中的最小值 II 题目链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * 二分查找（与左边的元素比较）
 * @Author zhangjusheng
 * @Date 2020/12/13 21:21
 * @Version 1.0
 */
public class FindMinC1 {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 如果没有发生反转
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if (nums[left] > nums[mid]) {
                right = mid;
            } else if (nums[left] < nums[mid]) {
                left = mid + 1;
            } else {
                left++;
            }
        }
        return nums[left];
    }
}
