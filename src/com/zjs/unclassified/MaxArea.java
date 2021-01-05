package com.zjs.unclassified;

/**
 * @ClassName MaxArea
 * @Description 11. 盛最多水的容器 题目链接: https://leetcode-cn.com/problems/container-with-most-water/
 * 暴力法
 * @Author zhangjusheng
 * @Date 2021/1/1 10:59
 * @Version 1.0
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int res = 0;
        int length = height.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                res = Math.max(res, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return res;
    }
}
