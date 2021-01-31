package com.zjs.linkedlist;

/**
 * @ClassName ReverseBetween1
 * @Description 92. 反转链表II 题目链接: https://leetcode-cn.com/problems/reverse-linked-list-ii/
 * 迭代
 * @Author hul-cyber
 * @Date 2021/1/31 20:10
 * @Version 1.0
 */
public class ReverseBetween1 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int index = 0;
        ListNode curNode = head;
        ListNode preNode = null;
        ListNode nextNode = null;
        while (index < m - 1) {
            preNode = curNode;
            curNode = curNode.next;
            index++;
        }
        ListNode connectedNode1 = preNode;
        ListNode connectedNode2 = curNode;
        while (index <= n - 1) {
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
            index++;
        }
        connectedNode2.next = curNode;
        if (connectedNode1 != null) {
            connectedNode1.next = preNode;
        } else {
            head = preNode;
        }
        return head;
    }
}
