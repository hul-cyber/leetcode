package com.zjs.swordtooffer;

import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName TopK5
 * @Description 剑指Offer 40 最小的k个数 题目描述: https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 * 使用TreeMap
 * @Author zhangjusheng
 * @Date 2020/10/24 10:39
 * @Version 1.0
 **/
public class TopK5 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0)
            return new int[0];

        //key代表该数字, value代表该数字的个数
        TreeMap<Integer, Integer> map = new TreeMap<>();
        //记录当前元素的个数
        int curNum = 0;
        //当映射中还未充满
        while (curNum < k) {
            map.put(arr[curNum], map.getOrDefault(arr[curNum], 0) + 1);
            curNum++;
        }
        for (int i = k; i < arr.length; i++) {
            //取出最后一个键值对,即最大的数字
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if(entry.getKey() > arr[i]) {
                //如果遍历到的数字比较小
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                //将最后一个元素弹出
                if (entry.getValue() == 1)
                    map.pollLastEntry();
                else
                    map.put(entry.getKey(), entry.getValue() - 1);
            }
        }

        int[] res = new int[k];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry1 : map.entrySet()) {
            int value = entry1.getValue();
            while (value-- > 0) {
                res[index++] = entry1.getKey();
            }
        }
        return res;
    }
}
