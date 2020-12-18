package com.zjs.unclassified;

import java.util.Arrays;

/**
 * @ClassName NextPermutation2
 * @Description 31 下一个排列, 题目链接：https://leetcode-cn.com/problems/next-permutation/
 * 寻找规律, 自己的版本, 代码未优化
 * @Author zhangjusheng
 * @Date 2020/12/18 10:50
 * @Version 1.0
 */
public class NextPermutation2 {

    public void nextPermutation(int[] nums) {
        boolean flag = false;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                flag = true;
                int w = 0;
                for (w = i; w < nums.length; w++) {
                    // 与后面刚好大于它元素进行交换
                    if (nums[w] <= nums[i - 1])
                        break;
                }
                swap(nums, i - 1, w - 1);
                Arrays.sort(nums, i, nums.length);
                break;
            }
        }
        if (flag == false)
            Arrays.sort(nums, 0, nums.length);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
