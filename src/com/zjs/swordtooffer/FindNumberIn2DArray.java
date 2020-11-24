package com.zjs.swordtooffer;

import java.io.*;

public class FindNumberIn2DArray {
    public static void main(String[] args) throws IOException {
        int[][] matrix = { {1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30} };
        System.out.println(findNumberIn2DArray3(matrix, 5));
    }

    public static boolean findNumberIn2DArray1() {
        //暴力法O(n^2)
        return true;
    }

    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        //时间复杂度O(nlog2n)
        for(int i = 0; i < matrix.length; i++) {
            int start = 0;
            int end = matrix[i].length - 1;
            int mid = (start + end) / 2;
            int midNum = matrix[i][mid];
            while (midNum != target && start < end) {
                if(midNum > target)
                    end = mid - 1;
                else
                    start = mid + 1;
                mid = (start + end) / 2;
                midNum = matrix[i][mid];
            }
            if(midNum == target) {
                return true;
            }
        }
        return false;
    }

    public static boolean findNumberIn2DArray3(int[][] matrix, int target) {
        //时间复杂度: O(n)
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //开始判断的元素的下标
        int row = 0;
        int column = matrix[0].length - 1;
        //二维数组中还有元素待查找
        while(row < matrix.length && column > -1) {
            int topRight = matrix[row][column];
            //如果右上角的元素等于目标值时
            if(topRight == target) {
                return true;
            }
            //当右上角的元素大于目标值时,右上角元素所在的这一列就不需要查找了
            else if(topRight > target)
                column--;
                //当右上角的元素小于目标值时,右上角元素所在的这一行就不需要查找了
            else
                row++;
        }
        return false;
    }
}