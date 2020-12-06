package com.zjs.greedalgorithm;

/**
 * @ClassName CheckPossibility
 * @Description 655 非递减数列 题目链接: https://leetcode-cn.com/problems/non-decreasing-array/
 * 贪心算法
 * @Author zhangjusheng
 * @Date 2020/12/5 11:18
 * @Version 1.0
 */
public class CheckPossibility {

    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            if (i - 2 < 0 || nums[i - 2] <= nums[i])
                nums[i - 1] = nums[i];
            else
                nums[i] = nums[i - 1];
            cnt++;
        }
        return cnt <= 1;
    }
}
