package com.zjs.greedalgorithm;

/**
 * @ClassName MaxProfitC1
 * @Description 122 买卖股票的最佳时机II 题目链接: https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 寻找递增的子序列
 * @Author zhangjusheng
 * @Date 2020/12/4 21:23
 * @Version 1.0
 */
public class MaxProfitC1 {

    public int maxProfit(int[] prices) {
        int soFarMin = prices[0];
        int profit = 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit = prices[i] - soFarMin;
            } else {
                soFarMin = prices[i];
                sum += profit;
                profit = 0;
            }
        }
        sum += profit;
        return sum;
    }
}
