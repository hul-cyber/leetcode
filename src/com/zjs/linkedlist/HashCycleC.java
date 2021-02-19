package com.zjs.linkedlist;

/**
 * @ClassName HashCycleC
 * @Description 142. 环形链表 II 题目链接: https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 快慢指针 + 数学
 * @Author hul-cyber
 * @Date 2021/2/18 21:16
 * @Version 1.0
 */
public class HashCycleC {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slowNode = head;
        ListNode quickNode = head;
        while (quickNode != null && quickNode.next != null) {
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
            if (quickNode == slowNode) {
                quickNode = head;
                while (quickNode != slowNode) {
                    quickNode = quickNode.next;
                    slowNode = slowNode.next;
                }
                return slowNode;
            }
        }
        return null;
    }
}
