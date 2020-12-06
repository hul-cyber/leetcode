package com.zjs.greedalgorithm;

/**
 * @ClassName MaxProfit
 * @Description 121 买卖股票的最佳时机
 * @Author zhangjusheng
 * @Date 2020/12/4 20:26
 * @Version 1.0
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int soFarMin = prices[0];
        int profit = 0;
        for (int i = 1; i < n; i++) {
            profit = Math.max(prices[i] - soFarMin, profit);
            if (soFarMin > prices[i]) soFarMin = prices[i];
        }
        return profit;
    }
}
