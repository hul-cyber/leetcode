package com.zjs.sort;

/**
 * @ClassName SortArray2
 * @Description 912. 排序数组 题目链接: https://leetcode-cn.com/problems/sort-an-array/
 * 冒泡排序
 * @Author zhangjusheng
 * @Date 2021/1/2 15:29
 * @Version 1.0
 */
public class SortArray2 {

    public int[] sortArray(int[] nums) {
        int cnt = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            cnt = 0;
            for (int j = 1; j <= i; j++) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                    cnt++;
                }
            }
            if (cnt == 0)
                break;
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
