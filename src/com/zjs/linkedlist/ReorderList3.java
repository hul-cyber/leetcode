package com.zjs.linkedlist;

/**
 * @ClassName ReorderList3
 * @Description 143. 重排列表 题目链接: https://leetcode-cn.com/problems/reorder-list/
 * 递归的另一种做法
 * @Author hul-cyber
 * @Date 2021/2/1 16:09
 * @Version 1.0
 */
public class ReorderList3 {
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
    private ListNode reorderList(ListNode head, int n) {
        if (n == 1) {
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        }
        if (n == 2) {
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }
        ListNode tail = reorderList(head.next, n - 2);
        ListNode outTail = tail.next;
        tail.next = head.next;
        head.next = tail;
        return outTail;
    }
}
