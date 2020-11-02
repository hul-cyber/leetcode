package com.zjs;

import java.util.Arrays;

/**
 * @ClassName ReversePairs1
 * @Description 剑指Offer 51 数组中的逆序对 题目链接: https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 * 基于归并排序的算法
 * @Author zhangjusheng
 * @Date 2020/11/1 0:03
 * @Version 1.0
 **/
public class ReversePairs1 {
    int segmentation = 0;
    int p1 = 0;
    int p2 = 0;
    int p3 = 0;
    int curNum = 0;

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int[] copyNums = Arrays.copyOfRange(nums, 0, nums.length);

        return recursive(0, nums.length - 1, nums, copyNums);
    }

    public int recursive(int start, int end, int[] nums, int[] copyNums) {
        //如果只有一个数字
        if (start == end) {
            return 0;
        }

        else {
            //将该数组划分为两段
            int mid = (start + end) / 2;
            segmentation = recursive(start, mid, copyNums, nums) + recursive(mid + 1, end, copyNums, nums);
            curNum = 0;

            //将两段进行归并
            p1 = mid;
            p2 = end;
            p3 = end;

            while (p1 >= start && p2 >= mid + 1) {
                if (nums[p1] > nums[p2]) {
                    curNum += (p2 - mid);
                    copyNums[p3] = nums[p1];
                    p1--;
                    p3--;
                } else {
                    copyNums[p3] = nums[p2];
                    p2--;
                    p3--;
                }
            }

            for (; p1 >= start; p1--)
                copyNums[p3--] = nums[p1];
            for (; p2 >= mid + 1; p2--)
                copyNums[p3--] = nums[p2];

            return segmentation + curNum;
        }
    }
}