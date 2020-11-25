package com.zjs.twopoints;

/**
 * @ClassName TwoSum
 * @Description 167 两数之和 ii - 输入有序数组 题目链接: https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/description/
 * 双指针
 * @Author zhangjusheng
 * @Date 2020/11/24 23:07
 * @Version 1.0
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if ((numbers[left] + numbers[right]) > target) {
                right--;
            } else if ((numbers[left] + numbers[right]) < target) {
                left++;
            } else {
                break;
            }
        }
        int[] res = new int[]{left + 1, right + 1};
        return res;
    }
}
