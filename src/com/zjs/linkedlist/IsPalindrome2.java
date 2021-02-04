package com.zjs.linkedlist;

/**
 * @ClassName IsPalindrome2
 * @Description 234. 回文链表 题目链接: https://leetcode-cn.com/problems/palindrome-linked-list/
 * 递归
 * @Author hul-cyber
 * @Date 2021/2/3 10:12
 * @Version 1.0
 */
public class IsPalindrome2 {
    ListNode frontPointer = null;

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    private boolean recursivelyCheck(ListNode currentPointer) {
        if (currentPointer != null) {
            if (!recursivelyCheck(currentPointer.next)) return false;
            if (currentPointer.val != frontPointer.val) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }
}
