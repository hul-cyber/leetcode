package com.zjs.greedyalgorithm;

/**
 * @ClassName CanPlaceFlowers
 * @Description 605 种花问题 题目链接：https://leetcode-cn.com/problems/can-place-flowers/
 * 贪心算法
 * @Author zhangjusheng
 * @Date 2020/12/4 22:03
 * @Version 1.0
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int num = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (check(flowerbed, i)) {
                flowerbed[i] = 1;
                num++;
            }
        }
        return num >= n;
    }

    // 检查是否可以种花
    public boolean check(int[] flowerbed, int i) {
        if ((i == 0 || flowerbed[i - 1] == 0) && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)
                && flowerbed[i] == 0) {
            return true;
        }
        return false;
    }
}
