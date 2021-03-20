package com.zjs.search;

import java.util.Arrays;

/**
 * @ClassName Solve
 * @Description 130.被围绕的区域 题目链接: https://leetcode-cn.com/problems/surrounded-regions/
 * DFS
 * @Author hul-cyber
 * @Date 2021/3/18 21:16
 * @Version 1.0
 */
public class Solve {

    private int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        // 从外围开始深度优先遍历
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'T';
        for (int[] d : dirs) {
            int nextX = x + d[0];
            int nextY = y + d[1];
            dfs(board, nextX, nextY);
        }
    }
}
