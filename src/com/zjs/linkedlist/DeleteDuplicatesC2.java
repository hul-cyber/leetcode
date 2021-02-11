package com.zjs.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName DeleteDuplicatesC2
 * @Description 82. 删除排序链表中的重复元素 II 题目链接: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 哈希表
 * @Author hul-cyber
 * @Date 2021/2/11 13:52
 * @Version 1.0
 */
public class DeleteDuplicatesC2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Map<Integer, Integer> freqs = new LinkedHashMap<>();
        for (ListNode node = head; node != null; node = node.next) {
            freqs.put(node.val, freqs.getOrDefault(node.val, 0) + 1);
        }
        ListNode dummyNode = new ListNode(-1);
        ListNode node = dummyNode;
        for (int i : freqs.keySet()) {
            if (freqs.get(i) == 1) {
                node.next = new ListNode(i);
                node = node.next;
            }
        }
        return dummyNode.next;
    }
}
