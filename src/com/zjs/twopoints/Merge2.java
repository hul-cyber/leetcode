package com.zjs.twopoints;

/**
 * @ClassName Merge2
 * @Description 88 合并两个有序数组 题目链接:https://leetcode-cn.com/problems/merge-sorted-array/
 * 双指针 + 从结尾归并
 * @Author zhangjusheng
 * @Date 2020/11/25 12:24
 * @Version 1.0
 */
public class Merge2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[end--] = nums2[j--];
            }
            else if (j < 0) {
                nums1[end--] = nums1[i--];
            }
            else if (nums1[i] >= nums2[j]) {
                nums1[end--] = nums1[i--];
            } else {
                nums1[end--] = nums2[j--];
            }
        }
    }
}
