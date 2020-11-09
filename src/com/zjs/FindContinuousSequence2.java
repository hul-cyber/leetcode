package com.zjs;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FindContinuousSequence2
 * @Description 剑指Offer 57-II 和为s的连续正数序列 题目链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * 滑动窗口 + 枚举
 * @Author zhangjusheng
 * @Date 2020/11/9 23:37
 * @Version 1.0
 **/
public class FindContinuousSequence2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> lists = new ArrayList<>();

        int i = 1, j = 2;
        int sum = 0;

        while (i < j) {
            sum = (i + j) * (j - i + 1) / 2;
            if (sum == target) {
                int[] list = new int[j - i + 1];
                for (int w = i; w <= j; w++) {
                    list[w - i] = w;
                }
                lists.add(list);
                i++;
            } else if (sum < target) {
                j++;
            } else {
                i++;
            }
        }

        return lists.toArray(new int[lists.size()][]);
    }
}
