package com.zjs.swordtooffer;

import java.util.Arrays;

/**
 * 打印从1到最大的n位数
 * 考虑大数的情况,用字符数组或者int数组来表示
 * 最坏情况下: 时间复杂度:O(max*n) 空间复杂度:O(n) 注:用max表示最大的n位数
 * 题目链接:https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class Print1ToMaxOfNDigits1 {
    public static void main(String[] args) {
        Print1ToMaxOfNDigits1 p = new Print1ToMaxOfNDigits1();
        p.print1ToMaxOfNDigits(3);
    }

    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        int[] number = new int[n];
        Arrays.fill(number, 0);
        while (!overMax(number)) {
            printNumber(number);
        }
    }

    private void printNumber(int[] number) {
        boolean isBeginningZero = true;
        for (int i = 0; i < number.length; i++) {
            if (isBeginningZero == true && number[i] != 0)
                isBeginningZero = false;
            if (isBeginningZero == false)
                System.out.print(number[i]);
        }
        System.out.println();
    }

    public boolean overMax(int[] number) {
        boolean ifOverMax = false;
        int advance = 0;
        int length = number.length;
        for(int i = length - 1; i >= 0; i--) {
            number[i] += advance;
            if (i == length - 1)
                number[i]++;
            if (number[i] >= 10) {
                if (i == 0)
                    ifOverMax = true;
                advance = 1;
                number[i]-=10;
            } else {
                break;
            }
        }
        return ifOverMax;
    }
}