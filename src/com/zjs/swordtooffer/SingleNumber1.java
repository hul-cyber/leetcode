package com.zjs.swordtooffer;

/**
 * @ClassName SingleNumber1
 * @Description 剑指Offer 56-1 数组中数字出现的次数 题目链接: https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/
 * 分组异或
 * @Author zhangjusheng
 * @Date 2020/11/3 20:19
 * @Version 1.0
 **/
public class SingleNumber1 {
    public int[] singleNumbers(int[] nums) {
        int division = 0;
        for (int i = 0; i < nums.length; i++) {
            division ^= nums[i];
        }

        int distinction = findFirstBitIs1(division);

        //将两个不相同的数字划分到两个子数组
        int i = 0;
        int j = nums.length - 1;
        int temp = 0;

        int[] result = new int[2];

        for (int k = 0; k < nums.length; k++) {
            if (isBit1(nums[k], distinction)) {
                result[0] ^= nums[k];
            } else {
                result[1] ^= nums[k];
            }
        }
        return result;
    }

    public boolean isBit1(int n, int distinction) {
        n >>= distinction;
        return (n & 1) == 1;
    }

    public int findFirstBitIs1(int n) {
        int index = 0;
        while ((n & 1) != 1) {
            index++;
            //将n向右移
            n >>= 1;
        }
        return index;
    }
}
