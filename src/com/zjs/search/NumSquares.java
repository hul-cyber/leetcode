package com.zjs.search;

import java.util.*;

/**
 * @ClassName NumSquares
 * @Description 279. 完全平方数 题目链接: https://leetcode-cn.com/problems/perfect-squares/
 * BFS
 * @Author hul-cyber
 * @Date 2021/3/17 21:15
 * @Version 1.0
 */
public class NumSquares {
    public int numSquares(int n) {
        boolean[] marked = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(0);
        int res = 0;
        List<Integer> squares = generateSquares(n);
        while (queue.size() > 0) {
            int size = queue.size();
            res++;
            while (size-- > 0) {
                int num = queue.poll();
                for (int i = 0; i < squares.size(); i++) {
                    int nextNum = num + squares.get(i);
                    if (nextNum == n) {
                        return res;
                    } else if (nextNum > n) {
                        break;
                    } else {
                        if (marked[nextNum]) {
                            continue;
                        }
                        marked[nextNum] = true;
                        queue.offer(nextNum);
                    }
                }
            }
        }
        return -1;
    }

    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }
}
