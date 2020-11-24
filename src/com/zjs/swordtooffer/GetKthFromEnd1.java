package com.zjs.swordtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GetKthFromEnd1
 * @Description 剑指Offer22 链表中倒数第k个节点 题目链接:https://leetcode-cn.com/problems
 * /lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * 申请一个ArrayList,将整个链表存储进去,之后根据数组下标找出指定元素,时间复杂度O(n) 空间复杂度O(n)
 * @Author zhangjusheng
 * @Date 2020/10/10 9:54
 * @Version 1.0
 **/
public class GetKthFromEnd1 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k == 0)
            return null;
        List<ListNode> list = new ArrayList<ListNode>();
        for (ListNode l = head; l != null; l = l.next) {
            list.add(l);
        }
        return list.get(list.size() - k);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
