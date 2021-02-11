package com.zjs.linkedlist;

/**
 * @ClassName DeleteDuplicatesC3
 * @Description 82. 删除排序链表中的重复元素 II 题目链接: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 双指针
 * @Author hul-cyber
 * @Date 2021/2/11 14:47
 * @Version 1.0
 */
public class DeleteDuplicatesC3 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode p = dummyNode;
        ListNode q = head;
        while (q != null && q.next != null) {
            if (p.next.val == q.next.val) {
                while (q.next != null && p.next.val == q.next.val) {
                    q = q.next;
                }
                p.next = q.next;
            } else {
                p = p.next;
            }
            q = q.next;
        }
        return dummyNode.next;
    }
}
