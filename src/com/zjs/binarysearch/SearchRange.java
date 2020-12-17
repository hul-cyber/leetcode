package com.zjs.binarysearch;

/**
 * @ClassName SearchRange
 * @Description 34 在排序数组中查找元素的第一个和最后一个位置 题目链接: https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 二分查找
 * @Author zhangjusheng
 * @Date 2020/12/9 10:52
 * @Version 1.0
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int leftPos = getLeftPosition(nums, target);
        if (leftPos == -1) {
            return new int[]{-1, -1};
        }
        int rightPos = getRightPosition(nums, target);
        return new int[]{leftPos, rightPos};
    }

    public int getRightPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 向上取整
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                // 右边界一定出现在mid左边
                right = mid - 1;
            } else {
                // 右边界一定出现在mid甚至其右边
                left = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    public int getLeftPosition(int[] nums, int target) {
        // 寻找最左端的位置
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 左边界一定出现在mid右边
                left = mid + 1;
            } else {
                // 左边界一定出现在mid甚至其左边
                right = mid;
            }
        }
        if (nums[left] == target)
            return left;
        return -1;
    }
}
