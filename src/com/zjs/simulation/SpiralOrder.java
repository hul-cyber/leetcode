package com.zjs.simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SpiralOrder
 * @Description 54 螺旋矩阵 题目链接: https://leetcode-cn.com/problems/spiral-matrix/
 * 模拟题
 * @Author zhangjusheng
 * @Date 2020/12/30 0:10
 * @Version 1.0
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return null;
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1, x = 0;
        List<Integer> res = new ArrayList<>((r + 1) * (b + 1));
        while (true) {
            for (int i = l; i <= r; i++)
                res.add(matrix[t][i]);
            if (++t > b)
                break;
            for (int i = t; i <= b; i++)
                res.add(matrix[i][r]);
            if (--r < l)
                break;
            for (int i = r; i >= l; i--)
                res.add(matrix[b][i]);
            if (--b < t)
                break;
            for (int i = b; i >= t; i--)
                res.add(matrix[i][l]);
            if (++l > r)
                break;
        }
        return res;
    }

}
