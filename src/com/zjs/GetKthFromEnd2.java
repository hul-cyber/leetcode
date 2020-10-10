package com.zjs;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GetKthFromEnd2
 * @Description 剑指Offer22 链表中倒数第k个节点 题目链接:https://leetcode-cn.com/problems
 * /lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 双指针解决此问题,最坏情况下: 时间复杂度O(n) 空间复杂度O(1)
 * @Author zhangjusheng
 * @Date 2020/10/10 10:00
 * @Version 1.0
 **/
public class GetKthFromEnd2 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0)
            return null;
        ListNode ahead = head;
        ListNode behind = head;
        for (int i = 0; i < k - 1; i++) {
            if (ahead.next != null)
                ahead = ahead.next;
            else
                return null;
        }
        while (ahead.next != null) {
            behind = behind.next;
            ahead = ahead.next;
        }
        return behind;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
