package com.zjs.binarysearch;

/**
 * @ClassName SearchC1
 * @Description 81 搜索旋转排序数组 II 题目链接: https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 * 二分查找
 * @Author zhangjusheng
 * @Date 2020/12/14 20:38
 * @Version 1.0
 */
public class SearchC1 {

    public boolean search(int[] nums, int target) {
        if (nums.length == 0)
            return false;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 向下取整
            int mid = left + (right - left) / 2;
            if (nums[left] == nums[mid]) {
                if (nums[left] == target)
                    return true;
                left++;
            } else if (nums[left] < nums[mid]) {
                //[left, mid]是有序区间
                if (nums[left] <= target && nums[mid] >= target) {
                    // 将不规则区间直接抛弃
                    right = mid;
                } else {
                    // 如果没在该区间内
                    left = mid + 1;
                }
            } else if (nums[mid + 1] <= nums[right]) {
                // 因为是向下取整,所以不用担心mid + 1越界的情况
                //[mid + 1, right]是有序区间
                if (nums[mid + 1] <= target && nums[right] >= target) {
                    // 如果目标值在该区间内
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }
        if (nums[left] == target)
            return true;
        return false;
    }
}
