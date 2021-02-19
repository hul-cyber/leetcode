package com.zjs.linkedlist;

/**
 * @ClassName RemoveNthFromEnd2
 * @Description 19. 删除链表的倒数第N个结点 题目链接: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 快慢指针
 * @Author hul-cyber
 * @Date 2021/2/11 15:39
 * @Version 1.0
 */
public class RemoveNthFromEnd2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode quick = dummyNode;
        for (int i = 0; i < n; i++) {
            quick = quick.next;
        }
        while (quick.next != null) {
            slow = slow.next;
            quick = quick.next;
        }
        ListNode deleteNode = slow.next;
        slow.next = slow.next.next;
        deleteNode.next = null;
        return dummyNode.next;
    }
}
