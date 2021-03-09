package com.zjs.dynamicplanning;

/**
 * @ClassName ClimbStairs
 * @Description 70. 爬楼梯 题目链接: https://leetcode-cn.com/problems/climbing-stairs/
 * 动态规划
 * @Author hul-cyber
 * @Date 2021/3/10 0:08
 * @Version 1.0
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        int p = 1;
        int q = 1;
        for (int i = 2; i <= n; i++) {
            int temp = q;
            q = p + q;
            p = temp;
        }
        return q;
    }
}
