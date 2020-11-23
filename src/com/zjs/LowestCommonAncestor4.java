package com.zjs;

/**
 * @ClassName LowestCommonAncestor4
 * @Description 剑指Offer 68 - ii 二叉树的最近公共祖先,题目链接:https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * 递归
 * @Author zhangjusheng
 * @Date 2020/11/23 16:52
 * @Version 1.0
 */
public class LowestCommonAncestor4 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
