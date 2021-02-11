package com.zjs.linkedlist;

/**
 * @ClassName Partition
 * @Description 86. 分隔链表 题目链接: https://leetcode-cn.com/problems/partition-list/
 * 虚拟头结点
 * @Author hul-cyber
 * @Date 2021/2/11 15:22
 * @Version 1.0
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyNode1 = new ListNode(-1);
        ListNode dummyNode2 = new ListNode(-1);
        ListNode node1 = dummyNode1;
        ListNode node2 = dummyNode2;
        for (ListNode node = head; node != null; node = node.next) {
            if (node.val < x) {
                node1.next = node;
                node1 = node1.next;
            } else {
                node2.next = node;
                node2 = node2.next;
            }
        }
        node2.next = null;
        node1.next = dummyNode2.next;
        return dummyNode1.next;
    }
}
