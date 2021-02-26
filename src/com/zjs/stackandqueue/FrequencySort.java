package com.zjs.stackandqueue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName FrequencySort
 * @Description 451. 根据字符出现频率排序 题目链接: https://leetcode-cn.com/problems/sort-characters-by-frequency/
 * 优先队列
 * @Author hul-cyber
 * @Date 2021/2/26 14:52
 * @Version 1.0
 */
public class FrequencySort {
    public String frequencySort(String s) {
        int[] frequency = new int[128];
        Queue<Character> maxHeap = new PriorityQueue<>((o1, o2) -> frequency[o2] - frequency[o1]);
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            frequency[c]++;
        }
        for (int i = 0; i < 128; i++) {
            if (frequency[i] != 0) {
                maxHeap.offer((char) i);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            while (frequency[ch] > 0) {
                result.append(ch);
                frequency[ch]--;
            }
        }
        return result.toString();
    }
}
