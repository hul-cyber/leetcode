package com.zjs.swordtooffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName TwoSum2
 * @Description 剑指Offer 57 和为s的两个数字 题目链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * hash表
 * @Author zhangjusheng
 * @Date 2020/11/7 23:31
 * @Version 1.0
 **/
public class TwoSum2 {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int num : nums) {
            if (set.contains(target - num))
                return new int[]{num, target - num};
        }

        return new int[]{-1, -1};
    }
}
