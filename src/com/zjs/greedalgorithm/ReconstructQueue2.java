package com.zjs.greedalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ReconstructQueue2
 * @Description 406 根据身高重建队列 题目链接：https://leetcode-cn.com/problems/queue-reconstruction-by-height/description/
 * 从高到低考虑
 * @Author zhangjusheng
 * @Date 2020/12/3 23:46
 * @Version 1.0
 */
public class ReconstructQueue2 {

    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0)
            return new int[0][0];
        // 对队列中的元素进行排序
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        // 插入法
        List<int[]> ans = new ArrayList<>(people.length);
        for (int[] p : people) {
            ans.add(p[1], p);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
