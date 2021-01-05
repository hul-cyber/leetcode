package com.zjs.binarysearch;

/**
 * @ClassName MySqrt3
 * @Description TODO
 * @Author zhangjusheng
 * @Date 2020/12/31 16:58
 * @Version 1.0
 */
public class MySqrt3 {

    public static int mySqrt(int x) {
        int left = 0, right = x / 2 + 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (x / mid < mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }
}
