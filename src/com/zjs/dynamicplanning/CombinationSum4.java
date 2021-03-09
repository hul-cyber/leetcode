package com.zjs.dynamicplanning;

/**
 * @ClassName CombinationSum4
 * @Description 377. 组合总和IV 题目链接: https://leetcode-cn.com/problems/combination-sum-iv/
 * 动态规划
 * @Author hul-cyber
 * @Date 2021/3/9 23:59
 * @Version 1.0
 */
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        int len = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        int res = 0;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    if (dp[i - num] != 0) {
                        dp[i] += dp[i - num];
                    }
                }
            }
        }
        return dp[target];
    }
}
