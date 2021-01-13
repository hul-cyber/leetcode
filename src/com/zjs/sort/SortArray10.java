package com.zjs.sort;

import java.util.Random;

/**
 * @ClassName SortArray10
 * @Description 912 排序数组 题目链接: https://leetcode-cn.com/problems/sort-an-array/
 * 快速排序 优化版 将与pivot相等的元素放在中间
 * @Author zhangjusheng
 * @Date 2021/1/13 22:39
 * @Version 1.0
 */
public class SortArray10 {

    private static final Random RANDOM = new Random();

    public int[] sortArray(int[] nums) {
        int length = nums.length;
        quickSort(nums, 0, length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(nums, left, randomIndex);
        int p = partition(nums, left, right);
        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, right);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int lt = left;
        int gt = right + 1;
        int i = lt + 1;
        while (i < gt) {
            if (nums[i] > pivot) {
                gt--;
                swap(nums, i, gt);
            } else if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
                i++;
            } else {
                i++;
            }
        }
        swap(nums, lt, left);
        return lt;
    }
}
