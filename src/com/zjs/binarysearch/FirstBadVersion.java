package com.zjs.binarysearch;

import com.zjs.binarysearch.VersionControl;

/**
 * @classname FirstBadVersion
 * @description 278 第一个错误的版本 题目链接：https://leetcode-cn.com/problems/first-bad-version/
 * 二分查找
 * @author uthor zhangjusheng
 * @date ate 2020/12/12 16:12
 * @version 1.0
 */
public class FirstBadVersion extends VersionControl {

    public int firstBadVersion(int n) {
        // 设置查找范围[1, n]
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                // 查找范围设置为[mid + 1, right]
                left = mid + 1;
            } else {
                // 查找范围设置为[left, mid]
                right = mid;
            }
        }
        return left;
    }
}
