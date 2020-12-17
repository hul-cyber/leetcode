package com.zjs.binarysearch;

/**
 * @ClassName Search2
 * @Description 33 搜索旋转排序数组 题目链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 二分查找
 * @Author zhangjusheng
 * @Date 2020/12/13 21:26
 * @Version 1.0
 */
public class Search2 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left]) {
                //left到mid是有序区间
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                // mid 到 right是有序区间
                if (target <= nums[right] && target >= nums[mid]) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        if (nums[left] == target)
            return left;
        return -1;
    }
}
