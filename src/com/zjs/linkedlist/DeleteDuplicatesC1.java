package com.zjs.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DeleteDuplicatesC1
 * @Description 82. 删除排序链表中的重复元素 II 题目链接: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 虚拟头结点
 * @Author hul-cyber
 * @Date 2021/2/11 13:21
 * @Version 1.0
 */
public class DeleteDuplicatesC1 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = dummyNode;
        while (curNode.next != null && curNode.next.next != null) {
            if (curNode.next.val == curNode.next.next.val) {
                ListNode temp = curNode.next;
                while (temp.next != null && temp.val == temp.next.val) {
                    temp = temp.next;
                }
                curNode.next = temp.next;
            } else {
                curNode = curNode.next;
            }
        }
        return dummyNode.next;
    }
}
