package com.zjs.divideandconquer;

/**
 * @ClassName ReversePairs
 * @Description 剑指Offer 51 数组中的逆序对 题目链接: https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * 分治
 * @Author zhangjusheng
 * @Date 2021/1/6 22:13
 * @Version 1.0
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        int length = nums.length;
        if(length == 0)
            return 0;
        int[] temp = new int[length];
        return reversePairs(nums, 0, length - 1, temp);
    }

    public int reversePairs(int[] nums, int low, int high, int[] temp) {
        if (low == high) {
            return 0;
        }
        int mid = low + (high - low) / 2;
        int leftPairs = reversePairs(nums, low, mid, temp);
        int rightPairs = reversePairs(nums, mid + 1, high, temp);
        if (nums[mid] < nums[mid + 1])
            return leftPairs + rightPairs;
        int crossPairs = mergeAndCount(nums, low, high, mid, temp);
        return leftPairs + rightPairs + crossPairs;
    }

    public int mergeAndCount(int[] nums, int low, int high, int mid, int[] temp) {
        for (int i = low; i <= high; i++) {
            temp[i] = nums[i];
        }
        int count = 0;
        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j++];
            } else if (j == high + 1) {
                nums[k] = temp[i++];
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                count += (mid - i + 1);
            }
        }
        return count;
    }
}
