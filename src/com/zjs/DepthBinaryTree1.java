package com.zjs;

/**
 * @ClassName DepthBinaryTree1
 * @Description 剑指Offer55-1 二叉树的深度 题目链接:https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * 深度优先遍历
 * @Author zhangjusheng
 * @Date 2020/11/2 23:14
 * @Version 1.0
 **/
public class DepthBinaryTree1 {
    int maxDepth = 0;
    int curDepth = 0;

    public int maxDepth(TreeNode root) {
        dfs(root);
        return maxDepth;
    }

    public void dfs(TreeNode node) {
        if (node == null)
            return;

        curDepth++;

        if (maxDepth < curDepth) {
            maxDepth = curDepth;
        }

        dfs(node.left);
        dfs(node.right);

        curDepth--;
    }
}
