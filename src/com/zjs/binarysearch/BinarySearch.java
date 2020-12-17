package com.zjs.binarysearch;

/**
 * @ClassName BinarySearch
 * @Description 二分查找正常实现及其变种实现
 * @Author zhangjusheng
 * @Date 2020/12/6 23:35
 * @Version 1.0
 */
public class BinarySearch {

    public static int binarySearch(int[] nums, int key) {
        int left = 0, right = nums.length - 1, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 变式：查找key的最左边界
    /*public static int binarySearch(int[] nums, int key) {
        int left = 0, right = nums.length, mid;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (nums[mid] >= key) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }*/
}
