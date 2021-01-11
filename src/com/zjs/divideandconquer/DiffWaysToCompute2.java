package com.zjs.divideandconquer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DiffWaysToCompute2
 * @Description 241. 为运算表达式设计优先级 题目链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses/
 * 分治算法(优化版)
 * @Author zhangjusheng
 * @Date 2021/1/11 23:35
 * @Version 1.0
 */
public class DiffWaysToCompute2 {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for (int m : left) {
                    for (int n : right) {
                        switch(c) {
                            case '+':
                                res.add(m + n);
                                break;
                            case '-':
                                res.add(m - n);
                                break;
                            default:
                                res.add(m * n);
                        }
                    }
                }
            }
        }
        if (res.size() == 0)
            res.add(Integer.valueOf(input));
        return res;
    }
}
