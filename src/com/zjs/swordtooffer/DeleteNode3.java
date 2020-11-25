package com.zjs.swordtooffer;

/**
 * 删除链表的节点
 * 递归解决
 * 最坏情况下: 时间复杂度O(n) 空间复杂度O(1)
 * 题目链接: https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class DeleteNode3 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null)
            return head;
        if (head.val == val)
            return head.next;
        head.next = deleteNode(head.next, val);
        return head;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
        Integer i = (int) Math.sqrt(Integer.MAX_VALUE) + 1;
        System.out.println(i);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}