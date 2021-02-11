package com.zjs.linkedlist;

/**
 * @ClassName MergeTwoLists
 * @Description 21. 合并两个有序链表 题目链接: https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 虚拟头结点
 * @Author hul-cyber
 * @Date 2021/2/11 12:18
 * @Version 1.0
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode node = dummyNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        node.next = l1 != null ? l1 : l2;
        return dummyNode.next;
    }
}
