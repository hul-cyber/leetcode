package com.zjs.linkedlist;

/**
 * @ClassName MiddleNode
 * @Description 876. 链表的中间结点 题目链接: https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * 快慢指针
 * @Author hul-cyber
 * @Date 2021/2/11 15:45
 * @Version 1.0
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }
}
