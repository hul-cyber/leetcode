package com.zjs.linkedlist;

/**
 * @ClassName GetIntersectionNode2
 * @Description 160. 相交链表 题目链接: https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 通过补长链表的方式让两个链表等长
 * @Author hul-cyber
 * @Date 2021/2/19 16:29
 * @Version 1.0
 */
public class GetIntersectionNode2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode head1 = headA;
        ListNode head2 = headB;
        while (head1 != head2) {
            if (head1 == null) {
                head1 = headB;
            } else {
                head1 = head1.next;
            }
            if (head2 == null) {
                head2 = headA;
            } else {
                head2 = head2.next;
            }
        }
        return head1;
    }
}
