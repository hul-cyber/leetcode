package com.zjs.other;

/**
 * @ClassName TwoSum
 * @Description 1. 两数之和 题目链接：https://leetcode-cn.com/problems/two-sum/
 * 采用选择排序的思想
 * @Author zhangjusheng
 * @Date 2021/1/1 10:25
 * @Version 1.0
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        throw new IllegalArgumentException("输入参数非法！");
    }
}
