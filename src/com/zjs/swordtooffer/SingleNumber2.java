package com.zjs.swordtooffer;

/**
 * @ClassName SingleNumber2
 * @Description 剑指Offer 56 - II 数组中数字出现的次数 II 题目链接: https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/
 * 位运算
 * @Author zhangjusheng
 * @Date 2020/11/4 10:38
 * @Version 1.0
 **/
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;

        int res = 0;
        int[] bits = new int[32];

        int curBit = 0;
        for (int i = 0; i < nums.length; i++) {
            int bitMask = 1;
            for (int j = 0; j < 32; j++) {
                //跟1取并运算可以将其取下来
                curBit = nums[i] & bitMask;
                if (curBit != 0)
                    bits[j]++;

                bitMask <<= 1;
            }
        }

        for (int i = 31; i >= 0; i--) {
            res <<= 1;
            if (bits[i] % 3 == 1) {
                res += 1;
            }
        }

        return res;
    }
}
