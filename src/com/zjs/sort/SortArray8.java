package com.zjs.sort;

import java.util.Random;

/**
 * @ClassName SortArray8
 * @Description 912 排序数组 题目链接: https://leetcode-cn.com/problems/sort-an-array/
 * 快速排序
 * @Author zhangjusheng
 * @Date 2021/1/13 22:11
 * @Version 1.0
 */
public class SortArray8 {
    private static final Random RANDOM = new Random();

    public int[] sortArray(int[] nums) {
        int length = nums.length;
        quickSort(nums, 0, length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int p = partition(nums, low, high);
        quickSort(nums, low, p - 1);
        quickSort(nums, p + 1, high);
    }

    private int partition(int[] nums, int low, int high) {
        int randomIndex = low + RANDOM.nextInt(high - low + 1);
        swap(nums, low, randomIndex);
        int pivot = nums[low];
        int i = low + 1, lt = low;
        while (i <= high) {
            if (nums[i] < pivot) {
                swap(nums, lt + 1, i);
                lt++;
            }
            i++;
        }
        swap(nums, lt, low);
        return lt;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
