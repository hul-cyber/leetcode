package com.zjs.sort;

/**
 * @ClassName FindDuplicate
 * @Description 287. 寻找重复数 题目链接: https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 原地哈希排序
 * @Author zhangjusheng
 * @Date 2021/1/19 15:03
 * @Version 1.0
 */
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            while (nums[nums[i] - 1] != nums[i])
                swap(nums, nums[i] - 1, i);
        }
        return nums[length - 1];
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
