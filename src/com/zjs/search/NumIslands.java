package com.zjs.search;

/**
 * @ClassName NumIslands
 * @Description 200. 岛屿数量 题目链接: https://leetcode-cn.com/problems/number-of-islands/
 * DFS
 * @Author hul-cyber
 * @Date 2021/3/17 23:03
 * @Version 1.0
 */
public class NumIslands {
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        int islandsNum = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != '0') {
                    islandsNum++;
                    dfs(grid, i, j);
                }
            }
        }
        return islandsNum;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int[] d : dirs) {
            dfs(grid, i + d[0], j + d[1]);
        }
    }
}
