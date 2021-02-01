package com.zjs.linkedlist;

/**
 * @ClassName ReorderList2
 * @Description 143. 重排列表 题目链接: https://leetcode-cn.com/problems/reorder-list/
 * 快慢指针
 * @Author hul-cyber
 * @Date 2021/2/1 14:31
 * @Version 1.0
 */
public class ReorderList2 {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode quick = head;
        ListNode slow = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        newHead = reverseList(newHead);
        ListNode temp = null;
        while (newHead != null) {
            temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }
    }

    // 反转链表
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
