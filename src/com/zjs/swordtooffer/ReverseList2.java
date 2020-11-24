package com.zjs.swordtooffer;

/**
 * @ClassName ReverseList2
 * @Description 剑指Offer 24 反转链表 题目链接: https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * 通过迭代的方法 最坏情况下:时间复杂度:O(n) 空间复杂度O(1)
 * @Author zhangjusheng
 * @Date 2020/10/10 12:57
 * @Version 1.0
 **/
public class ReverseList2 {

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}