package com.zjs.twopoints;

/**
 * @ClassName Trap
 * @Description 42. 接雨水 题目链接: https://leetcode-cn.com/problems/trapping-rain-water/
 * 双指针
 * @Author hul-cyber
 * @Date 2021/1/30 14:17
 * @Version 1.0
 */
public class Trap {
    public int trap(int[] height) {
        int len = height.length;
        if (len < 3) {
            return 0;
        }
        int res = 0;
        int leftMax = height[0];
        int rightMax = height[len - 1];
        int left = 1;
        int right = len - 2;
        while (left <= right) {
            if (leftMax <= rightMax) {
                if (leftMax > height[left]) {
                    res += (leftMax - height[left]);
                }
                leftMax = Math.max(height[left], leftMax);
                left++;
            } else if (leftMax > rightMax) {
                if (rightMax > height[right]) {
                    res += (rightMax - height[right]);
                }
                rightMax = Math.max(height[right], rightMax);
                right--;
            }
        }
        return res;
    }
}
