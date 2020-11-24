package com.zjs.swordtooffer;

/**
 * @ClassName LowestCommonAncestor3
 * @Description 剑指Offer 68-1 二叉搜索树的最近公共祖先 题目链接: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * 递归
 * @Author zhangjusheng
 * @Date 2020/11/23 16:01
 * @Version 1.0
 */
public class LowestCommonAncestor3 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            // 如果在左子树
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            // 如果在右子树
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
