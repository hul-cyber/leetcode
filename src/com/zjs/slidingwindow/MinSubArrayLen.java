package com.zjs.slidingwindow;

/**
 * @ClassName MinSubArrayLen
 * @Description 209. 长度最小的子数组 题目链接: https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * 滑动窗口
 * @Author hul-cyber
 * @Date 2021/1/29 17:14
 * @Version 1.0
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLen = len + 1;
        while (right < len) {
            while (right < len && sum < s) {
                sum += nums[right];
                right++;
            }
            while (sum >= s) {
                if (right - left < minLen) {
                    minLen = right - left;
                }
                sum -= nums[left];
                left++;
            }
        }
        return minLen == len + 1 ? 0 : minLen;
    }
}
