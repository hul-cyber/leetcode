package com.zjs;

/**
 * @ClassName TopK3
 * @Description 剑指Offer 40 最小的k个数 题目描述: https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * 手写快速排序
 * @Author zhangjusheng
 * @Date 2020/10/23 14:34
 * @Version 1.0
 **/
public class TopK3 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0)
            return new int[0];

        int[] leastNumbers = new int[k];
        quickSort(arr, 0, arr.length - 1, k - 1);

        for (int i = 0; i < k; i++) {
            leastNumbers[i] = arr[i];
        }

        return leastNumbers;
    }

    public void quickSort(int[] arr, int low, int high, int k) {
        int j = partition(low, high, arr);

        if (j == k) return;

        if (j > k) {
            quickSort(arr, low, j - 1, k);
        } else {
            quickSort(arr, j + 1, high, k);
        }
    }

    public int partition(int low, int high, int[] arr) {
        int i = low;
        int j = high + 1;
        int v = arr[low];

        while (true) {
            while (++i < high && arr[i] < v);
            while (--j > low && arr[j] > v);

            if (i >= j)
                break;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        arr[low] = arr[j];
        arr[j] = v;

        return j;
    }
}
