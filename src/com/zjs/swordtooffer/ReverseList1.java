package com.zjs.swordtooffer;

/**
 * @ClassName ReverseList1
 * @Description 剑指Offer 24 反转链表 题目链接: https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 申请一个新的链表,使用头插法,最坏情况下:时间复杂度:O(n) 空间复杂度O(n)
 * @Author zhangjusheng
 * @Date 2020/10/10 12:52
 * @Version 1.0
 **/
public class ReverseList1 {
    public ListNode reverseList(ListNode head) {
        ListNode newNodeHead = new ListNode(-1);
        for (ListNode node = head; node != null; node = node.next) {
            ListNode newNode = new ListNode(node.val);
            newNode.next = newNodeHead.next;
            newNodeHead.next = newNode;
        }
        return newNodeHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
