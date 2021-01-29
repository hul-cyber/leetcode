package com.zjs.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName FindDuplicates
 * @Description 442. 数组中的重复的数据 题目链接: https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 * 通过修改原数组来存储当前遍历到的数是否已经存在(哈希排序的思想)
 * @Author zhangjusheng
 * @Date 2021/1/19 15:48
 * @Version 1.0
 */
public class FindDuplicates {
    public List<Integer> findDuplicates(int[] nums) {
        int length = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int temp = Math.abs(nums[i]) - 1;
            if (nums[temp] < 0)
                res.add(Math.abs(nums[i]));
            nums[temp] = -nums[temp];
        }
        return res;
    }
}
