package com.zjs.greedalgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName EraseOverlapIntervals
 * @Description 435 无重叠区间 题目链接: https://leetcode-cn.com/problems/non-overlapping-intervals/description/
 * 贪心策略
 * @Author zhangjusheng
 * @Date 2020/12/6 9:52
 * @Version 1.0
 */
public class EraseOverlapIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0] == null || intervals[0].length == 0)
            return 0;
        // 将所有的区间按照区间结尾从小到大进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        // 将能够组成的最多的不重叠的区间找出来
        int num = 1;
        // [1, 11] [2, 12] [11, 22] [1, 100]
        // 记录当前最后一个不重叠的区间是第几个区间
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                // 如果后一个开头大于前一个结尾,则说明能连接成为不重叠的区间
                num++;
                end = intervals[i][1];
            }
        }
        return intervals.length - num;
    }
}
