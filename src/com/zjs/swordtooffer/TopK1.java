package com.zjs.swordtooffer;

/**
 * @ClassName TopK1
 * @Description 剑指Offer 40 最小的k个数 题目描述: https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * 冒泡排序
 * @Author zhangjusheng
 * @Date 2020/10/23 10:24
 * @Version 1.0
 **/
public class TopK1 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] leastNumbers = new int[k];
        int index = 0;
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
            if (i == k)
                break;

            leastNumbers[index++] = arr[i];
        }

        return leastNumbers;
    }
}
