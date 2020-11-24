package com.zjs.swordtooffer;

/**
 * @ClassName LowestCommonAncestor2
 * @Description 剑指Offer 68-1 二叉搜索树的最近公共祖先 题目链接: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * 迭代
 * @Author zhangjusheng
 * @Date 2020/11/23 16:01
 * @Version 1.0
 */
public class LowestCommonAncestor2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 保证p节点小于等于q节点
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        while(root != null) {
            if (root.val < p.val) {
                // 两个节点在右子树
                root = root.right;
            } else if (root.val > q.val) {
                // 两个节点在左子树
                root = root.left;
            } else {
                // 两个节点属于不同的树
                break;
            }
        }
        return root;
    }
}
