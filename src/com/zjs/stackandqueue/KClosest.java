package com.zjs.stackandqueue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName KClosest
 * @Description 973. 最接近原点的K个点 题目链接: https://leetcode-cn.com/problems/k-closest-points-to-origin/
 * 优先队列
 * @Author hul-cyber
 * @Date 2021/2/26 16:14
 * @Version 1.0
 */
public class KClosest {
    public int[][] kClosest(int[][] points, int K) {
        Queue<Integer> minHeap = new PriorityQueue<>(
                (o1, o2) -> (pow(points[o2][0], points[o2][1]) - pow(points[o1][0], points[o1][1]))
        );
        for (int i = 0; i < K; i++) {
            minHeap.offer(i);
        }
        for (int i = K; i < points.length; i++) {
            if (pow(points[i][0], points[i][1]) < pow(points[minHeap.peek()][0], points[minHeap.peek()][1])) {
                minHeap.poll();
                minHeap.offer(i);
            }
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = points[minHeap.poll()];
        }
        return res;
    }

    private int pow(int m, int n) {
        return (int) (Math.pow(m, 2) + Math.pow(n, 2));
    }
}
