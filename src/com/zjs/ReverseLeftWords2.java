package com.zjs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName ReverseLeftWords2
 * @Description
 * @Author zhangjusheng
 * @Date 2020/11/12 23:32
 * @Version 1.0
 **/
public class ReverseLeftWords2 {
    int start;
    int end;

    public static void main(String[] args) {
        ReverseLeftWords2 reverseLeftWords2 = new ReverseLeftWords2();
        int[] nums = {9,10,9,-7,-4,-8,2,-6};
        int[] res = reverseLeftWords2.maxSlidingWindow(nums, 5);
        for (int i = 0; i < res.length; i++)
            System.out.println(res[i]);
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || nums.length == 0)
            return null;

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        start = 0;
        end = k - 1;

        for (int i = 0; i < k; i++)
            if (deque.size() == 0)
                deque.offer(nums[0]);
            else {
                if ((int) deque.peekLast() <= nums[i]) {
                    while(deque.size() != 0 && (int) deque.peekLast() < nums[i])
                        deque.pollLast();
                    deque.offer(nums[i]);
                } else {
                    deque.offer(nums[i]);
                }
            }

        while (start <= nums.length - k) {
            if (deque.size() == 0)
                deque.offer(nums[start]);
            else
                cleanDeque(deque, nums, list);
        }

        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);

        return res;
    }

    public void cleanDeque(Deque deque, int[] nums, List list) {
        list.add(deque.peek());

        //移动左边
        int i = (int) deque.peek();
        if (i == nums[start])
            deque.pop();
        start++;

        //移动右边
        end++;
        if (end < nums.length) {
            if (deque.size() != 0) {
                if ((int) deque.peekLast() <= nums[end]) {
                    while (deque.size() != 0 && (int) deque.peekLast() < nums[end])
                        deque.pollLast();
                }
            }
            deque.offer(nums[end]);
        }
    }
}
