package com.zjs.greedalgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName ReconstructQueue1
 * @Description 406 根据身高重建队列 题目链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height/description/
 * 先排队后插队
 * @Author zhangjusheng
 * @Date 2020/12/3 0:21
 * @Version 1.0
 */
public class ReconstructQueue1 {

    public int[][] reconstructQueue(int[][] people) {
        // 进行排序
        Arrays.sort(people, new Comparator<int[]>() {

            @Override
            public int compare(int[] a, int[] b) {
                // 首先按照身高进行排序
                if (a[0] > b[0]) {
                    return 1;
                } else if (a[0] < b[0]) {
                    return -1;
                } else {
                    // 按照第二属性进行排序
                    if (a[1] > b[1]) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        // 进行插队
        int end = people.length;
        int index = 0;
        for (int i = end - 1; i >= 0; i--) {
            index = 0;
            int curElement = people[i][1];
            for (int j = i + 1; j < end; j++) {
                if (index == curElement) {
                    break;
                }
                index++;
                int[] temp = people[j];
                people[j] = people[j - 1];
                people[j - 1] = temp;
            }
        }
        return people;
    }
}
