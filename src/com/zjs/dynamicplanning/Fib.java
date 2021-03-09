package com.zjs.dynamicplanning;

import java.util.Arrays;

/**
 * @ClassName Fib
 * @Description 509. 斐波那契数 题目链接: https://leetcode-cn.com/problems/fibonacci-number/
 * 动态规划
 * @Author hul-cyber
 * @Date 2021/3/9 16:48
 * @Version 1.0
 */
public class Fib {
    public static int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fib(n, memo);
    }

    public static int fib(int n, int[] memo) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (memo[n] == -1) {
            memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        }
        return memo[n];
    }
}
