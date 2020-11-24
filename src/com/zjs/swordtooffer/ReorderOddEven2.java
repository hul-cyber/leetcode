package com.zjs.swordtooffer;

/**
 * @ClassName ReorderOddEven2
 * @Description 调整数组顺序使奇数位于偶数之前 题目链接: https://leetcode-cn.com/problems/diao-zheng-shu
 * -zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * 首位双指针解法,最坏情况下:时间复杂度:O(n) 空间复杂度O(1)
 * @Author zhangjusheng
 * @Date 2020/10/9 23:29
 * @Version 1.0
 **/
public class ReorderOddEven2 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        exchange(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static int[] exchange(int[] nums) {
        if (nums == null)
            return null;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            while (start < nums.length && (nums[start] & 1) == 1) {
                //如果是奇数,就一直向后找
                start++;
            }
            while (end > -1 && ((nums[end] & 1) == 0)) {
                //如果是偶数,就一直向前找
                end--;
            }
            //交换双方的位置
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }
}
