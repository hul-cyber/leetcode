package com.zjs.search;

/**
 * @ClassName Exist
 * @Description TODO
 * @Author hul-cyber
 * @Date 2021/3/20 23:23
 * @Version 1.0
 */
public class Exist {
    private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        boolean[][] ismarked = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(i, j, board, ismarked, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 返回从坐标(i, j)开始寻找，是否能够匹配上字符串
    private boolean exist(int i, int j, char[][] board, boolean[][] ismarked, String word) {
        if (word.length() == 0) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(0) ||
                ismarked[i][j]) {
            return false;
        }
        ismarked[i][j] = true;
        for (int[] direction : directions) {
            if (exist(i + direction[0], j + direction[1], board, ismarked, word.substring(1))) {
                return true;
            }
        }
        ismarked[i][j] = false;
        return false;
    }
}
