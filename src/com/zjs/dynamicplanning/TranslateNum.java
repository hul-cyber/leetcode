package com.zjs.dynamicplanning;

/**
 * @ClassName TranslateNum
 * @Description 剑指Offer 46 把数字翻译成字符串 题目链接: https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 * 动态规划
 * @Author hul-cyber
 * @Date 2021/3/10 0:06
 * @Version 1.0
 */
public class TranslateNum {
    public int translateNum(int num) {
        // 将数字转化为字符串
        String s = String.valueOf(num);
        int len = s.length();
        int res = 1;
        int a = 1;
        int b = 1;
        for (int i = 2; i <= len; i++) {
            String tmp = s.substring(i - 2, i);
            res = (tmp.compareTo("10") >= 0 && tmp.compareTo("25") <= 0) ? a + b : b;
            a = b;
            b = res;
        }
        return res;
    }
}
