package com.zjs.greedalgorithm;

/**
 * @ClassName MaxSubArray2
 * @Description 53 最大子序和 题目链接: https://leetcode-cn.com/problems/maximum-subarray/description/
 * 贪婪算法
 * @Author zhangjusheng
 * @Date 2020/12/5 11:31
 * @Version 1.0
 */
public class MaxSubArray2 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return Integer.MIN_VALUE;
        int preSum = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum = preSum > 0 ? preSum + nums[i] : nums[i];
            if (res < preSum)
                res = preSum;
        }
        return res;
    }
}
