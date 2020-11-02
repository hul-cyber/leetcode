package com.zjs;

/**
 * @ClassName IsBalanced2
 * @Description 剑指Offer 55 - II 平衡二叉树 题目链接:https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * 前序遍历 + 判断深度(从顶至底)
 * @Author zhangjusheng
 * @Date 2020/11/2 23:22
 * @Version 1.0
 **/
public class IsBalanced2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        if (Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }

        return false;
    }

    public int depth(TreeNode node) {
        if (node == null)
            return 0;

        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
