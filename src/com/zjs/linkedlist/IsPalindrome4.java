package com.zjs.linkedlist;

/**
 * @ClassName IsPalindrome4
 * @Description 234. 回文链表 题目链接: https://leetcode-cn.com/problems/palindrome-linked-list/
 * 快慢指针
 * @Author hul-cyber
 * @Date 2021/2/3 14:57
 * @Version 1.0
 */
public class IsPalindrome4 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        ListNode pre = null;
        ListNode prepre = null;
        while (quick != null && quick.next != null) {
            pre = slow;
            quick = quick.next.next;
            slow = slow.next;
            pre.next = prepre;
            prepre = pre;
        }
        ListNode node1 = pre;
        ListNode node2 = slow;
        if (quick != null) {
            node2 = node2.next;
        }
        while (node1 != null) {
            if (node1.val == node2.val) {
                node1 = node1.next;
                node2 = node2.next;
            } else {
                reverseList(pre);
                pre.next = slow;
                return false;
            }
        }
        return true;
    }

    private void reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        reverseList(head.next);
        head.next.next = head;
        head.next = null;
    }
}
