package com.zjs.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName PacificAtlantic
 * @Description 417. 太平洋大西洋水流问题 题目链接: https://leetcode-cn.com/problems/pacific-atlantic-water-flow/
 * DFS
 * @Author hul-cyber
 * @Date 2021/3/18 22:27
 * @Version 1.0
 */
public class PacificAtlantic {

    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m;
    private int n;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            dfs(0, i, canReachP, matrix);
            dfs(m - 1, i, canReachA, matrix);
        }
        for (int j = 0; j < m; j++) {
            dfs(j, 0, canReachP, matrix);
            dfs(j, n - 1, canReachA, matrix);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachA[i][j] && canReachP[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    public void dfs(int r, int c, boolean[][] canReach, int[][] matrix) {
        if (canReach[r][c]) {
            return;
        }
        canReach[r][c] = true;
        for (int[] d : direction) {
            int nextR = r + d[0];
            int nextC = c + d[1];
            if (nextC < 0 || nextR < 0 || nextR >= m || nextC >= n || matrix[nextR][nextC] < matrix[r][c] ||
                    canReach[nextR][nextC]) {
                continue;
            }
            dfs(nextR, nextC, canReach, matrix);
        }
    }
}
