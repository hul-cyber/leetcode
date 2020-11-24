package com.zjs.swordtooffer;

/**
 * @ClassName TwoSum1
 * @Description 剑指Offer 57 和为s的两个数字 题目链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 * 使用二分法,第一个数字通过遍历来寻找,第二个数字通过来寻找。
 * @Author zhangjusheng
 * @Date 2020/11/7 15:59
 * @Version 1.0
 **/
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2)
            return null;

        int[] res = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            int left = i + 1, right = nums.length - 1, e = target - nums[i], mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (nums[mid] == e) {
                    res[0] = nums[i];
                    res[1] = nums[mid];
                    break;
                } else if (nums[mid] < e) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return res;
    }
}
