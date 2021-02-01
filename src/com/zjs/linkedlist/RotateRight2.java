package com.zjs.linkedlist;

/**
 * @ClassName RotateRight2
 * @Description 61. 旋转链表 题目链接: https://leetcode-cn.com/problems/rotate-list/
 * @Author hul-cyber
 * @Date 2021/2/1 19:52
 * @Version 1.0
 */
public class RotateRight2 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int num = 0;
        ListNode node = head;
        while (true) {
            num++;
            if (node.next == null) {
                node.next = head;
                break;
            } else {
                node = node.next;
            }
        }
        int index = 0;
        node = head;
        k = num - (k % num);
        while (index < k - 1) {
            node = node.next;
            index++;
        }
        ListNode res = node.next;
        node.next = null;
        return res;
    }
}
