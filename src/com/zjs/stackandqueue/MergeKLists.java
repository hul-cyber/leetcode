package com.zjs.stackandqueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName MergeKLists
 * @Description 23. 合并K个升序链表 题目链接: https://leetcode-cn.com/problems/merge-k-sorted-lists/
 * 优先队列
 * @Author hul-cyber
 * @Date 2021/2/25 16:36
 * @Version 1.0
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len == 0) {
            return null;
        }
        Queue<ListNode> minHeap = new PriorityQueue<>(len, Comparator.comparingInt((ListNode x) -> x.val).reversed());
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode node = dummyNode;
        while (!minHeap.isEmpty()) {
            ListNode nextNode = minHeap.poll();
            node.next = nextNode;
            if (nextNode.next != null) {
                minHeap.offer(nextNode.next);
            }
            node = node.next;
        }
        return dummyNode.next;
    }
}
