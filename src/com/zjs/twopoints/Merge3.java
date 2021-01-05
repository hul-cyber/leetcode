package com.zjs.twopoints;

/**
 * @ClassName Merge3
 * @Description 88 合并两个有序数组 题目链接：https://leetcode-cn.com/problems/merge-sorted-array/
 * 双指针 + 从后向前 + 代码优化
 * @Author zhangjusheng
 * @Date 2021/1/5 19:49
 * @Version 1.0
 */
public class Merge3 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = (nums1[i] >= nums2[j]) ? nums1[i--] : nums2[j--];
        }
        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }
}
