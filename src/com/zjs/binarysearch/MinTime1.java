package com.zjs.binarysearch;

/**
 * @ClassName MinTime1
 * @Description LCP 12 小张的刷题计划 题目链接: https://leetcode-cn.com/problems/xiao-zhang-shua-ti-ji-hua/
 * 二分答案(未优化check()函数)
 * @Author zhangjusheng
 * @Date 2020/12/21 19:05
 * @Version 1.0
 */
public class MinTime1 {

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

    // 贪心算法来判断一天target长度的时间是否合适
    public boolean check(int[] time, int m, int target) {
        // 总时间
        int cur = 0;
        int max = Integer.MIN_VALUE;
        int help = 1;
        int index = 0;
        for (int i = 0; i < time.length;) {
            cur += time[i];
            max = Math.max(time[i], max);
            if (cur > target) {
                if (help == 1) {
                    // 使用一次场外求助机会
                    cur -= max;
                    help--;
                    i++;
                } else {
                    // 耗费一天时间
                    cur = 0;
                    m--;
                    help++;
                    max = Integer.MIN_VALUE;
                }
            } else {
                i++;
            }
        }
        return m > 0;
    }

}
