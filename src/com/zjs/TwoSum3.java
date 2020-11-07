package com.zjs;

/**
 * @ClassName TwoSum3
 * @Description 剑指Offer 57 和为s的两个数字 题目链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * 双指针法
 * @Author zhangjusheng
 * @Date 2020/11/7 23:34
 * @Version 1.0
 **/
public class TwoSum3 {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (nums[left] + nums[right] == target)
                return new int[]{nums[left], nums[right]};
            else if (nums[left] + nums[right] < target)
                left++;
            else
                right--;
        }

        return new int[]{-1, -1};
    }
}
