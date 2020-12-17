package com.zjs.binarysearch;

/**
 * @ClassName PeakIndexInMountainArray
 * @Description 852 山脉数组的峰值索引 题目链接: https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 * 二分查找
 * @Author zhangjusheng
 * @Date 2020/12/14 21:20
 * @Version 1.0
 */
public class PeakIndexInMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
