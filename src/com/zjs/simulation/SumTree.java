package com.zjs.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @ClassName SumTree
 * @Description 将满二叉树转化为求和树 题目链接：https://www.nowcoder.com/practice/b31734e46ba644de85a9cf95bbd57a5f?tpId=131
 * &&tqId=33819&rp=1&ru=/ta/exam-kuaishou&qru=/ta/exam-kuaishou/question-ranking
 * 模拟 + 递归
 * @Author zhangjusheng
 * @Date 2020/12/30 19:20
 * @Version 1.0
 */
public class SumTree {

    public static int nextCount(int start, int end, int[] nums) {
        if (start == end) {
            int temp = nums[start];
            nums[start] = 0;
            return temp;
        }
        int pivot = start + (end - start) / 2;
        int temp = nums[pivot];
        nums[pivot] = nextCount(start, pivot - 1, nums) + nextCount(pivot + 1, end, nums);
        return nums[pivot] + temp;
    }
}
