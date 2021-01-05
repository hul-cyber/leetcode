package com.zjs.sort;

/**
 * @ClassName SortArray1
 * @Description 912. 排序数组 题目链接: https://leetcode-cn.com/problems/sort-an-array/
 * 选择排序
 * @Author zhangjusheng
 * @Date 2021/1/2 15:25
 * @Version 1.0
 */
public class SortArray1 {
    public int[] sortArray(int[] nums) {
        if (nums.length == 0)
            return new int[]{};
        int minIndex = 0;
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[minIndex] > nums[j])
                    minIndex = j;
            }
            swap(nums, i, minIndex);
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
