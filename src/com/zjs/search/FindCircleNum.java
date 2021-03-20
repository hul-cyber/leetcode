package com.zjs.search;

/**
 * @ClassName FindCircleNum
 * @Description 547.省份数量 题目链接: https://leetcode-cn.com/problems/number-of-provinces/
 * DFS
 * @Author hul-cyber
 * @Date 2021/3/17 23:35
 * @Version 1.0
 */
public class FindCircleNum {
    public int findCircleNum(int[][] isConnected) {
        int num = 0;
        boolean[] marked = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!marked[i]) {
                marked[i] = true;
                dfs(isConnected, marked, i);
                num++;
            }
        }
        return num;
    }

    private void dfs(int[][] isConnected, boolean[] marked, int i) {
        for (int j = 0; j < isConnected[i].length; j++) {
            if (isConnected[i][j] == 1 && !marked[j]) {
                marked[j] = true;
                dfs(isConnected, marked, j);
            }
        }
    }
}
