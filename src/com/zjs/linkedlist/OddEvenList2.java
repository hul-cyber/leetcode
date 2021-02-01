package com.zjs.linkedlist;

/**
 * @ClassName OddEvenList2
 * @Description 328. 奇偶链表 题目链接: https://leetcode-cn.com/problems/odd-even-linked-list/
 * 递归
 * @Author hul-cyber
 * @Date 2021/2/1 15:17
 * @Version 1.0
 */
public class OddEvenList2 {
    public ListNode oddEvenList(ListNode head) {
        recur(head);
        return head;
    }

    // 获取已经排好序的奇数链表的尾节点
    private ListNode recur(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode tail = recur(head.next.next);
        ListNode tempNode = head.next;
        head.next = head.next.next;
        tempNode.next = tail.next;
        tail.next = tempNode;
        return tail;
    }
}
