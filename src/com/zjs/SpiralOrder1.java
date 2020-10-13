package com.zjs;

/**
 * @ClassName SpiralOrder1
 * @Description 剑指Offer29 顺时针打印矩阵 题目链接:https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * 使用暴力模拟,最坏情况下: 时间复杂度O(n)  空间复杂度O(1)(如果返回的存储结果的数组不计入的话) n为矩阵中元素个数
 * @Author zhangjusheng
 * @Date 2020/10/12 13:24
 * @Version 1.0
 **/
public class SpiralOrder1 {
    static int curNum = 0;

    public static void main(String[] args) {
        int[][] matrix = null;
        if (matrix == null) {
            System.out.println("ggg");
            return;
        }
        if (matrix.length == 0) {
            System.out.println("hhh");
            return;
        }
        if (matrix[0].length == 0) {
            System.out.println("kkk");
            return;
        }
        //spiralOrder(matrix);
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return null;

        int num = matrix.length * matrix[0].length;
        int[] newArray = new int[num];

        int startX = 0, startY = 0;
        int orderRightX = matrix.length;
        int orderDownY = matrix[0].length;
        int orderLeftX = -1;
        int orderUpY = -1;

        while (curNum < num) {
            TraverseLoop(startX, startY, orderLeftX, orderRightX, orderUpY, orderDownY, matrix, newArray, num);
            startX++;
            startY++;
            orderRightX--;
            orderLeftX++;
            orderUpY++;
            orderDownY--;
        }

        return newArray;
    }

    static void TraverseLoop(int startX, int startY, int orderLeftX, int orderRightX, int orderUpY, int orderDownY, int[][] oldArray, int[] newArray, int num) {
        int direction = 0;
        int x = startX;
        int y = startY;
        while (direction < 4) {
            while (x < orderRightX && x > orderLeftX && y < orderDownY && y > orderUpY) {
                newArray[curNum] = oldArray[x][y];
                curNum++;
                if (direction == 0)
                    y++;
                if (direction == 1)
                    x++;
                if (direction == 2)
                    y--;
                if (direction == 3)
                    x--;
                if (x == startX && y == startY) {
                    break;
                }
            }
            if (x == orderRightX) {
                direction++;
                x--;
                y--;
            }
            if (x == orderLeftX) {
                direction++;
                x++;
                y--;
            }
            if (y == orderDownY) {
                direction++;
                y--;
                x++;
            }
            if (y == orderUpY) {
                direction++;
                y++;
                x--;
            }
            if (x == startY && y == startY)
                break;
        }
    }
}
