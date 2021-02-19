package com.zjs.linkedlist;

/**
 * @ClassName HasCycle
 * @Description 141. 环形链表 题目链接: https://leetcode-cn.com/problems/linked-list-cycle/
 * 快慢指针
 * @Author hul-cyber
 * @Date 2021/2/18 20:06
 * @Version 1.0
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode quickNode = head;
        ListNode slowNode = head;
        while (quickNode != null && quickNode.next != null) {
            quickNode = quickNode.next.next;
            slowNode = slowNode.next;
            if (quickNode == slowNode) {
                return true;
            }
        }
        return false;
    }
}
