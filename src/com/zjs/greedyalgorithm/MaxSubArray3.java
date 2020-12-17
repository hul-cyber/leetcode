package com.zjs.greedyalgorithm;

/**
 * @ClassName MaxSubArray3
 * @Description 53 最大子序和 题目链接: https://leetcode-cn.com/problems/maximum-subarray/description/
 * 分治法
 * @Author zhangjusheng
 * @Date 2020/12/5 23:10
 * @Version 1.0
 */
public class MaxSubArray3 {

    class Status {
        int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArray(int[] nums) {
        return recur(0, nums.length - 1, nums).mSum;
    }

    public Status recur(int left, int right, int[] nums) {
        if (left == right)
            return new Status(nums[left], nums[left], nums[left], nums[left]);
        else {
            int mid = (left + right) >> 1;
            // 拆分求解
            Status status1 = recur(left, mid, nums);
            Status status2 = recur(mid + 1, right, nums);
            // 首先判断能不能合并
            int lSum, rSum, mSum, iSum;
            lSum = Math.max(status1.lSum, status1.iSum + status2.lSum);
            rSum = Math.max(status2.rSum, status1.rSum + status2.iSum);
            iSum = status1.iSum + status2.iSum;
            mSum = Math.max(Math.max(status1.mSum, status2.mSum), status1.rSum + status2.lSum);
            return new Status(lSum, rSum, mSum, iSum);
        }
    }
}
