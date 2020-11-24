package com.zjs.swordtooffer;

/**
 * @ClassName IsBalanced1
 * @Description 剑指Offer 55 - II 平衡二叉树 题目链接:https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
 * 后序遍历 + 剪枝(从底至顶)
 * @Author zhangjusheng
 * @Date 2020/11/2 23:19
 * @Version 1.0
 **/
public class IsBalanced1 {
    public boolean isBalanced(TreeNode root) {
        return recursive(root) != -1;
    }

    public int recursive(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeight = recursive(node.left);
        int rightHeight = recursive(node.right);

        if (leftHeight == -1 || rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) <= 1)
            return Math.max(leftHeight, rightHeight) + 1;
        else
            return -1;
    }
}