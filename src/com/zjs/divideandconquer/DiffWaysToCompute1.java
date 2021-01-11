package com.zjs.divideandconquer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DiffWaysToCompute1
 * @Description 241. 为运算表达式设计优先级 题目链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
 * 分治算法(未优化)
 * @Author zhangjusheng
 * @Date 2021/1/11 23:33
 * @Version 1.0
 */
public class DiffWaysToCompute1 {
    public List<Integer> diffWaysToCompute(String input) {
        // 分割字符串
        String[] nums = split(input);
        int length = nums.length;
        return diffWaysToCompute(nums, 0, length - 1);
    }

    public String[] split(String input) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        char c = ' ';
        for (int i = 0; i < input.length(); i++) {
            c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                list.add(sb.toString());
                sb = new StringBuilder("");
                sb.append(c);
                list.add(sb.toString());
                sb = new StringBuilder("");
            } else {
                sb.append(c);
            }
        }
        list.add(sb.toString());
        return list.toArray(new String[list.size()]);
    }

    public List<Integer> diffWaysToCompute(String[] nums, int low, int high) {
        List<Integer> res = new ArrayList<Integer>();
        if (low == high) {
            res.add(Integer.parseInt(nums[low]));
            return res;
        }
        for (int i = low + 1; i <= high; i += 2) {
            List<Integer> list1 = diffWaysToCompute(nums, low, i - 1);
            List<Integer> list2 = diffWaysToCompute(nums, i + 1, high);
            res.addAll(combine(list1, list2, nums[i]));
        }
        return res;
    }

    public int operator(String s, int a, int b) {
        switch(s) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            default:
                return a * b;
        }
    }

    public List<Integer> combine(List<Integer> list1, List<Integer> list2, String c) {
        List<Integer> res = new ArrayList<Integer>();
        for (int i : list1) {
            for (int j : list2) {
                res.add(operator(c, i, j));
            }
        }
        return res;
    }
}
