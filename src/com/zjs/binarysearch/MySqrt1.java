package com.zjs.binarysearch;

/**
 * @ClassName MySqrt1
 * @Description 68. x的平方根 题目链接: https://leetcode-cn.com/problems/sqrtx/
 * 二分查找
 * @Author zhangjusheng
 * @Date 2020/12/7 16:55
 * @Version 1.0
 */
public class MySqrt1 {

    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int result = 0;
        int left = 0, right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            int sqrt = x / mid;
            if (mid == sqrt) {
                return mid;
            } else if (mid > sqrt) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
