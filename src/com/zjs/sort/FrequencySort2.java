package com.zjs.sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName FrequencySort2
 * @Description 451. 根据字符出现频率排序 题目链接: https://leetcode-cn.com/problems/sort-characters-by-frequency/
 * 桶排序
 * @Author zhangjusheng
 * @Date 2020/11/29 0:06
 * @Version 1.0
 */
public class FrequencySort2 {

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Character>[] buckets = new ArrayList[s.length() + 1];
        for (Character key : map.keySet()) {
            Integer frequency = map.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i > 0; i--) {
            if (buckets[i] != null) {
                int index = i;
                for (char c : buckets[i]) {
                    for (int j = 0; j < index; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
