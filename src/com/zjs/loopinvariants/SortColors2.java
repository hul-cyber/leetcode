package com.zjs.loopinvariants;

/**
 * @ClassName SortColors2
 * @Description 75 颜色分类 题目链接:https://leetcode-cn.com/problems/sort-colors/
 * 循环不变量 + 三向切分(快速排序)
 * @Author zhangjusheng
 * @Date 2021/1/13 23:10
 * @Version 1.0
 */
public class SortColors2 {

    public void sortColors(int[] nums) {
        int pivot = 1;
        int lt = -1;
        int gt = nums.length;
        int i = 0;
        while (i < gt) {
            if (nums[i] > pivot) {
                gt--;
                swap(nums, gt, i);
            } else if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
                i++;
            } else {
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
