package com.zjs.sort;

/**
 * @ClassName SortArray11
 * @Description 912 排序数组 题目链接: https://leetcode-cn.com/problems/sort-an-array/
 * 基数排序
 * @Author zhangjusheng
 * @Date 2021/1/15 20:30
 * @Version 1.0
 */
public class SortArray11 {

    private static final int OFFSET = 50000;

    public int[] sortArray(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            nums[i] += OFFSET;
        }
        int max = nums[0];
        for (int i = 1; i < length; i++) {
            max = Math.max(nums[i], max);
        }
        int maxLen = getMaxLen(max);
        int divisor = 1;
        int[] count = new int[10];
        int[] temp = new int[length];
        for (int i = 0; i < maxLen; i++) {
            System.arraycopy(nums, 0, temp, 0, length);
            countingSort(nums, temp, count, divisor);
            divisor *= 10;
        }
        for (int i = 0; i < length; i++) {
            nums[i] -= OFFSET;
        }
        return nums;
    }

    private void countingSort(int[] nums, int[] temp, int[] count, int divisor) {
        int length = nums.length;
        int remainder = 0;

        for (int i = 0; i < length; i++) {
            remainder = (nums[i] / divisor) % 10;
            count[remainder]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = length - 1; i >= 0; i--) {
            remainder = (temp[i] / divisor) % 10;
            nums[count[remainder] - 1] = temp[i];
            count[remainder]--;
        }

        for (int i = 0; i < 10; i++) {
            count[i] = 0;
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
