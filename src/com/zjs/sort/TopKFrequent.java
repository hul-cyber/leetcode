package com.zjs.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TopKFrequent
 * @Description 347 前K个高频元素 题目链接: https://leetcode-cn.com/problems/top-k-frequent-elements/description/
 * 桶排序
 * @Author zhangjusheng
 * @Date 2020/11/28 19:12
 * @Version 1.0
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        // 数字出现的频率
        Map<Integer, Integer> frequencyForNum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            frequencyForNum.put(nums[i], frequencyForNum.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (Integer key : frequencyForNum.keySet()) {
            // 获取该数字出现的频率
            Integer frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        // 从所有的桶中取出所有的元素
        for (int i = nums.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                if (topK.size() + buckets[i].size() <= k) {
                    topK.addAll(buckets[i]);
                }
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = topK.get(i);
        }
        return res;
    }
}
