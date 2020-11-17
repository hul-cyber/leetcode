package com.zjs;

/**
 * @ClassName SumNums1
 * @Description 剑指Offer 64 求1 + 2 + ... + n,题目链接: https://leetcode-cn.com/problems/qiu-12n-lcof/
 * 递归 + 逻辑符短路
 * @Author zhangjusheng
 * @Date 2020/11/17 22:39
 * @Version 1.0
 */
public class SumNums1 {
    /*// 使用短路与
    public int sumNums(int n) {
        boolean flag = n > 1 && (n += sumNums(n - 1)) > 1;
        return n;
    }*/

    /*// 使用短路或
    public int sumNums(int n) {
        boolean flag = n < 1 || (n += sumNums(n - 1)) > 1;
        return n;
    }*/
}
