package com.zjs.binarysearch;

/**
 * @ClassName FindMinC2
 * @Description 154 寻找旋转排序数组中的最小值 II 题目链接：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * 二分查找（与右边的元素比较）
 * @Author zhangjusheng
 * @Date 2020/12/13 21:22
 * @Version 1.0
 */
public class FindMinC2 {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[right] < nums[mid]) {
                left = mid + 1;
            } else if (nums[right] > nums[mid]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[right];
    }
}
