package com.zjs.swordtooffer;

import java.math.BigInteger;

/**
 * 动态规划 + 大数取余解决割绳子2
 * 题目链接: https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 */
public class CuttingRope2 {
    public static void main(String[] args) {
        System.out.println(cuttingRope(5));
    }

    public static int cuttingRope(int n) {
        if (n < 2)
            return 0;
        //记录绳子最大分段乘积
        BigInteger[] dp = new BigInteger[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new BigInteger("0");
        }
        BigInteger m;
        BigInteger k;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                m = new BigInteger(Integer.toString(j));
                k = new BigInteger(Integer.toString(i - j));
                BigInteger multiply = m.multiply(dp[i - j]);
                if (multiply.compareTo(dp[i]) > 0) {
                    dp[i] = multiply;
                }
                if (m.multiply(k).compareTo(dp[i]) > 0) {
                    dp[i] = m.multiply(k);
                }
            }
        }
        return dp[n].mod(new BigInteger(Integer.toString(1000000007))).intValue();
    }
}