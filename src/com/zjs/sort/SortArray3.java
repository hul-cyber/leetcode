package com.zjs.sort;

/**
 * @ClassName SortArray3
 * @Description 912. 排序数组 题目链接: https://leetcode-cn.com/problems/sort-an-array/
 * 插入排序第一种方式
 * @Author zhangjusheng
 * @Date 2021/1/2 15:31
 * @Version 1.0
 */
public class SortArray3 {
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1])
                    swap(nums, j, j - 1);
                else
                    break;
            }
        }
        return nums;
    }

    // 交换需要3次赋值
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
