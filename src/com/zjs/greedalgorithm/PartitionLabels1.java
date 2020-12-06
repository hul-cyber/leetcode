package com.zjs.greedalgorithm;

import java.util.*;

/**
 * @ClassName PartitionLabels1
 * @Description 763 划分字母区间 题目链接: https://leetcode-cn.com/problems/partition-labels/
 * 使用map来实现的贪心策略,代码不够简洁
 * @Author zhangjusheng
 * @Date 2020/12/6 0:20
 * @Version 1.0
 */
public class PartitionLabels1 {

    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> map1 = new HashMap<>();
        // 记录每个元素的开始和结束位置
        Map<Integer, Integer> map2 = new TreeMap<>();
        for (int i = 0; i < S.length(); i++) {
            if (map1.get(S.charAt(i)) == null) {
                map1.put(S.charAt(i), i);
            }
            map2.put(map1.getOrDefault(S.charAt(i), i), i);
        }
        // 遍历map2
        int start = 0;
        int end = 0;
        for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
            if (entry.getKey() <= end) {
                // 如果有重叠的部分
                end = Math.max(end, entry.getValue());
            } else {
                // 如果没有重叠的部分
                result.add(end - start + 1);
                start = entry.getKey();
                end = entry.getValue();
            }
        }
        result.add(end - start + 1);
        return result;
    }
}
