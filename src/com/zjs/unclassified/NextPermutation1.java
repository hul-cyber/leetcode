package com.zjs.unclassified;

/**
 * @ClassName NextPermutation1
 * @Description 31 下一个排列, 题目链接：https://leetcode-cn.com/problems/next-permutation/
 * 寻找规律, 代码已优化
 * @Author zhangjusheng
 * @Date 2020/12/18 10:49
 * @Version 1.0
 */
public class NextPermutation1 {

    public void nextPermutation(int[] nums) {
        // 1. 寻找较小数
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        // 2. 交换较大数和较小数的位置
        if (i >= 0) {
            // 寻找较大数的位置
            int w = nums.length - 1;
            // 这里不需要判断w >= 0,因为肯定能在nums[i]后面找到大于它的数
            while (nums[w] <= nums[i]) {
                w--;
            }
            // 交换较大数和较小数的位置
            swap(nums, i, w);
        }
        // 3. 反转区间
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
