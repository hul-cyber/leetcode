package com.zjs.binarysearch;

import java.util.Scanner;

/**
 * @ClassName SkippingStones
 * @Description
 * 该题与leetcode 410 分割数组的最大值类似 题目来源: https://www.bilibili.com/video/BV1AJ411J7Dv?t=40
 *
 * 题目描述: 在起点与终点之间, 有N块岩石(不含起点与终点), 在比赛过程中, 选手们从起点出发, 每一步跳向相邻的岩石,
 * 直至到达终点。为了提高难度, 组委会计划移走一些岩石, 使得选手们在比赛过程中的最短跳跃距离尽可能长。由于预算限制,
 * 组委会至多从起点到终点之间移走M块岩石（不能够移走起点和终点的岩石）
 *
 * 二分答案
 * @Author zhangjusheng
 * @Date 2020/12/19 23:31
 * @Version 1.0
 *
 * TODO 有的测试通不过去, 暂时放弃
 */
public class SkippingStones {

    public static void main(String[] args) {
        int l, n, m;
        Scanner s = new Scanner(System.in);
        // 起点到终点的距离
        l = s.nextInt();
        // 起点与终点之间的元素数
        n = s.nextInt();
        // 最多移走的岩石数
        m = s.nextInt();
        // 中间的岩石数组
        int[] stones = new int[n + 2];
        // 设置开头与结尾的石头坐标
        stones[0] = 0;
        stones[n + 1] = l;
        int[] intervals = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            stones[i] = s.nextInt();
            intervals[i - 1] = stones[i] - stones[i - 1];
        }
        intervals[n] = stones[n + 1] - stones[n];
        check(intervals, m, 9);
        System.out.println(skippingStones(intervals, m, l));
    }

    public static int skippingStones(int[] intervals, int m, int l) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            min = Math.min(min, intervals[i]);
        }
        // 确定范围
        int low = min, high = l;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (check(intervals, m, mid)) {
                // 如果满足条件
                low = mid;
            } else {
                // 如果不满足条件
                high = mid - 1;
            }
        }
        return low;
    }

    // 使用贪心算法
    public static boolean check(int[] intervals, int m, int target) {
        boolean flag = false;
        for (int i = 0; i < intervals.length; i++) {
            if (target > intervals[i]) {
                // 如果间隔比目标值小,扩大范围,将间隔后面的石头移除
                flag = false;
                if (i + 1 < intervals.length) {
                    intervals[i + 1] += intervals[i];
                }
            } else {
                // 如果间隔大于等于目标值
                flag = true;
            }
        }
        return flag;
    }
}
