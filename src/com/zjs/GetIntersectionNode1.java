package com.zjs;

import java.util.Stack;

/**
 * @ClassName GetIntersectionNode1
 * @Description 剑指Offer 52 两个链表的第一个公共节点 题目链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * 使用栈实现
 * @Author zhangjusheng
 * @Date 2020/11/2 0:29
 * @Version 1.0
 **/
public class GetIntersectionNode1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != null) {
            stackA.push(nodeA);
            nodeA = nodeA.next;
        }

        while (nodeB != null) {
            stackB.push(nodeB);
            nodeB = nodeB.next;
        }

        ListNode pre = null;
        while (!stackA.empty() && !stackB.empty()) {
            nodeA = stackA.pop();
            nodeB = stackB.pop();

            if (nodeB != nodeA) {
                break;
            } else {
                pre = nodeA;
            }
        }

        return pre;
    }
}
