package com.zjs.sort;

/**
 * @ClassName SortArray4
 * @Description 912. 排序数组 题目链接: https://leetcode-cn.com/problems/sort-an-array/
 * 插入排序第二种方式
 * @Author zhangjusheng
 * @Date 2021/1/2 15:33
 * @Version 1.0
 */
public class SortArray4 {

    public int[] sortArray(int[] nums) {
        int temp;
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            temp = nums[i];
            int j = i;
            while (j > 0 && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }
}
