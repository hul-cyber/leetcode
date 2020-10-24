package com.zjs;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName TopK4
 * @Description 剑指Offer 40 最小的k个数 题目链接: https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * 使用大根堆
 * @Author zhangjusheng
 * @Date 2020/10/23 21:49
 * @Version 1.0
 **/
public class TopK4 {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 2, 0, 5};
        int[] leastNumbers = getLeastNumbers(arr, 0);
        for (int i = 0; i < 2; i++) {
            System.out.println(leastNumbers[i]);
        }
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                //降序
                return o2 - o1;
            }
        });

        for (int a : arr) {
            if (pq.size() < k)
                pq.offer(a);
            else {
                if (pq.peek() > a) {
                    pq.poll();
                    pq.offer(a);
                }
            }
        }

        int[] leastNumbers = new int[k];
        int j;
        for (int i = 0; i < k; i++) {
            j = pq.poll();
            leastNumbers[i] = j;
        }

        return leastNumbers;
    }
}
