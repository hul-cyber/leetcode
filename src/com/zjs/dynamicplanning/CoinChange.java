package com.zjs.dynamicplanning;

import java.util.Arrays;

/**
 * @ClassName CoinChange
 * @Description 322. 零钱兑换 题目链接: https://leetcode-cn.com/problems/coin-change/
 * 动态规划
 * @Author hul-cyber
 * @Date 2021/3/10 0:03
 * @Version 1.0
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        if (dp[amount] == amount + 1) {
            return -1;
        }
        return dp[amount];
    }
}
