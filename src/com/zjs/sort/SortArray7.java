package com.zjs.sort;

import java.util.Arrays;

/**
 * @ClassName SortArray7
 * @Description 912 排序数组 题目链接: https://leetcode-cn.com/problems/sort-an-array/
 * 归并排序
 * @Author zhangjusheng
 * @Date 2021/1/5 16:46
 * @Version 1.0
 */
public class SortArray7 {
    public int[] sortArray(int[] nums) {
        int length = nums.length;
        mergeSort(0, length - 1, nums, 0);
        return nums;
    }

    private void mergeSort(int low, int high, int[] nums, int depthForDebug) {
        System.out.println(repeat(" ", depthForDebug) + "divide (" + low + "," + high + ")");

        if (low == high)
            return;

        int mid = low + (high - low) / 2;
        mergeSort(low, mid, nums, depthForDebug + 1);
        mergeSort(mid + 1, high, nums, depthForDebug + 1);
        System.out.println(repeat(" ", depthForDebug) + "conquer (" + low + "," + high + ")");
        mergeOfTwoSortedArrays(low, high, mid, nums);
    }

    private void mergeOfTwoSortedArrays(int low, int high, int mid, int[] nums) {
        int length = nums.length;
        int[] temp = Arrays.copyOfRange(nums, 0, length);

        // 合并两个数组
        int i = low, j = mid + 1, k = low;
        while (i <= mid && j <= high) {
            if (temp[i] <= temp[j]) {
                nums[k++] = temp[i++];
            } else {
                nums[k++] = temp[j++];
            }
        }
        if (i > mid) {
            while (j <= high) {
                nums[k++] = temp[j++];
            }
        } else {
            while (i <= mid) {
                nums[k++] = temp[i++];
            }
        }
    }

    private static String repeat(String s, int num) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < num; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}
