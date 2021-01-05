package com.zjs.sort;

/**
 * @ClassName SortArray6
 * @Description 912 排序数组 题目链接: https://leetcode-cn.com/problems/sort-an-array/
 * 使用折半查找来确定插入的位置
 * @Author zhangjusheng
 * @Date 2021/1/4 20:23
 * @Version 1.0
 */
public class SortArray6 {

    public int[] sortArray(int[] nums) {
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            // 使用折半查找寻找要插入的位置
            int posToInsert = binarySort(0, i, nums, nums[i]);
            int temp = nums[i];
            for (int j = i; j > posToInsert; j--) {
                nums[j] = nums[j - 1];
            }
            nums[posToInsert] = temp;
        }
        return nums;
    }

    public int binarySort(int low, int high, int[] nums, int target) {
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
