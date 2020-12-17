package com.zjs.greedyalgorithm;

/**
 * @ClassName MaxSubArray1
 * @Description 53 最大子序和 题目链接: https://leetcode-cn.com/problems/maximum-subarray/description/
 * 动态规划
 * @Author zhangjusheng
 * @Date 2020/12/5 11:29
 * @Version 1.0
 */
public class MaxSubArray1 {

    public int maxSubArray(int[] nums) {
        int preSum = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum = Math.max(preSum + nums[i], nums[i]);
            res = Math.max(preSum, res);
        }
        return res;
    }
}
