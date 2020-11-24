package com.zjs.swordtooffer;

/**
 * @ClassName GetIntersectionNode2
 * @Description 剑指Offer 52 两个链表的第一个公共节点 题目链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * 浪漫相遇法
 * @Author zhangjusheng
 * @Date 2020/11/2 10:38
 * @Version 1.0
 **/
public class GetIntersectionNode2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int numOfLaps = 0;

        while (nodeA != nodeB) {
            if (numOfLaps == 3) {
                return null;
            }

            if (nodeA.next == null) {
                nodeA = headB;
                numOfLaps++;
            } else {
                nodeA = nodeA.next;
            }

            if (nodeB.next == null) {
                nodeB = headA;
            } else {
                nodeB = nodeB.next;
            }
        }

        return nodeA;
    }
}
