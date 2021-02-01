package com.zjs.linkedlist;

/**
 * @ClassName RotateRight1
 * @Description 61. 旋转链表 题目链接: https://leetcode-cn.com/problems/rotate-list/
 * 递归
 * @Author hul-cyber
 * @Date 2021/2/1 19:50
 * @Version 1.0
 */
public class RotateRight1 {
    public ListNode rotateRight(ListNode head, int k) {
        return rotateRight(head, head, k, new int[2]);
    }

    private ListNode rotateRight(ListNode node, ListNode head, int k, int[] n) {
        n[0]++;
        if (node == null || node.next == null) {
            return node;
        }
        ListNode rNode = rotateRight(node.next, head, k, n);
        if (k % n[0] == 0) {
            return head;
        }
        if (n[1] == 0) {
            rNode.next = head;
        }
        n[1]++;
        if (n[1] == k % n[0] - 1) {
            return node;
        } else if (n[1] == k % n[0]) {
            node.next = null;
        }
        return rNode;
    }
}
