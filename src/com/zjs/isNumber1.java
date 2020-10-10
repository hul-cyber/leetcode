package com.zjs;

/**
 * @ClassName isNumber1
 * @Description 剑指Offer:表示数值的字符串 题目链接: https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/ 做法: 没有技巧
 * @Author zhangjusheng
 * @Date 2020/10/9 9:08
 * @Version 1.0
 **/
public class isNumber1 {
    public static void main(String[] args) {
        isNumber1 isNumber = new isNumber1();
    }

    public boolean isNumber(String s) {
        if (s == null || s.length() == 0)
            return false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-')
            //将数字变成无符号数
            s = s.substring(1);
        int posOfE = posOfE(s);
        //将字符串分为两部分
        String afterE = s;
        String beforeE = s.substring(0, posOfE);
        if (posOfE < s.length()) {
            //如果存在e或者E
            afterE = afterE.substring(posOfE + 1);
            //将符号去掉
            if (afterE.length() > 0) {
                if (afterE.charAt(0) == '+' || afterE.charAt(0) == '-')
                    //将数字变成无符号数
                    afterE = afterE.substring(1);
            }
            return isUnsignedNumber(beforeE, 0, 0) && isUnsignedNumber(afterE, 1, 1);
        } else {
            return isUnsignedNumber(beforeE, 0, 0);
        }
    }

    public int posOfE(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                return i;
            }
        }
        return s.length();
    }

    public boolean isUnsignedNumber(String number, int numOfPoint, int numOfE) {
        int blankNum = 0;
        if (number.length() == 0)
            return false;
        //判断无符号数
        for (int i = 0; i < number.length(); i++) {
            if (i == 0 || i == (number.length() - 1)) {
                //判断开头和结尾
                if ((number.charAt(i) < '0' || number.charAt(i) > '9') && number.charAt(i) != ' ' && number.charAt(i) != '.') {
                    return false;
                }
                if (number.charAt(i) == ' ') {
                    blankNum++;
                }
                if (number.charAt(i) == '.') {
                    numOfPoint++;
                    blankNum++;
                }
            } else {
                //判断中间
                if ((number.charAt(i) >= '0' && number.charAt(i) <= '9') || (numOfPoint == 0 && number.charAt(i) == '.') || (numOfE == 0 && (number.charAt(i) == 'e' || number.charAt(i) == 'E'))) {
                    if (number.charAt(i) == '.')
                        numOfPoint++;
                } else {
                    return false;
                }
            }
        }
        if (blankNum == number.length()) {
            return false;
        }
        if (numOfPoint > 1) {
            return false;
        }
        return true;
    }
}
