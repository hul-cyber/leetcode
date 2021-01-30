package com.zjs.twopoints;

/**
 * @ClassName MaxArea
 * @Description 11. 盛最多水的容器 题目链接: https://leetcode-cn.com/problems/container-with-most-water/
 * 双指针
 * @Author hul-cyber
 * @Date 2021/1/30 15:11
 * @Version 1.0
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int length = height.length;
        if (length < 2) {
            return 0;
        }
        int maxVolume = 0;
        int left = 0;
        int right = length - 1;
        while (left < right) {
            int high = Math.min(height[left], height[right]);
            int wide = (right - left);
            int volume = high * wide;
            maxVolume = Math.max(volume, maxVolume);
            if (height[left] < height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }
        return maxVolume;
    }
}
