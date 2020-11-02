package com.zjs;

/**
 * @ClassName MaxValue
 * @Description 剑指Offer 47 礼物的最大价值 题目链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * 递归解法
 * @Author zhangjusheng
 * @Date 2020/10/29 10:55
 * @Version 1.0
 **/
public class MaxValue {
    public static void main(String[] args) {
        MaxValue maxValue = new MaxValue();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(maxValue.maxValue(grid));
    }

    public int maxValue(int[][] grid) {
        if (grid == null && grid[0].length == 0)
            return -1;

        return recursive(grid.length, grid[0].length, grid);
    }

    int recursive(int i, int j, int[][] grid) {
        if (i == 0 && j == 0) {
            //如果是左上角元素
            return grid[0][0];
        } else if (i == 0) {
            //如果是第一行的元素,则只能够来自左边
            return recursive(0, j - 1, grid) + grid[0][j];
        } else if (j == 0) {
            //如果是第一列的元素,则只能够来自右边
            return recursive(i - 1, 0, grid) + grid[i][0];
        } else {
            //非第一行非第一列的元素
            return Math.max(recursive(i, j - 1, grid), recursive(i - 1, j, grid)) + grid[i][j];
        }
    }
}
