package com.zjs.twopoints;

/**
 * @ClassName MoveZeros
 * @Description 283 移动零 题目链接：https://leetcode-cn.com/problems/move-zeroes/
 * 双指针
 * @Author zhangjusheng
 * @Date 2021/1/4 23:06
 * @Version 1.0
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        int length = nums.length;
        while (right < length) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
