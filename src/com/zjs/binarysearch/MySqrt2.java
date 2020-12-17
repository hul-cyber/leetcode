package com.zjs.binarysearch;

/**
 * @ClassName MySqrt2
 * @Description 68. x的平方根 题目链接: https://leetcode-cn.com/problems/sqrtx/
 * 暴力法
 * @Author zhangjusheng
 * @Date 2020/12/17 20:27
 * @Version 1.0
 */
public class MySqrt2 {

    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        for (int i = 1; i <= x; i++) {
            if (x / i == i) {
                return i;
            } else if (x / i < i) {
                return i - 1;
            }
        }
        throw new IllegalArgumentException("参数出错");
    }
}
