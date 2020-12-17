package com.zjs.binarysearch;

/**
 * @ClassName NextGreatestLetter2
 * @Description 744 寻找比目标字母大的最小字母 题目链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 * 二分查找
 * @Author zhangjusheng
 * @Date 2020/12/11 20:44
 * @Version 1.0
 */
public class NextGreatestLetter2 {

    public char nextGreatestLetter(char[] letters, char target) {

        int left = 0, right = letters.length - 1;
        // 寻找最右端的元素
        while (left < right) {
            // 向上取整
            int mid = left + (right - left + 1) / 2;
            if (letters[mid] > target) {
                // 查找范围为[left, mid - 1)
                right = mid - 1;
            } else {
                // 查找范围为[mid, right)
                left = mid;
            }
        }
        // 将letters[left]与target进行比较
        if (letters[left] > target) {
            return letters[left];
        } else {
            if (left + 1 == letters.length)
                return letters[0];
            return letters[left + 1];
        }
    }
}
