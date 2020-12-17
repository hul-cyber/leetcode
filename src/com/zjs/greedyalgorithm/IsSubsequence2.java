package com.zjs.greedyalgorithm;

/**
 * @ClassName IsSubsequence2
 * @Description 329 判断子序列 题目链接: https://leetcode-cn.com/problems/is-subsequence/description/
 * 使用String里的indexOf方法
 * @Author zhangjusheng
 * @Date 2020/12/5 9:14
 * @Version 1.0
 */
public class IsSubsequence2 {

    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1)
                return false;
        }
        return true;
    }
}
