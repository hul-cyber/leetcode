package com.zjs.swordtooffer;

/**
 * @ClassName ReorderOddEven3
 * @Description 调整数组顺序使奇数位于偶数之前 题目链接: https://leetcode-cn.com/problems/diao-zheng-shu
 * -zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * 快慢双指针解法
 * @Author zhangjusheng
 * @Date 2020/10/10 8:08
 * @Version 1.0
 **/
public class ReorderOddEven3 {
    public int[] reorderOddEven(int[] nums) {
        if (nums == null)
            return null;
        int slow = 0;
        int quick = 0;
        while (quick < nums.length) {
            if ((nums[quick] & 1) == 1) {
                int temp = nums[quick];
                nums[quick] = nums[slow];
                nums[slow++] = temp;
            }
            quick++;
        }
        return nums;
    }
}
