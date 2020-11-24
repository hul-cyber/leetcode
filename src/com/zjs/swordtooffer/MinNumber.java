package com.zjs.swordtooffer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName MinNumber
 * @Description 剑指Offer 45 把数组排成最小的数 题目链接：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
 * 使用优先级队列实现(一直没通过)
 * @Author zhangjusheng
 * @Date 2020/10/26 22:49
 * @Version 1.0
 **/
public class MinNumber {
    public static void main(String[] args) {
        MinNumber minNumber = new MinNumber();
        //[74,21,33,51,77,51,90,60,5,56]
        int[] nums = {51, 51, 5, 56};
        System.out.println(minNumber.minNumber(nums));
        StringBuilder sb = new StringBuilder("55");
    }

    public String minNumber(int[] nums) {
        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();

            @Override
            public int compare(String o1, String o2) {
                int index = 0;
                while (index < o1.length() && index < o2.length()) {
                    //逐一比较
                    char a = o1.charAt(index);
                    char b = o2.charAt(index);

                    if (a != b) {
                        return a - b;
                    } else {
                        index++;
                    }
                }

                //将两个字符串拼接起来
                sb1.append(o1).append(o2);
                sb2.append(o2).append(o1);

                //将两个字符串进行比较
                index = 0;
                while (index < sb1.length()) {
                    char a = sb1.charAt(index);
                    char b = sb2.charAt(index);

                    if (a > b) {
                        //说明应该将o2放到前面
                        return 1;
                    } else if (a < b) {
                        //说明应该将o1放到前面
                        return -1;
                    } else {
                        index++;
                    }
                }

                //遍历完之后,发现完全相同
                return 0;
            }
        });

        for (int i = 0; i < nums.length; i++) {
            queue.offer(String.valueOf(nums[i]));
        }

        StringBuilder sb = new StringBuilder();
        while (queue.size() != 0) {
            sb.append(queue.poll());
        }

        return sb.toString();
    }
}