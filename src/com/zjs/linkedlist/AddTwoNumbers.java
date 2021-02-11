package com.zjs.linkedlist;

/**
 * @ClassName AddTwoNumbers
 * @Description 2. 两数相加 题目链接: https://leetcode-cn.com/problems/add-two-numbers/
 * 虚拟头结点
 * @Author hul-cyber
 * @Date 2021/2/11 10:49
 * @Version 1.0
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode node = dummyNode;
        int sum = 0;
        boolean array = false;
        while (l1 != null || l2 != null) {
            sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            if (array) {
                sum += 1;
            }
            node.next = new ListNode(sum % 10);
            array = sum >= 10 ? true : false;
            node = node.next;
        }
        if (array) {
            node.next = new ListNode(1);
        }
        return dummyNode.next;
    }
}
