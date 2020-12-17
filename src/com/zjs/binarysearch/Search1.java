package com.zjs.binarysearch;

/**
 * @ClassName Search1
 * @Description 33 搜索旋转排序数组 题目链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 二分查找
 * @Author zhangjusheng
 * @Date 2020/12/13 21:25
 * @Version 1.0
 */
public class Search1 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 如果在同侧
            if ((nums[mid] >= nums[left] && target >= nums[left]) || (nums[mid] <= nums[right] &&
                    target <= nums[right])) {
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            } else {
                if (nums[mid] > target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        if (nums[left] == target)
            return left;
        return -1;
    }
}
