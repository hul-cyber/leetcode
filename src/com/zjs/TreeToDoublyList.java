package com.zjs;

/**
 * @ClassName TreeToDoublyList
 * @Description 剑指Offer 36二叉搜索树与双向链表 题目链接: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * 使用中序遍历来遍历该二叉搜索树,在遍历过程中修改链表之间的链接关系
 * @Author zhangjusheng
 * @Date 2020/10/18 14:54
 * @Version 1.0
 **/
public class TreeToDoublyList {
    static Node head, tail;

    public static Node treeToDoublyList(Node root) {
        middleOrder(root, null);

        head.left = tail;
        tail.right = head;

        return head;
    }

    public static void middleOrder(Node cur, Node pre) {
        if (cur == null)
            return;

        if (cur.left != null) {
            middleOrder(cur.left, pre);
        }

        if (pre != null) {
            cur.left = pre;
            pre.right = cur;
            pre = cur;
            tail = cur;
        } else {
            head = cur;
            pre = cur;
            tail = cur;
        }

        if (cur.right != null)
            middleOrder(cur.right, pre);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
}
