package com.zjs.linkedlist;

/**
 * @ClassName IsPalindrome1
 * @Description 234. 回文链表 题目链接: https://leetcode-cn.com/problems/palindrome-linked-list/
 * 递归
 * @Author hul-cyber
 * @Date 2021/2/3 9:41
 * @Version 1.0
 */
public class IsPalindrome1 {
    ListNode outTail = null;

    public boolean isPalindrome(ListNode head) {
        int num = 0;
        for (ListNode node = head; node != null; node = node.next) {
            num++;
        }
        if (num == 0) {
            return true;
        }
        return isPalindrome(head, num);
    }

    private boolean isPalindrome(ListNode head, int num) {
        if (num == 1) {
            outTail = head.next;
            return true;
        } else if (num == 2) {
            if (head.val == head.next.val) {
                outTail = head.next.next;
                return true;
            } else {
                return false;
            }
        }
        boolean flag = isPalindrome(head.next, num - 2);
        if (flag) {
            if (outTail.val == head.val) {
                outTail = outTail.next;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
