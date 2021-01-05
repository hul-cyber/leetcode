package com.zjs.sort;

/**
 * @ClassName SortArray5
 * @Description 912 排序数组 题目链接: https://leetcode-cn.com/problems/sort-an-array/
 * 折半查找的第三种方式 哨兵
 * @Author zhangjusheng
 * @Date 2021/1/2 15:45
 * @Version 1.0
 */
public class SortArray5 {

    public int[] sortArray(int[] nums) {
        int length = nums.length;
        int minIndex = 0;
        for (int i = 1; i < length; i++) {
            if (nums[minIndex] > nums[i])
                minIndex = i;
        }
        swap(nums, minIndex, 0);
        int temp = 0;
        for (int i = 1; i < length; i++) {
            temp = nums[i];
            int j = i;
            while (nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
