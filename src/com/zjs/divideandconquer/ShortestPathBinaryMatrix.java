package com.zjs.divideandconquer;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName ShortestPathBinaryMatrix
 * @Description 1091. 二进制矩阵中的最短路径 题目链接: https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
 * 广度优先遍历
 * @Author zhangjusheng
 * @Date 2021/1/12 23:49
 * @Version 1.0
 */
public class ShortestPathBinaryMatrix {

    // 定义8个方向
    private int[][] DIRS = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0},
            {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return -1;

        int m = grid.length - 1;
        int n = grid[0].length - 1;

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        while (!queue.isEmpty()) {
            pathLength++;
            int size = queue.size();
            while (size-- > 0) {
                Pair<Integer, Integer> curPos = queue.poll();
                int cr = curPos.getKey();
                int cc = curPos.getValue();
                if (grid[cr][cc] == 1)
                    continue;
                if (cr == m && cc == n) {
                    return pathLength;
                }
                grid[cr][cc] = 1;
                for (int[] d : DIRS) {
                    int nr = cr + d[0];
                    int nc = cc + d[1];
                    if (nr < 0 || nc < 0 || nr > m || nc > n )
                        continue;
                    queue.add(new Pair<>(nr, nc));
                }
            }
        }
        return -1;
    }
}
