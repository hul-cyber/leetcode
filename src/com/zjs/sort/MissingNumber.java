package com.zjs.sort;

/**
 * @ClassName MissingNumber
 * @Description 268. 丢失的数字 题目链接: https://leetcode-cn.com/problems/missing-number/
 * 哈希排序的思想
 * @Author zhangjusheng
 * @Date 2021/1/19 14:32
 * @Version 1.0
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] < length && nums[i] != i) {
                swap(nums, nums[i], i);
            }
        }
        int i = 0;
        for (; i < length; i++) {
            if (nums[i] != i)
                return i;
        }
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
