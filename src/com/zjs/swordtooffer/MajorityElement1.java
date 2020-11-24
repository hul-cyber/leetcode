package com.zjs.swordtooffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MajorityElement1
 * @Description 剑指Offer 39数组中出现次数超过一半的数字 题目链接:https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * 哈希统计法
 * @Author zhangjusheng
 * @Date 2020/10/23 8:43
 * @Version 1.0
 **/
public class MajorityElement1 {
    public static void main(String[] args) {
        MajorityElement1 majorityElement = new MajorityElement1();
        int[] elements = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement.majorityElement(elements));
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        int maxIndex = 0;
        int num = 0;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                num = map.get(nums[i]) + 1;
                map.put(nums[i], num);
                if (num > max) {
                    max = num;
                    maxIndex = i;
                }
            } else {
                map.put(nums[i], 1);
            }
        }

        return map.get(nums[maxIndex]);
    }

}
