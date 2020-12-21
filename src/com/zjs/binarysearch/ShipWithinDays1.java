package com.zjs.binarysearch;

/**
 * @ClassName ShipWithinDays1
 * @Description 1011 在D天内送达包裹的能力 题目链接: https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 * 二分答案
 * @Author zhangjusheng
 * @Date 2020/12/20 23:46
 * @Version 1.0
 */
public class ShipWithinDays1 {

    public int shipWithinDays(int[] weights, int D) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < weights.length; i++) {
            max = Math.max(max, weights[i]);
            sum += weights[i];
        }
        int low = max, high = sum;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (check(weights, D, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean check(int[] weights, int D, int capacity) {
        int cnt = 0, sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum >= capacity) {
                cnt++;
                if (sum > capacity) {
                    sum = weights[i];
                } else {
                    sum = 0;
                }
            }
        }
        if (sum > 0)
            cnt++;
        return cnt <= D;
    }
}
