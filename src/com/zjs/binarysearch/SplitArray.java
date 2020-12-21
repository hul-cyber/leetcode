package com.zjs.binarysearch;

/**
 * @ClassName SplitArray
 * @Description 410 分割数组的最大值 题目链接: https://leetcode-cn.com/problems/split-array-largest-sum/
 * 二分查找
 * @Author zhangjusheng
 * @Date 2020/12/20 22:47
 * @Version 1.0
 */
public class SplitArray {

    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }
        int low = max, high = sum;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (check(nums, m, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // 使用贪心算法来判断
    public boolean check(int[] nums, int m, int target) {
        int cnt = 1, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > target) {
                sum = nums[i];
                cnt++;
            } else {
                sum += nums[i];
            }
        }
        return cnt <= m;
    }
}
