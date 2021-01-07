package com.zjs.twopoints;

/**
 * @ClassName RemoveDuplicates
 * @Description 80 删除排序数组中的重复项 II 题目链接: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
 * 双指针 + 循环不变量
 * @Author zhangjusheng
 * @Date 2021/1/7 22:38
 * @Version 1.0
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        return removeDuplicates(nums, 2);
    }

    public int removeDuplicates(int[] nums, int k) {
        int length = nums.length;
        if (length <= k)
            return length;
        int i = k;
        int j = k;
        for(; j < length; j++) {
            if (nums[j] != nums[i - k]) {
                if (j != i)
                    nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}
