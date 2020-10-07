package com.zjs;

/**
 * 删除链表的节点
 * 双指针法 制造一个虚拟节点,有了虚拟节点之后,不需要考虑删除头节点的情况,所有的情况都能一并处理
 * 最坏情况下: 时间复杂度O(n) 空间复杂度O(1)
 * 题目链接: https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class DeleteNode2 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode preNode = dummyNode;
        ListNode curNode = head;
        while (curNode != null) {
            if (curNode.val == val) {
                preNode.next = curNode.next;
                break;
            }
            preNode = curNode;
            curNode = curNode.next;
        }
        return dummyNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}