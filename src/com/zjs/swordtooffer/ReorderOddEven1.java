package com.zjs.swordtooffer;

/**
 * @ClassName ReorderOddEven1
 * @Description 调整数组顺序使奇数位于偶数之前 题目链接: https://leetcode-cn.com/problems/diao-zheng-shu
 * -zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * 重新申请一个数组,将基数放前面,将偶数后面 最坏情况下:时间复杂度O(n) 空间复杂度O(n)
 * @Author zhangjusheng
 * @Date 2020/10/9 23:10
 * @Version 1.0
 **/
public class ReorderOddEven1 {
    public int[] reorderOddEven(int[] nums) {
        int[] newNums = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0)
                newNums[start++] = nums[i];
            else
                newNums[end--] = nums[i];
        }
        return newNums;
    }
}
