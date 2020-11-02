package com.zjs;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName MedianFinder
 * @Description TODO
 * @Author zhangjusheng
 * @Date 2020/10/24 23:29
 * @Version 1.0
 **/
public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(-1);
        mf.addNum(-2);
        mf.addNum(-3);
        System.out.println(mf.findMedian());
    }

    Queue<Integer> queue;
    /** initialize your data structure here. */
    public MedianFinder() {
        queue = new PriorityQueue<>();
    }

    public void addNum(int num) {
        queue.offer(num);
    }

    public double findMedian() {
        if (queue.size() % 2 == 0) {
            //如果是偶数
            int sum = 0;
            int index = 0;
            for (Integer i : queue) {
                if (index == queue.size() / 2) {
                    sum += i;
                }
                if (index == queue.size() / 2 - 1) {
                    sum += i;
                }
                index++;
            }
            return sum / 2.0;
        } else {
            //如果是奇数
            int median = 0;
            int index = 0;
            for (Integer i : queue) {
                if (index == queue.size() / 2) {
                    median += i;
                }
                index++;
            }
            return median;
        }
    }
}
