package com.zjs.greedyalgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PartitionLabels2
 * @Description 763 划分字母区间 题目链接: https://leetcode-cn.com/problems/partition-labels/
 * 代码简洁的贪心策略
 * @Author zhangjusheng
 * @Date 2020/12/6 9:33
 * @Version 1.0
 */
public class PartitionLabels2 {

    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        // 使用一个数组来记录元素的最终位置
        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndex[S.charAt(i) - 'a'] = i;
        }
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, lastIndex[S.charAt(i) - 'a']);
            if (end == i) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }
}
