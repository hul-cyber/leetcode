package com.zjs.sort;

/**
 * @ClassName FirstMissingPositive
 * @Description 41.缺失的第一个正数 题目链接: https://leetcode-cn.com/problems/first-missing-positive/
 * 借助hash排序的思想
 * @Author zhangjusheng
 * @Date 2021/1/19 14:07
 * @Version 1.0
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] > 0 && nums[i] < length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        int index = 0;
        while (index < length)
            if (nums[index] != index + 1) {
                return index + 1;
            } else {
                index++;
            }
        return index + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
