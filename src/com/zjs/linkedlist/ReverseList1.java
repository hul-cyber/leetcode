package com.zjs.linkedlist;

/**
 * @ClassName ReverseList1
 * @Description 206. 反转链表 题目链接: https://leetcode-cn.com/problems/reverse-linked-list/
 * 递归
 * @Author hul-cyber
 * @Date 2021/1/31 19:03
 * @Version 1.0
 */
public class ReverseList1 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        ListNode newHead = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHead;
    }
}
