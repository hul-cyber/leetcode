package com.zjs.linkedlist;

/**
 * @ClassName ReverseBetween2
 * @Description 92. 反转链表II 题目链接: https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 递归
 * @Author hul-cyber
 * @Date 2021/1/31 21:05
 * @Version 1.0
 */
public class ReverseBetween2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    // 反转从head开始的n个元素,并返回反转结束后链表的首元素
    ListNode successor = null;

    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
}
