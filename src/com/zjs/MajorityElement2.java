package com.zjs;

/**
 * @ClassName MajorityElement2
 * @Description 剑指Offer 39 数组中出现次数超过一半的数字 题目链接: https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * 摩尔投票法
 * @Author zhangjusheng
 * @Date 2020/10/23 9:49
 * @Version 1.0
 **/
public class MajorityElement2 {
    public int majorityElement(int[] nums) {
        int votes = 0;
        int majority = 0;

        for (int i = 0; i < nums.length; i++) {
            if (votes == 0) {
                majority = nums[i];
                votes++;
            }
            else {
                if (majority == nums[i])
                    votes++;
                else
                    votes--;
            }
        }

        return majority;
    }

}
