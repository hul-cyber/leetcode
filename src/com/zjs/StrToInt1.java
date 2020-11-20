package com.zjs;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName StrToInt1
 * @Description 剑指Offer 67 把字符串转换成整数 题目链接:https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 * 暴力法
 * @Author zhangjusheng
 * @Date 2020/11/20 10:42
 * @Version 1.0
 */
public class StrToInt1 {
    public int strToInt(String str) {
        if (str == null || str.length() == 0)
            return 0;
        // 暂时使用long来存储结果
        long res = 0;
        List<Character> list = new ArrayList<>();
        str = str.trim();
        if (str.length() == 0)
            return 0;
        if (str.charAt(0) != '+' && str.charAt(0) != '-' && str.charAt(0) < '0' && str.charAt(0) > '9')
            return 0;
        // 记录是正数还是负数
        boolean isNegative = false;
        if (str.charAt(0) == '-')
            isNegative = true;
        // 将字符存储到字符列表
        int index = 0;
        if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-'))
            index++;
        while (index < str.length() && str.charAt(index) == '0')
            index++;
        while (index < str.length()) {
            char temp = str.charAt(index);
            if (temp >= '0' && temp <= '9') {
                list.add(temp);
                index++;
            } else {
                break;
            }
        }

        // 累计每个数位index
        int size = list.size();
        if (size > 10) {
            if (isNegative == false)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }
        for (int i = size - 1; i > -1; i--) {
            res += power(size - 1 - i) * (list.get(i) - '0');
            if (isNegative == false && res >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (isNegative == true && res > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        if (isNegative == true)
            return (int) res * (-1);
        return (int) res;
    }

    public long power(int n) {
        long res = 1;
        for (int i = 0; i < n; i++) {
            res *= 10;
        }
        return res;
    }
}