package com.zjs;

/**
 * @ClassName StrToInt2
 * @Description 剑指Offer 67 把字符串转换成整数 题目链接:https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 * 数组越界处理
 * @Author zhangjusheng
 * @Date 2020/11/20 14:57
 * @Version 1.0
 */
public class StrToInt2 {
    public int strToInt(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        int sign = 1, index = 1;
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        if (str.charAt(0) == '-') sign = -1;
        else if (str.charAt(0) != '+') index = 0;
        for (int i = index; i < str.length(); i++) {
            if (str.charAt(i) > '9' || str.charAt(i) < '0') break;
            if (res > bndry || (res == bndry && str.charAt(i) > '7')) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (str.charAt(i) - '0');
        }
        return sign * res;
    }
}
