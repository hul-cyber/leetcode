package com.zjs.swordtooffer;

/**
 * @ClassName MaxProfit1
 * @Description 剑指Offer 63 股票的最大利润 题目链接: https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 * 双指针法
 * @Author zhangjusheng
 * @Date 2020/11/17 18:12
 * @Version 1.0
 */
public class MaxProfit1 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minp = 0;
        int maxp = 0;
        int pointer = 0;

        while (pointer < prices.length - 1) {
            pointer++;
            if (prices[minp] > prices[pointer]) {
                minp = pointer;
                if (maxp < minp)
                    maxp = minp;
            } else if (prices[maxp] < prices[pointer]) {
                maxp = pointer;
                profit = profit >= prices[maxp] - prices[minp] ? profit : prices[maxp] - prices[minp];
            }
        }
        return profit;
    }
}
