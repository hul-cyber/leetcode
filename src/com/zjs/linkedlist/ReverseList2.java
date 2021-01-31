package com.zjs.linkedlist;

/**
 * @ClassName ReverseList2
 * @Description 206. 反转链表 题目链接: https://leetcode-cn.com/problems/reverse-linked-list/
 * 迭代
 * @Author hul-cyber
 * @Date 2021/1/31 19:07
 * @Version 1.0
 */
public class ReverseList2 {
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;
        ListNode nextNode = null;
        for (ListNode node = head; node != null; ) {
            nextNode = node.next;
            node.next = preNode;
            preNode = node;
            node = nextNode;
        }
        return preNode;
    }
}
