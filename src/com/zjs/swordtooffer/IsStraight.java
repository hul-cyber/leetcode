package com.zjs.swordtooffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName IsStraight
 * @Description 剑指Offer 61 : 扑克牌中的顺子 题目链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
 * 使用Set集合实现
 * @Author zhangjusheng
 * @Date 2020/11/16 23:35
 * @Version 1.0
 */
public class IsStraight {
    public boolean isStraight(int[] nums) {
        int max = 1;
        int min = 13;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            if (nums[i] == 0) continue;
            if (set.contains(nums[i])) return false;
            set.add(nums[i]);
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max - min < 5;
    }
}
