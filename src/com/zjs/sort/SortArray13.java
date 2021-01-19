package com.zjs.sort;

/**
 * @ClassName SortArray13
 * @Description 912 排序数组 题目链接: https://leetcode-cn.com/problems/sort-an-array/
 * 计数排序
 * @Author zhangjusheng
 * @Date 2021/1/19 9:48
 * @Version 1.0
 */
public class SortArray13 {

    private static final int OFFSET = 50000;

    public int[] sortArray(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            nums[i] += OFFSET;
        }
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            max = Math.max(max, nums[i]);
        }
        int[] arr = new int[max + 1];
        int[] temp = new int[length];
        System.arraycopy(nums, 0, temp, 0, length);
        countingSort(nums, temp, arr);
        for (int i = 0; i < length; i++) {
            nums[i] -= OFFSET;
        }
        return nums;
    }

    private void countingSort(int[] nums, int[] temp, int[] arr) {
        int len = nums.length;
        for (int num : nums) {
            arr[num]++;
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        for (int i = len - 1; i >= 0; i--) {
            nums[arr[temp[i]] - 1] = temp[i];
            arr[temp[i]]--;
        }
    }
}
