package com.zjs.swordtooffer;

/**
 * @ClassName SearchInSorted2
 * @Description 剑指Offer 53 - I 在排序数组中查找数字I 题目链接: https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * 二分查找法
 * @Author zhangjusheng
 * @Date 2020/11/2 17:46
 * @Version 1.0
 **/
public class SearchInSorted2 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;

        return rightBorder(nums, target) - rightBorder(nums, target - 1);
    }

    public int rightBorder(int[] nums, int target) {
        //寻找右边界
        int i = 0;
        int j = nums.length - 1;
        int mid = 0;

        while (i <= j) {
            mid = (i + j) / 2;

            if (nums[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return i;
    }
}
