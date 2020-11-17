package com.zjs;

/**
 * @ClassName SumNums2
 * @Description 剑指Offer 64 求1 + 2 + ... + n,题目链接: https://leetcode-cn.com/problems/qiu-12n-lcof/
 * 位运算
 * @Author zhangjusheng
 * @Date 2020/11/17 22:41
 * @Version 1.0
 */
public class SumNums2 {
    public int sumNums(int n) {
        int ans = 0;
        boolean flag;
        int a = n + 1, b = n;
        //1
        flag = (a & 1) == 0 || (ans += b) > 0;
        a >>= 1;
        b <<= 1;
        //2
        flag = (a & 1) == 0 || (ans += b) > 0;
        a >>= 1;
        b <<= 1;
        //3
        flag = (a & 1) == 0 || (ans += b) > 0;
        a >>= 1;
        b <<= 1;
        //4
        flag = (a & 1) == 0 || (ans += b) > 0;
        a >>= 1;
        b <<= 1;
        //5
        flag = (a & 1) == 0 || (ans += b) > 0;
        a >>= 1;
        b <<= 1;
        //6
        flag = (a & 1) == 0 || (ans += b) > 0;
        a >>= 1;
        b <<= 1;
        //7
        flag = (a & 1) == 0 || (ans += b) > 0;
        a >>= 1;
        b <<= 1;
        //8
        flag = (a & 1) == 0 || (ans += b) > 0;
        a >>= 1;
        b <<= 1;
        //9
        flag = (a & 1) == 0 || (ans += b) > 0;
        a >>= 1;
        b <<= 1;
        //10
        flag = (a & 1) == 0 || (ans += b) > 0;
        a >>= 1;
        b <<= 1;
        //11
        flag = (a & 1) == 0 || (ans += b) > 0;
        a >>= 1;
        b <<= 1;
        //12
        flag = (a & 1) == 0 || (ans += b) > 0;
        a >>= 1;
        b <<= 1;
        //13
        flag = (a & 1) == 0 || (ans += b) > 0;
        a >>= 1;
        b <<= 1;
        //14
        flag = (a & 1) == 0 || (ans += b) > 0;
        a >>= 1;
        b <<= 1;

        return ans >> 1;
    }
}
