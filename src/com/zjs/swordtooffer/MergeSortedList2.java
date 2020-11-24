package com.zjs.swordtooffer;

/**
 * @ClassName MergeSortedList2
 * @Description 剑指Offer25合并两个排序的链表 题目链接:https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * 递归合并 时间复杂度O(M + N) 空间复杂度O(M + N) 较短的链表的长度为M
 * @Author zhangjusheng
 * @Date 2020/10/11 10:26
 * @Version 1.0
 **/
public class MergeSortedList2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
