package com.zjs.twopoints;

import java.util.Arrays;

/**
 * @ClassName ThreeSumClosest
 * @Description 16. 最接近的三数之和 题目链接: https://leetcode-cn.com/problems/3sum-closest/
 * 双指针
 * @Author hul-cyber
 * @Date 2021/1/30 11:13
 * @Version 1.0
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < minDiff) {
                    // 如果此时更加接近
                    minDiff = Math.abs(sum - target);
                    ans = sum;
                }
                if (sum < target) {
                    // 如果和小于目标值，应该增大
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                } else {
                    // 如果和大于目标值，应该减小
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                }
            }
        }
        return ans;
    }
}
