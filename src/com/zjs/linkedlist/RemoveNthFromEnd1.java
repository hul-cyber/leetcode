package com.zjs.linkedlist;

/**
 * @ClassName RemoveNthFromEnd1
 * @Description 19. 删除链表的倒数第N个结点 题目链接: https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 * 虚拟头结点
 * @Author hul-cyber
 * @Date 2021/2/11 9:24
 * @Version 1.0
 */
public class RemoveNthFromEnd1 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 统计链表节点的个数
        int sum = 0;
        ListNode node1 = head;
        while (node1 != null) {
            sum++;
            node1 = node1.next;
        }
        // 设置头节点
        ListNode virtualNode = new ListNode(0);
        virtualNode.next = head;
        int index = 0;
        int num = sum - n;
        ListNode node2 = virtualNode;
        while (index < num) {
            node2 = node2.next;
            index++;
        }
        ListNode deleteNode = node2.next;
        node2.next = deleteNode.next;
        deleteNode.next = null;
        return virtualNode.next;
    }
}
