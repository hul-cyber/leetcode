package com.zjs.linkedlist;

/**
 * @ClassName GetIntersectionNode1
 * @Description 160. 相交链表 题目链接: https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * 剪短较长的链表
 * @Author hul-cyber
 * @Date 2021/2/19 15:50
 * @Version 1.0
 */
public class GetIntersectionNode1 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 首先遍历获取两个链表的长度
        ListNode node1 = headA;
        ListNode node2 = headB;
        int count1 = 0;
        int count2 = 0;
        while (node1 != null) {
            node1 = node1.next;
            count1++;
        }
        while (node2 != null) {
            node2 = node2.next;
            count2++;
        }
        int index = 0;
        if (count2 < count1) {
            while (index < count1 - count2) {
                index++;
                headA = headA.next;
            }
        } else {
            while (index < count2 - count1) {
                index++;
                headB = headB.next;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headB;
    }
}
