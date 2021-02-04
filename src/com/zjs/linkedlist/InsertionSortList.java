package com.zjs.linkedlist;

/**
 * @ClassName InsertionSortList
 * @Description 147. 对链表进行插入排序 题目链接: https://leetcode-cn.com/problems/insertion-sort-list/
 * @Author hul-cyber
 * @Date 2021/2/4 9:08
 * @Version 1.0
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode lastSorted = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (lastSorted.val <= cur.val) {
                lastSorted = cur;
                cur = cur.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val < cur.val) {
                    prev = prev.next;
                }
                lastSorted.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
                cur = lastSorted.next;

            }
        }
        return dummyHead.next;
    }
}
