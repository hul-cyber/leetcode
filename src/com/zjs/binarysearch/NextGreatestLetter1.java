package com.zjs.binarysearch;

/**
 * @ClassName NextGreatestLetter1
 * @Description 744 寻找比目标字母大的最小字母 题目链接：https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 * 二分查找
 * @Author zhangjusheng
 * @Date 2020/12/11 20:42
 * @Version 1.0
 */
public class NextGreatestLetter1 {

    public char nextGreatestLetter(char[] letters, char target) {
        // 设置最初的查找范围[0, letters.length - 1]
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                // 查找范围为[mid + 1, right]
                left = mid + 1;
            } else {
                // 查找范围为[left, mid - 1]
                right = mid - 1;
            }
        }
        return left == letters.length ? letters[0] : letters[left];
    }
}
