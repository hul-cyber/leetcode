package com.zjs.linkedlist;

/**
 * @ClassName OddEvenList1
 * @Description 328. 奇偶链表 题目链接: https://leetcode-cn.com/problems/odd-even-linked-list/
 * @Author hul-cyber
 * @Date 2021/2/1 15:16
 * @Version 1.0
 */
public class OddEvenList1 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
