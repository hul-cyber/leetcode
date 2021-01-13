package com.zjs.twopoints;

/**
 * @ClassName SortColors1
 * @Description 75 颜色分类 题目链接:https://leetcode-cn.com/problems/sort-colors/
 * 双指针 + 循环不变量
 * @Author zhangjusheng
 * @Date 2021/1/13 23:55
 * @Version 1.0
 */
public class SortColors1 {

    public void sortColors(int[] nums) {
        int length = nums.length;
        int p0 = 0;
        int p1 = 0;
        int i = 0;
        while (i < length) {
            if (nums[i] == 1) {
                swap(nums, i, p1);
                p1++;
            } else if (nums[i] < 1) {
                swap(nums, i, p0);
                if (p0 < p1)
                    swap(nums, i, p1);
                p0++;
                p1++;
            }
            i++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
