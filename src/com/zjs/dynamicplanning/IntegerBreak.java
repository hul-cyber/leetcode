package com.zjs.dynamicplanning;

/**
 * @ClassName IntegerBreak
 * @Description 343. 整数拆分 题目链接: https://leetcode-cn.com/problems/integer-break/
 * @Author hul-cyber
 * @Date 2021/3/10 0:00
 * @Version 1.0
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(Math.max(j * dp[i - j], j * (i - j)), dp[i]);
            }
        }
        return dp[n];
    }
}
