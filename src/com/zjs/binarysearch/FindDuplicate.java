package com.zjs.binarysearch;

/**
 * @ClassName FindDuplicate
 * @Description 287 寻找重复数 题目链接: https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 二分查找
 * @Author zhangjusheng
 * @Date 2020/12/17 21:38
 * @Version 1.0
 */
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int num = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    num++;
                }
            }
            if (num > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
