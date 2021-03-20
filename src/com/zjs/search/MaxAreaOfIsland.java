package com.zjs.search;

/**
 * @ClassName MaxAreaOfIsland
 * @Description 695. 岛屿的最大面积 题目链接: https://leetcode-cn.com/problems/max-area-of-island/description/
 * DFS
 * @Author hul-cyber
 * @Date 2021/3/17 22:07
 * @Version 1.0
 */
public class MaxAreaOfIsland {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int max = 0;
        int u = grid.length;
        int v = grid[0].length;
        boolean[][] marked = new boolean[u][v];
        for (int i = 0; i < u; i++) {
            for (int j = 0; j < v; j++) {
                int area = dfs(marked, grid, i, j);
                max = Math.max(area, max);
            }
        }
        return max;
    }

    private static int dfs(boolean[][] marked, int[][] grid, int i, int j) {
        int area = 0;
        if (grid[i][j] == 0 || marked[i][j] == true) {
            return area;
        }
        area++;
        marked[i][j] = true;
        // 深度遍历四个方向
        for (int m = 0; m < 4; m++) {
            int nextX = i + dirs[m][0];
            int nextY = j + dirs[m][1];
            if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length || marked[nextX][nextY] || grid[nextX][nextY] == 0) {
                continue;
            }
            area += dfs(marked, grid, nextX, nextY);
        }
        return area;
    }
}
