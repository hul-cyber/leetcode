package com.zjs.linkedlist;

/**
 * @ClassName RemoveElements
 * @Description 203. 移除链表元素 题目链接: https://leetcode-cn.com/problems/remove-linked-list-elements/
 * 添加哨兵结点
 * @Author hul-cyber
 * @Date 2021/1/31 21:34
 * @Version 1.0
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode virtualNode = new ListNode(-1, head);
        ListNode curNode = head;
        ListNode preNode = virtualNode;
        while (curNode != null) {
            if (curNode.val == val) {
                preNode.next = curNode.next;
            } else {
                preNode = curNode;
            }
            curNode = curNode.next;
        }
        return virtualNode.next;
    }
}
