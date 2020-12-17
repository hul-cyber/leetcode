package com.zjs.binarysearch;

/**
 * @ClassName FindMin1
 * @Description 153 寻找旋转排序数组中的最小值 题目链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 二分查找（与左边的元素比较）
 * @Author zhangjusheng
 * @Date 2020/12/13 21:16
 * @Version 1.0
 */
public class FindMin1 {

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
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
