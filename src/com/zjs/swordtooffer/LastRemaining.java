package com.zjs.swordtooffer;

/**
 * @ClassName LastRemaining
 * @Description 剑指Offer 62 题目链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 * 迭代 + 数学
 * @Author zhangjusheng
 * @Date 2020/11/17 14:49
 * @Version 1.0
 */
public class LastRemaining {
    public int lastRemaining (int n, int m) {
        if (n < 1 || m < 1)
            return -1;

        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (m + last) % i;
        }
        return last;
    }
}
