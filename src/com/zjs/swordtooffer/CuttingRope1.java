package com.zjs.swordtooffer;

/**
 * 动态规划解决割绳子问题
 * 最坏情况下: 时间复杂度:O(n^2) 空间复杂度:O(n)
 * 题目链接: https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 */
public class CuttingRope1 {
    public static void main(String[] args) {
        System.out.println(cuttingRope2(10));
    }

    /**
     * 未优化的动态规划
     */
    public static int cuttingRope(int n) {
        if (n <= 1) {
            return 0;
        } else {
            //存储长度从1 ~ n的所有绳子剪完后的最大分段乘积
            int[] max = new int[n];
            for (int i = 1; i < n; i++) {
                max[i] = i;
                for (int j = 0; j <= i; j++) {
                    int i1 = max[j] * max[i - j];
                    if (i1 > max[i]) {
                        max[i] = i1;
                    }
                }
            }
            int maxValue = 0;
            for (int m = 1; m < n; m++) {
                int i = max[m] * max[n - m];
                if (i > maxValue) {
                    maxValue = i;
                }
            }
            return maxValue;
        }
    }

    /**
     * 优化的动态规划
     * 对于一个长度为i绳子来说,总是要被切分,这样就分成了两种情况:
     *  1. 分成j和i - j,并且i - j长度的绳子选择不再被切分,乘积为j * i - j
     *  2. 分成j和i - j,并且i - j长度的绳子选择被切分,乘积为j * dp[i - j],dp[i - j]代表i - j长度的绳子被切分之后最大分段乘积
     * 也就是只有上面这两种情况,那么最大分段乘积dp[i] = max{j * i - j, j * dp[i - j]}
     */
    public static int cuttingRope2(int n) {
        if (n < 2)
            return 0;
        //记录绳子最大分段乘积
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if ((j * dp[i - j]) > dp[i]) {
                    dp[i] = j * dp[i - j];
                }
                if ((j * (i - j)) > dp[i]) {
                    dp[i] = j * (i - j);
                }
            }
        }
        return dp[n];
    }
}
