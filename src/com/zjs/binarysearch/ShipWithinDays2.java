package com.zjs.binarysearch;

/**
 * @ClassName ShipWithinDays2
 * @Description 1011 在D天内送达包裹的能力 题目链接: https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 * 二分答案(优化check函数)
 * @Author zhangjusheng
 * @Date 2020/12/20 23:58
 * @Version 1.0
 */
public class ShipWithinDays2 {

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
        // 当前船的装载能力
        int cur = capacity;
        int i = 0;
        for (int weight : weights) {
            if (cur < weight) {
                cur = capacity;
                D--;
            }
            cur -= weight;
        }
        return D > 0;
    }
}
