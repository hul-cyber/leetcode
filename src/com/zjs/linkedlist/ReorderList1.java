package com.zjs.linkedlist;

/**
 * @ClassName ReorderList1
 * @Description 143. 重排列表 题目链接: https://leetcode-cn.com/problems/reorder-list/
 * 递归
 * @Author hul-cyber
 * @Date 2021/2/1 9:53
 * @Version 1.0
 */
public class ReorderList1 {
    ListNode newHead = null;
    ListNode newTail = null;

    public void reorderList(ListNode head) {
        int num = 0;
        for (ListNode node = head; node != null; node = node.next) {
            num++;
        }
        if (num == 0) {
            return;
        }
        reorderList(head, num);
    }

    // 排列从head开始的n个结点，并返回新的头节点
    private void reorderList(ListNode head, int n) {
        if (n == 1) {
            newHead = head;
            newTail = head;
            return;
        } else if (n == 2) {
            newHead = head;
            newTail = head.next;
            return;
        }
        reorderList(head.next, n - 2);
        head.next = newTail.next;
        newTail.next = newTail.next.next;
        head.next.next = newHead;
        newHead = head;
    }
}
