package com.zjs.sort;

/**
 * @ClassName SortArray12
 * @Description 912 排序数组 题目链接: https://leetcode-cn.com/problems/sort-an-array/
 * 桶排序
 * @Author zhangjusheng
 * @Date 2021/1/19 9:45
 * @Version 1.0
 */
public class SortArray12 {

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
        // 计算步长
        int step = 1000;
        int maxLen = getMaxLen(max);
        if (maxLen < 4) {
            step = (int) Math.pow(10, maxLen - 1);
        }
        int bucketLen = max / step + 1;
        int[][] temp = new int[bucketLen][length];
        int[] next = new int[bucketLen];
        int bucketIndex = 0;
        for (int num : nums) {
            bucketIndex = num / step;
            temp[bucketIndex][next[bucketIndex]] = num;
            next[bucketIndex]++;
        }
        for (int i = 0; i < bucketLen; i++) {
            InsertSort(temp[i], next[i]);
        }
        int index = 0;
        for (int i = 0; i < bucketLen; i++) {
            for (int j = 0; j < next[i]; j++) {
                nums[index] = temp[i][j];
                index++;
            }
        }
        for (int i = 0; i < length; i++) {
            nums[i] -= OFFSET;
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void InsertSort(int[] nums, int length) {
        int minIndex = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] < nums[minIndex])
                minIndex = i;
        }
        swap(nums, 0, minIndex);
        for (int i = 1; i < length; i++) {
            int temp = nums[i];
            int j = i;
            while (nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    private int getMaxLen(int num) {
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }
}
