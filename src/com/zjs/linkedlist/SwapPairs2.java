package com.zjs.linkedlist;

/**
 * @ClassName SwapPairs2
 * @Description 24. 两两交换链表中的结点 题目链接: https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * 非递归
 * @Author hul-cyber
 * @Date 2021/1/31 22:43
 * @Version 1.0
 */
public class SwapPairs2 {
    public ListNode swapPairs(ListNode head) {
        ListNode preNode = new ListNode(0);
        ListNode tmpNode = preNode;
        preNode.next = head;
        ListNode node = head;
        while (node != null && node.next != null) {
            ListNode successor = node.next.next;
            tmpNode.next = node.next;
            node.next.next = node;
            node.next = successor;
            tmpNode = node;
            node = node.next;
        }
        return preNode.next;
    }
}
