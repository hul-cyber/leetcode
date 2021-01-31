package com.zjs.linkedlist;

/**
 * @ClassName ListNode
 * @Description 链表的结点类
 * @Author hul-cyber
 * @Date 2021/1/31 19:04
 * @Version 1.0
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {};
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
