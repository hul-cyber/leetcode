package com.zjs.linkedlist;

/**
 * @ClassName IsPalindrome3
 * @Description 234. 回文链表 题目链接: https://leetcode-cn.com/problems/palindrome-linked-list/
 * 快慢指针
 * @Author hul-cyber
 * @Date 2021/2/3 11:24
 * @Version 1.0
 */
public class IsPalindrome3 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode secondHalfHead = reverseList(slow.next);
        ListNode node1 = head;
        ListNode node2 = secondHalfHead;
        while (node2 != null) {
            if (node1.val == node2.val) {
                node1 = node1.next;
                node2 = node2.next;
            } else {
                reverseList(secondHalfHead);
                return false;
            }
        }
        reverseList(secondHalfHead);
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
