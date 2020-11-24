package com.zjs.swordtooffer;

/**
 * @ClassName SpiralOrder2
 * @Description 剑指Offer29 顺时针打印矩阵 题目链接:https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * 模拟
 * @Author zhangjusheng
 * @Date 2020/10/12 14:31
 * @Version 1.0
 **/
public class SpiralOrder2 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[0];

        int rows = matrix.length, columns = matrix[0].length;
        int total = rows * columns;
        boolean[][] visited = new boolean[rows][columns];
        int[] order = new int[total];
        int row = 0, column = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;

        for (int i = 0; i < total; i++) {
            order[i] = matrix[row][column];
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow == rows || nextColumn < 0 || nextColumn == columns || visited[nextRow][nextColumn])
                directionIndex = (directionIndex + 1) % 4;
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }

        return order;
    }
}
