package com.zjs.binarysearch;

/**
 * @ClassName GuessNumber
 * @Description 374 猜数字大小 题目链接: https://leetcode-cn.com/problems/guess-number-higher-or-lower/
 * 二分查找
 * @Author zhangjusheng
 * @Date 2020/12/14 20:45
 * @Version 1.0
 */
public class GuessNumber extends GuessGame {

    public int guessNumber(int n) {
        int left = 1, right = n;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                result = mid;
                return result;
            } else if (guess(mid) == -1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
}
