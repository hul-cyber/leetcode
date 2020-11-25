package com.zjs.twopoints;

import com.zjs.swordtooffer.ListNode;

/**
 * @ClassName HasCycle
 * @Description 141 环形链表 题目链表: https://leetcode-cn.com/problems/linked-list-cycle/
 * 快慢指针
 * @Author zhangjusheng
 * @Date 2020/11/25 19:13
 * @Version 1.0
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slowPointer = head;
        ListNode quickPointer = head.next;
        while (slowPointer != null && quickPointer != null && quickPointer.next != null) {
            if (slowPointer == quickPointer)
                return true;
            slowPointer = slowPointer.next;
            quickPointer = quickPointer.next.next;
        }
        return false;
    }
}
