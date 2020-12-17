package com.zjs.greedyalgorithm;

import java.util.Arrays;

/**
 * @ClassName FindContentChildren
 * @Description 455 分发饼干 题目链接: https://leetcode-cn.com/problems/assign-cookies/description/
 * 贪心算法
 * @Author zhangjusheng
 * @Date 2020/12/6 9:50
 * @Version 1.0
 */
public class FindContentChildren {

    public int findContentChildren(int[] g, int[] s) {
        // 排序饼干和胃口值
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0;
        int sIndex = 0;
        while (gIndex < g.length && sIndex < s.length) {
            // 当儿童和饼干都有剩余时
            if (g[gIndex] <= s[sIndex]) {
                // 当吃下该饼干,儿童可以满足
                gIndex++;
            }
            // 当儿童得不到满足,寻找更大的饼干
            sIndex++;
        }
        return gIndex;
    }
}
