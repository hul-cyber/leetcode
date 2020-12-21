package com.zjs.binarysearch;

/**
 * @ClassName MinTime2
 * @Description LCP 12 小张的刷题计划 题目链接: https://leetcode-cn.com/problems/xiao-zhang-shua-ti-ji-hua/
 * 二分答案(优化版)
 * @Author zhangjusheng
 * @Date 2020/12/21 19:08
 * @Version 1.0
 */
public class MinTime2 {

    public int minTime(int[] time, int m) {
        // 设置最大值和最小值
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < time.length; i++) {
            max = Math.max(max, time[i]);
            sum += time[i];
        }
        int low = 0;
        int high = sum - max;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (check(time, m, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean check(int[] time, int m, int limit) {
        // 已经耗费的天数,总共用过的时间,当前范围的最大值
        int useDay, totalTime, maxTime;
        useDay = 1;
        totalTime = 0;
        maxTime = 0;
        for (int i = 0; i < time.length; i++) {
            int nextTime = Math.min(maxTime, time[i]);
            if (totalTime + nextTime <= limit) {
                // 如果小于等于当天的时间限制
                totalTime += nextTime;
                // 设置当前范围中的最大值
                maxTime = Math.max(maxTime, time[i]);
            } else {
                useDay++;
                totalTime = 0;
                maxTime = time[i];
            }
        }
        return useDay <= m;
    }
}
