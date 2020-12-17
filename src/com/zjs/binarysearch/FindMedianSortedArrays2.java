package com.zjs.binarysearch;

/**
 * @ClassName FindMedianSortedArrays2
 * @Description 4 寻找两个正序数组的中位数 题目链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 二分查找,优化版
 * @Author zhangjusheng
 * @Date 2020/12/17 18:25
 * @Version 1.0
 */
public class FindMedianSortedArrays2 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        // 将奇数和偶数统一到一起
        return (getKthElement(nums1, 0, nums1.length, nums2, 0, nums2.length, (length + 1) / 2) +
                getKthElement(nums1, 0, nums1.length, nums2, 0, nums2.length, (length + 2) / 2)) * 0.5;
    }

    public int getKthElement(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2,
                             int indexToFind) {
        int len1 = end1 - start1;
        int len2 = end2 - start2;

        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) {
            return getKthElement(nums2, start2, end2, nums1, start1, end1, indexToFind);
        }
        // 1. 处理其中一个数组为空或者需要返回第一个元素的情况
        if (len1 == 0) {
            return nums2[start2 + indexToFind - 1];
        } else if (indexToFind == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        // 2. 计算出两个数组中需要比较元素的下标
        int index1 = start1 + Math.min(len1, indexToFind / 2) - 1;
        int index2 = start2 + Math.min(len2, indexToFind / 2) - 1;
        // 3. 比较数组中选定的两个元素
        if (nums1[index1] <= nums2[index2]) {
            return getKthElement(nums1, index1 + 1, end1, nums2, start2, end2, indexToFind - (index1
                    - start1 + 1));
        } else {
            return getKthElement(nums1, start1, end1, nums2, index2 + 1, end2, indexToFind - (index2
                    - start2 + 1));
        }
    }
}
