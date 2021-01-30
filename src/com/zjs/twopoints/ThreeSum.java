package com.zjs.twopoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ThreeSum
 * @Description 15. 三数之和 题目链接: https://leetcode-cn.com/problems/3sum/
 * 双指针
 * @Author hul-cyber
 * @Date 2021/1/30 9:51
 * @Version 1.0
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if (len < 3 || nums[0] > 0)
            return ans;
        for (int i = 0; i < len - 2; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int target = -nums[i];
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    List<Integer> list = Arrays.asList(new Integer[]{nums[i], nums[left], nums[right]});
                    ans.add(list);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                    left++;
                }
            }
        }
        return ans;
    }
}
