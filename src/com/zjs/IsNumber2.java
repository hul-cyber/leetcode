package com.zjs;

/**
 * @ClassName IsNumber2
 * @Description 剑指Offer:表示数值的字符串 题目链接: https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/ 做法:没有技巧
 * @Author zhangjusheng
 * @Date 2020/10/9 11:31
 * @Version 1.0
 **/
public class IsNumber2 {
    public static void main(String[] args) {
        IsNumber2 isNumber2 = new IsNumber2();
        String s = "0";
        System.out.println(isNumber2.isNumeric(s));
    }

    int index = 0;

    boolean isNumeric(String s) {
        if (s == null)
            return false;

        while (index < s.length() && (s.charAt(index) == ' '))
            index++;

        boolean numeric = scanInteger(s);

        if (index < s.length() && s.charAt(index) == '.') {
            index++;
            numeric = scanUnsignedInteger(s) || numeric;
        }

        if (index < s.length() && (s.charAt(index) == 'e' || s.charAt(index) == 'E')) {
            index++;
            numeric = numeric && scanInteger(s);
        }

        while (index < s.length() && s.charAt(index) == ' ')
            index++;

        return numeric && index == s.length();
    }

    private boolean scanInteger(String s) {
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-'))
            index++;
        return scanUnsignedInteger(s);
    }

    private boolean scanUnsignedInteger(String s) {
        int before = index;
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9')
            index++;
        return index > before;
    }
}
