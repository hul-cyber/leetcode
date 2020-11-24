package com.zjs.swordtooffer;

/**
 * @ClassName MergeSortedLists1
 * @Description 剑指Offer25合并两个排序的链表 题目链接:https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * 使用一个新链表,之后将两个链表的头节点比较之后插在链表的后面 最坏情况下: 时间复杂度: O(M + N) 空间复杂度: O(1)
 * @Author zhangjusheng
 * @Date 2020/10/11 10:20
 * @Version 1.0
 **/
public class MergeSortedLists1 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pNode1 = l1;
        ListNode pNode2 = l2;

        ListNode newNode = new ListNode(-1);
        ListNode pNode = newNode;
        while (pNode1 != null && pNode2 != null) {
            if (pNode1.val <= pNode2.val) {
                pNode.next = pNode1;
                pNode1 = pNode1.next;
            } else {
                pNode.next = pNode2;
                pNode2 = pNode2.next;
            }
            pNode = pNode.next;
        }

        if (pNode1 == null) {
            pNode.next = pNode2;
        }

        if (pNode2 == null) {
            pNode.next = pNode1;
        }

        return newNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
