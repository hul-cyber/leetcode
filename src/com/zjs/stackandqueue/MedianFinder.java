package com.zjs.stackandqueue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName MedianFinder
 * @Description 295. 数据流的中位数 题目链接: https://leetcode-cn.com/problems/find-median-from-data-stream/
 * 优先级队列
 * @Author hul-cyber
 * @Date 2021/2/26 14:45
 * @Version 1.0
 */
public class MedianFinder {

    // 左半部分
    private Queue<Integer> leftHalf;
    // 右半部分
    private Queue<Integer> rightHalf;

    /** initialize your data structure here. */
    public MedianFinder() {
        // 左半部分是大根堆
        leftHalf = new PriorityQueue<>((o1, o2) -> o2 - o1);
        // 右半部分是小根堆
        rightHalf = new PriorityQueue<>((o1, o2) -> o1 - o2);
    }

    public void addNum(int num) {
        leftHalf.offer(num);
        rightHalf.offer(leftHalf.poll());
        if (rightHalf.size() > leftHalf.size()) {
            leftHalf.offer(rightHalf.poll());
        }
    }

    public double findMedian() {
        if (leftHalf.size() == rightHalf.size()) {
            return (leftHalf.peek() + rightHalf.peek()) / 2.0;
        } else {
            return leftHalf.peek();
        }
    }
}
