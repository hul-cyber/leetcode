package com.zjs.swordtooffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SearchInSorted1
 * @Description 剑指Offer 53 - I 在排序数组中查找数字I 题目链接: https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * HashMap实现
 * @Author zhangjusheng
 * @Date 2020/11/2 10:40
 * @Version 1.0
 **/
public class SearchInSorted1 {
    public static void main(String[] args) {
        SearchInSorted1 searchInSorted = new SearchInSorted1();
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(searchInSorted.search(nums, 8));
    }

    public int search(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer preNums = map.getOrDefault(nums[i], 0);
            map.put(nums[i], preNums + 1);
        }

        return map.get(target);
    }

}
