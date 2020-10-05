package com.zjs;

/**
 * 二进制数中1的个数涉及到Java位运算,以及数如何在计算机中怎么存储
 *
 * 题目链接:https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class HammingWeight {
    public static void main(String[] args) {
        System.out.println(hammingWeight2(0b00000000000000000000000000001011));
    }

    //使用向左移位<<
    public static int hammingWeight1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if((flag & n) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }

    //使用无符号向右移位>>
    public static int hammingWeight2(int n) {
        int count = 0;
        int flag = 1;
        while (n != 0) {
            if ((flag & n) != 0)
                count++;
            n = n >>> 1;
        }
        return count;
    }
}
