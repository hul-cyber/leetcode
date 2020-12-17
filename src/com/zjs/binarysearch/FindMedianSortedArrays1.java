package com.zjs.binarysearch;

/**
 * @ClassName FindMedianSortedArrays1
 * @Description 4 寻找两个正序数组的中位数 题目链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * 二分查找（自己的版本,代码写得比较乱）
 * @Author zhangjusheng
 * @Date 2020/12/16 10:23
 * @Version 1.0
 */
public class FindMedianSortedArrays1 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 != 0) {
            // 如果数组个数为奇数
            // 计算中位数下标
            int midIndex = length / 2;
            return getKthElement(nums1, nums2, midIndex);
        } else {
            // 如果数组个数为偶数
            // 计算中位数下标
            int midIndex1 = length / 2;
            int midIndex2 = length / 2 - 1;
            return (getKthElement(nums1, nums2, midIndex1) + getKthElement(nums1, nums2, midIndex2)) / 2.0;
        }
    }

    public int getKthElement(int[] nums1, int[] nums2, int index) {
        // 需要去除的元素的个数
        int numToRemove = index;
        // 数组Nums1和Nums2首部元素的下标
        int curIndexNums1 = 0;
        int curIndexNums2 = 0;
        while(numToRemove >= 0 && curIndexNums1 < nums1.length && curIndexNums2 < nums2.length) {
            // 还有需要去除的元素并且两个数组全不为空
            if (numToRemove == 0) {
                // 比较两个数组当前最前端的元素
                if (nums1[curIndexNums1] <= nums2[curIndexNums2]) {
                    return nums1[curIndexNums1];
                } else {
                    return nums2[curIndexNums2];
                }
            } else if (numToRemove == 1) {
                if (nums1[curIndexNums1] <= nums2[curIndexNums2]) {
                    curIndexNums1++;
                } else {
                    curIndexNums2++;
                }
                numToRemove--;
            } else {
                // 计算两个数组中需要移除元素的下标
                int index1 = curIndexNums1 + (numToRemove + 1) / 2 - 1;
                int index2 = curIndexNums2 + numToRemove / 2 - 1;
                if (index1 >= nums1.length || index2 >= nums2.length) {
                    // 计算出需要比较的元素的真实下标
                    if (index1 >= nums1.length)
                        index1   = nums1.length - 1;
                    else
                        index2 = nums2.length - 1;
                }
                if (nums1[index1] <= nums2[index2]) {
                    numToRemove -= (index1 - curIndexNums1 + 1);
                    curIndexNums1 = index1 + (index1 - curIndexNums1 + 1);
                } else {
                    numToRemove -= (index2 - curIndexNums2 + 1);
                    curIndexNums2 = index2 + (index2 - curIndexNums2 + 1);
                }
            }
        }
        if (curIndexNums1 == nums1.length) {
            // 从第二个数组移除元素
            return nums2[numToRemove + curIndexNums2];
        } else {
            // 从第一个数组移除元素
            return nums1[numToRemove + curIndexNums1];
        }
    }
}
