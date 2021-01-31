package com.zjs.linkedlist;

/**
 * @ClassName SwapPairs1
 * @Description 24. 两两交换链表中的结点 题目链接: https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 递归
 * @Author hul-cyber
 * @Date 2021/1/31 22:11
 * @Version 1.0
 */
public class SwapPairs1 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode successor = swapPairs(head.next.next);
        ListNode newHead = head.next;
        head.next.next = head;
        head.next = successor;
        return newHead;
    }
}
