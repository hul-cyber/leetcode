package com.zjs.binarysearch;

/**
 * @ClassName MinDays
 * @Description 1482 制作m束花所需要的最少天数 题目链接: https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * 二分答案
 * @Author zhangjusheng
 * @Date 2020/12/21 10:33
 * @Version 1.0
 */
public class MinDays {

    public int minDays(int[] bloomDay, int m, int k) {
        // 首先判断是否足够能制作m束花
        if (bloomDay.length < m * k)
            return -1;
        // 确定查找范围 开花日期的最小值 ~ 开花日期的最大值
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < bloomDay.length; i++) {
            min = Math.min(min, bloomDay[i]);
            max = Math.max(max, bloomDay[i]);
        }
        int low = min, high = max;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (check(bloomDay, mid, m, k)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // 判断天数符不符合条件
    public boolean check(int[] bloomDay, int target, int m, int k) {
        // 记录当前已经采摘的花朵数(已经成束的不算)和当前的束数
        int cnt = 0, sum = 0;
        // 首先判断出来哪些花朵已经可以采摘
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= target) {
                // 如果能采摘
                cnt++;
                // 判断是否可以成束
                if (cnt == k) {
                    sum++;
                    cnt = 0;
                }
            } else {
                // 如果不能采摘
                cnt = 0;
            }
        }
        return sum >= m;
    }
}
