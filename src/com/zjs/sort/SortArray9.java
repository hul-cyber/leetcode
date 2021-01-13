package com.zjs.sort;

import java.util.Random;

/**
 * @ClassName SortArray9
 * @Description 912 排序数组 题目链接: https://leetcode-cn.com/problems/sort-an-array/
 * 快速排序 优化版 将与pivot相等的元素放在两侧
 * @Author zhangjusheng
 * @Date 2021/1/13 22:03
 * @Version 1.0
 */
public class SortArray9 {

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
        int le = left + 1;
        int ge = right;
        int pivot = nums[left];
        while (le <= ge) {
            while (le <= ge && nums[le] < pivot) {
                le++;
            }
            while (ge >= le && nums[ge] > pivot) {
                ge--;
            }
            if (le > ge)
                break;
            swap(nums, le, ge);
            le++;
            ge--;
        }
        swap(nums, left, ge);
        return ge;
    }
}
