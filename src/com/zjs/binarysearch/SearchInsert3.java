package com.zjs.binarysearch;

/**
 * @ClassName SearchInsert3
 * @Description 35 搜索插入位置 题目链接：https://leetcode-cn.com/problems/search-insert-position/
 * 二分查找改进版
 * @Author zhangjusheng
 * @Date 2020/12/14 19:32
 * @Version 1.0
 */
public class SearchInsert3 {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
