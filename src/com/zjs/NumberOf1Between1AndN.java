package com.zjs;

/**
 * @ClassName NumberOf1Between1AndN
 * @Description 剑指Offer 43 1 ~ n整数中1出现的次数 题目链接:https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
 * 寻找数字规律
 * @Author zhangjusheng
 * @Date 2020/10/26 11:53
 * @Version 1.0
 **/
public class NumberOf1Between1AndN {
    public static void main(String[] args) {
        NumberOf1Between1AndN numberOf1Between1AndN = new NumberOf1Between1AndN();
        System.out.println(numberOf1Between1AndN.countDigitOne(110));
    }

    public int countDigitOne(int n) {
        if (n <= 0)
            return 0;

        //将数字转化为字符串
        String nStr = String.valueOf(n);

        return numberOf1(nStr, nStr.length() - 1);
    }

    int numberOf1(String nStr, int index) {
        if (index < 0) {
            return 0;
        }
        //首先判断是不是只剩下一位
        int cur = nStr.length() - 1 - index;
        int first = nStr.charAt(cur) - '0';
        if (index == 0 && first == 0)
            return 0;

        if (index == 0 && first > 0)
            return 1;

        //求解最高位1的数量
        int numFirstDigit = 0;
        if (first > 1) {
            numFirstDigit = powerBase10(index);
        } else if (first == 1) {
            numFirstDigit = (Integer.parseInt(nStr.substring(cur + 1))) + 1;
        }

        //求解剩下数位中1的数目
        int numOtherDigits = first * index * powerBase10(index - 1);

        int numRecursive = numberOf1(nStr, index - 1);

        return numFirstDigit + numOtherDigits + numRecursive;
    }

    int powerBase10(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }
}
