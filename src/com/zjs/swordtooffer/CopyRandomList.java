package com.zjs.swordtooffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName com.zjs.leetcode.CopyRandomList
 * @Description 剑指Offer 35 复杂链表的复制
 * @Author zhangjusheng
 * @Date 2020/10/15 14:20
 * @Version 1.0
 **/
public class CopyRandomList {
    /*
     * 制造一个虚拟节点,将第一个节点的位置保留下来
     * 1. 通过next构建新链表
     * 尾插法,新进来的节点从后面插入
     * ---------------------------------------
     * 2. 填充random中的信息
     *
     * next 是一个连接链,random 又组成了另外的关系,next 组成的连接链能够把所有的节点串联起来,根据next链
     * 的信息将random的信息补充完整。
     * 使用一个map将新建的链表中每个节点的位置记录下来,原来链表的每个节点的位置信息也要记录下来,
     * 存储旧链表的map存储的为<Node, Integer>,能够通过random找到相应的下标,对于新链表的map中
     * 存储的为<Integer, Node>,能够通过下标找出在random中应该存储的Node.
     */
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Node virtualNode = new Node(-1);
        Node preNode = virtualNode;
        Map<Node, Integer> oldNodes = new HashMap<>();
        Map<Integer, Node> newNodes = new HashMap<>();
        int num = 0;

        for (Node node = head; node != null; node = node.next) {
            Node newNode = new Node(node.val);
            oldNodes.put(node, num);
            newNodes.put(num, newNode);
            num++;
            preNode.next = newNode;
            preNode = newNode;
        }

        Node oldStartNode = head;
        Node newStartNode = virtualNode.next;

        while (oldStartNode != null && newStartNode != null) {
            if (oldStartNode.random != null) {
                Integer index = oldNodes.get(oldStartNode.random);
                newStartNode.random = newNodes.get(index);
            }
            oldStartNode = oldStartNode.next;
            newStartNode = newStartNode.next;
        }

        return virtualNode.next;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
