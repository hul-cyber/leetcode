package com.zjs;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FindContinuousSequence1
 * @Description 剑指Offer 57-II 和为s的连续正数序列 题目链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/
 * 暴力法 + 枚举
 * @Author zhangjusheng
 * @Date 2020/11/8 22:51
 * @Version 1.0
 **/
public class FindContinuousSequence1 {

    public int[][] findContinuousSequence(int target) {
        List<int[]> lists = new ArrayList<>();

        int sum = 0;

        for (int i = 1; i <= target / 2; i++) {
            for (int j = i; ; j++) {
                sum += j;
                if (sum == target) {
                    int[] list = new int[j - i + 1];
                    int index = 0;

                    for (int w = i; w <= j; w++) {
                        list[index++] = w;
                    }

                    lists.add(list);
                    sum = 0;
                    break;
                } else if (sum > target) {
                    sum = 0;
                    break;
                }
            }
        }

        return lists.toArray(new int[lists.size()][]);
    }
}
