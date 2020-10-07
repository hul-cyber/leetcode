package com.zjs;

/**
 * 打印从1到最大的n位数
 * 暴力法,且不考虑大数的情况
 * 最坏情况下: 时间复杂度:O(最大的n位数) 空间复杂度:O(最大的n位数)
 * 题目链接:https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 */
public class printNumbers {
    public static void main(String[] args) {
        char[] a = "abcd".toCharArray();
        System.out.println(a.length);

    }

    public static int[] printNumbers(int n) {
        int[] numbers = new int[n];
        int number = 1;
        int i = 0;
        while (i++ < n)
            number *= 10;
        for (int j = 1; j < number; j++) {
            numbers[j - 1] = j;
        }
        return numbers;
    }

    public static int getMaxN(int n) {
        if (n == 1)
            return 10;
        int result = getMaxN(n >> 1);
        result = result * result;
        if ((n & 1) == 0)
            return result;
        return result * 10;
    }
}
