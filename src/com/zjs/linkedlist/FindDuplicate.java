package com.zjs.linkedlist;

/**
 * @ClassName FindDuplicate
 * @Description 287. 寻找重复数 题目链接: https://leetcode-cn.com/problems/find-the-duplicate-number/
 * 快慢指针
 * @Author hul-cyber
 * @Date 2021/2/19 11:18
 * @Version 1.0
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int quick = 0;
        int slow = 0;
        int result = 0;
        while (true) {
            slow = nums[slow];
            quick = nums[nums[quick]];
            if (nums[slow] == nums[quick]) {
                quick = 0;
                while (nums[slow] != nums[quick]) {
                    slow = nums[slow];
                    quick = nums[quick];
                }
                result = nums[slow];
                break;
            }
        }
        return result;
    }
}
