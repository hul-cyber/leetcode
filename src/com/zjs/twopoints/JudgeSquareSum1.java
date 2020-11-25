package com.zjs.twopoints;

/**
 * @ClassName JudgeSquareSum1
 * @Description 633 平方之和 题目链接: https://leetcode-cn.com/problems/sum-of-square-numbers/description/
 * 双指针 + 大数越界问题
 * @Author zhangjusheng
 * @Date 2020/11/24 23:09
 * @Version 1.0
 */
public class JudgeSquareSum1 {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = c;
        int boudary = (int) Math.sqrt(Integer.MAX_VALUE);
        if (right > boudary) {
            right = boudary;
        }
        while (left <= right) {
            if ((right * right + left * left) == c) {
                return true;
            } else if ((right * right + left * left) < c) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    // 一种优化的思路
//    public boolean judgeSquareSum(int c) {
//        // 左边界
//        int left = 0;
//        // 右边界
//        int right = (int) Math.sqrt(c);
//        while (left <= right) {
//            if (c - right * right == left * left)
//                return true;
//            else if (c - right * right > left * left)
//                left++;
//            else if (c - right * right < left * left)
//                right--;
//        }
//        return false;
//    }
}
