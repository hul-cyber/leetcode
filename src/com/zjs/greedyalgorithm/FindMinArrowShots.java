package com.zjs.greedyalgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName FindMinArrowShots
 * @Description 452 用最少数量的箭引爆气球 题目链接: https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
 * 贪心策略
 * @Author zhangjusheng
 * @Date 2020/12/6 9:58
 * @Version 1.0
 */
public class FindMinArrowShots {

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0)
            return 0;
        // 按照气球结尾的大小从小到大排序
        // Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        Arrays.sort(points, new Comparator<int[]>(){

            @Override
            public int compare(int[] a, int[] b) {
                return a[1] < b[1] ? -1 : (a[1] == b[1] ? 0 : 1);
            }
        });
        // 箭头的数量
        int arrowNum = 1;
        // 模拟扎气球的过程,弓箭的初始位置在第一个气球的结尾
        int arrowPos = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                // 如果箭头的位置大于等于此气球的初始位置
                continue;
            } else {
                // 如果箭头的位置小于此气球的初始位置
                arrowPos = points[i][1];
                arrowNum++;
            }
        }
        return arrowNum;
    }
}
