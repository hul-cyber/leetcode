package com.zjs.search;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName ShortestPathBinaryMatrix
 * @Description 1091. 二进制矩阵中的最短路径 题目链接: https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
 * BFS
 * @Author hul-cyber
 * @Date 2021/3/17 18:14
 * @Version 1.0
 */
public class ShortestPathBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int[][] pos = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0},
                {1, 1}};
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1)
            return -1;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        int pathLength = 0;
        while (queue.size() != 0) {
            // 扫描8个方向
            pathLength++;
            int size = queue.size();
            while (size-- > 0) {
                Pair<Integer, Integer> pair = queue.poll();
                int x = pair.getKey();
                int y = pair.getValue();
                grid[x][y] = 1;
                if (x == grid.length - 1 && y == grid.length - 1) {
                    return pathLength;
                }
                for (int[] d : pos) {
                    int nextX = x + d[0];
                    int nextY = y + d[1];
                    if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid.length || grid[nextX][nextY] == 1) {
                        continue;
                    }
                    queue.add(new Pair<>(nextX, nextY));
                }
            }
        }
        return -1;
    }
}
