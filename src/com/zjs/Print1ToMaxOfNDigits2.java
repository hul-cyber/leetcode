package com.zjs;

/**
 * 打印从1到最大的n位数
 * 考虑大数的情况,并且将其作为全排列问题,用递归解决
 * 最坏情况下: 时间复杂度:O(10^n) 空间复杂度:O(n) 注:用max表示最大的n位数
 * 题目链接:https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class Print1ToMaxOfNDigits2 {
    public static void main(String[] args) {
        Print1ToMaxOfNDigits2 p = new Print1ToMaxOfNDigits2();
        p.print1ToMaxOfNDigits(3);
    }

    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        int[] number = new int[n];
        chooseNext(0, number, n);
    }

    public void chooseNext(int nextDigit, int[] number, int n) {
        for (int i = 0; i <= 9; i++) {
            number[nextDigit] = i;
            if(nextDigit == n - 1) {
                printNumber(number);
            } else {
                chooseNext(nextDigit + 1, number, n);
            }
        }
    }

    public void printNumber(int[] number) {
        boolean isBeginning0 = true;
        for (int j = 0; j < number.length; j++) {
            if (isBeginning0 && number[j] != 0)
                isBeginning0 = false;
            if (!isBeginning0)
                System.out.print(number[j]);
        }
        if (!isBeginning0)
            System.out.println();
    }
}