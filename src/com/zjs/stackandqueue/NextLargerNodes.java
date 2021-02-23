package com.zjs.stackandqueue;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName NextLargerNodes
 * @Description 1019. 链表中的下一个更大的节点 题目链接: https://leetcode-cn.com/problems/next-greater-node-in-linked-list/
 * 单调栈
 * @Author hul-cyber
 * @Date 2021/2/23 13:32
 * @Version 1.0
 */
public class NextLargerNodes {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next) {
            list.add(node.val);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[list.size()];
        for (int i = list.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && list.get(stack.peekLast()) <= list.get(i)) {
                stack.removeLast();
            }
            res[i] = stack.isEmpty() ? 0 : list.get(stack.peekLast());
            stack.addLast(i);
        }
        return res;
    }
}
