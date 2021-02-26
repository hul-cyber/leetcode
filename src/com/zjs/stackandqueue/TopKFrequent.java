package com.zjs.stackandqueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName TopKFrequent
 * @Description 347. 前K个高频元素 题目链接: https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 优先队列
 * @Author hul-cyber
 * @Date 2021/2/26 11:03
 * @Version 1.0
 */
public class TopKFrequent {

    private class Element {
        int val;
        int freq;

        public Element(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, -1) + 1);
        }
        Element[] elements = new Element[freq.size()];
        int index = 0;
        for (int key : freq.keySet()) {
            elements[index++] = new Element(key, freq.get(key));
        }
        Queue<Element> minHeap = new PriorityQueue<>(k, (o1, o2) -> o1.freq - o2.freq);
        for (int i = 0; i < k; i++) {
            minHeap.offer(elements[i]);
        }
        for (int i = k; i < elements.length; i++) {
            Element element = minHeap.peek();
            if (element.freq < elements[i].freq) {
                minHeap.poll();
                minHeap.offer(elements[i]);
            }
        }
        int[] result = new int[k];
        index = 0;
        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll().val;
        }
        return result;
    }
}
