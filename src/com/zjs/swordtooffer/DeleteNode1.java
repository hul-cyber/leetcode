package com.zjs.swordtooffer;

/**
 * 删除链表的节点
 * 暴力法遍历删除
 * 最坏情况下: 时间复杂度O(n) 空间复杂度O(1)
 * 题目链接: https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class DeleteNode1 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode preNode = new ListNode(0);
        preNode.next = head;
        for (ListNode node = head; node != null; node = node.next, preNode = preNode.next) {
            if (node.val == val) {
                if (node == head) {
                    head = head.next;
                } else {
                    preNode.next = node.next;
                }
                break;
            }
        }
        return head;
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
}
