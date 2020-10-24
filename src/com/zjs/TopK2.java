package com.zjs;

import java.util.Arrays;

/**
 * @ClassName TopK2
 * @Description 剑指Offer 40 最小的k个数 题目链接: https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * 使用Arrays中原生的快速排序
 * @Author zhangjusheng
 * @Date 2020/10/23 10:26
 * @Version 1.0
 **/
public class TopK2 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] leastNumbers = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; i++) {
            leastNumbers[i] = arr[i];
        }
        return leastNumbers;
    }
}
