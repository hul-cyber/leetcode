package com.zjs.greedalgorithm;

/**
 * @ClassName MaxProfitC2
 * @Description 122 买卖股票的最佳时机II 题目链接: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 贪心算法
 * @Author zhangjusheng
 * @Date 2020/12/4 21:27
 * @Version 1.0
 */
public class MaxProfitC2 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                profit += (prices[i] - prices[i - 1]);
        }
        return profit;
    }
}
