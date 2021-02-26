package com.zjs.stackandqueue;

/**
 * @ClassName SortArray
 * @Description 912. 排序数组 题目链接: https://leetcode-cn.com/problems/sort-an-array/
 * 堆排序
 * @Author hul-cyber
 * @Date 2021/2/25 15:08
 * @Version 1.0
 */
public class SortArray {
    public int[] sortArray(int[] nums) {
        // 先整理成堆
        heapify(nums);
        for (int i = nums.length - 1; i > 0;) {
            swap(nums, i, 0);
            siftDown(nums, 0, --i);
        }
        return nums;
    }

    // 堆化，自下往上
    private void heapify(int[] nums) {
        int len = nums.length;
        for (int i = (len - 1) / 2; i >= 0; i--) {
            siftDown(nums, i, len - 1);
        }
    }

    // 向下调整
    private void siftDown(int[] nums, int n, int end) {
        int temp = nums[n];
        while ((2 * n + 1) <= end) {
            int child = n * 2 + 1;
            if (child + 1 <= end && nums[child] < nums[child + 1]) {
                child++;
            }
            if (nums[child] <= temp) {
                break;
            }
            nums[n] = nums[child];
            n = child;
        }
        nums[n] = temp;
    }

    // 交换
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
