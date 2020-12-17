package com.zjs.binarysearch;

/**
 * @ClassName SearchInsert1
 * @Description 35 搜索插入位置 题目链接：https://leetcode-cn.com/problems/search-insert-position/
 * 二分查找
 * @Author zhangjusheng
 * @Date 2020/12/13 21:32
 * @Version 1.0
 */
public class SearchInsert1 {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 下面进行情况讨论
        if (nums[left] >= target) {
            return left;
        } else {
            return left + 1;
        }
    }
}
