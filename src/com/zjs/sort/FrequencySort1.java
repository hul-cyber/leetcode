package com.zjs.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName FrequencySort1
 * @Description 451. 根据字符出现频率排序 题目链接: https://leetcode-cn.com/problems/sort-characters-by-frequency/
 * 快速排序
 * @Author zhangjusheng
 * @Date 2021/1/14 20:54
 * @Version 1.0
 */
public class FrequencySort1 {

    private static final Random RANDOM = new Random();

    public String frequencySort(String s) {
        // 将字符串转化为字符数组
        char[] arr = s.toCharArray();
        int length = arr.length;
        // 统计各个字符出现的频率
        Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = arr[i];
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }
        frequencySort(arr, 0, length - 1, frequencies);
        return String.valueOf(arr);
    }

    // 制定比较规则
    private int compare(char a, char b, Map<Character, Integer> frequencies) {
        if (a == b) {
            return 0;
        }
        int frequency1 = frequencies.get(a);
        int frequency2 = frequencies.get(b);
        if (frequency1 <= frequency2)
            return 1;
        else
            return -1;
    }

    // 进行排序
    private void frequencySort(char[] arr, int left, int right, Map<Character, Integer> frequencies) {
        if (left >= right)
            return;
        int randomIndex = left + RANDOM.nextInt(right - left + 1);
        swap(arr, left, randomIndex);
        char pivot = arr[left];
        int lt = left;
        int gt = right + 1;
        int i = left;
        while (i < gt) {
            int value = compare(arr[i], pivot, frequencies);
            if (value == 1) {
                gt--;
                swap(arr, i, gt);
            } else if (value == -1) {
                lt++;
                swap(arr, lt, i);
                i++;
            } else {
                i++;
            }
        }
        swap(arr, lt, left);
        frequencySort(arr, left, lt, frequencies);
        frequencySort(arr, gt, right, frequencies);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
