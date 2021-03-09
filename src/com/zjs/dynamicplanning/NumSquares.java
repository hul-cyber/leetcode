package com.zjs.dynamicplanning;

import java.util.Arrays;

/**
 * @ClassName NumSquares
 * @Description 279. 完全平方数 题目链接: https://leetcode-cn.com/problems/perfect-squares/
 * @Author hul-cyber
 * @Date 2021/3/10 0:02
 * @Version 1.0
 */
public class NumSquares {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 4);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}
