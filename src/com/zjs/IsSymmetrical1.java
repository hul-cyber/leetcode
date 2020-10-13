package com.zjs;

/**
 * @ClassName IsSymmetrical1
 * @Description 剑指Offer28 对称的二叉树 题目链接:https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * 递归解法 最坏情况下 时间复杂度O(N) 空间复杂度O(N),也可以理解为判断一种前序遍历(根左右)与另一种前序遍历(根右左)相不相同
 * @Author zhangjusheng
 * @Date 2020/10/12 9:40
 * @Version 1.0
 **/
public class IsSymmetrical1 {
    public boolean isSymmetric(TreeNode root) {
        return recur(root, root);
    }

    boolean recur(TreeNode L, TreeNode R) {
        if (L == null && R == null)
            return true;
        if (L == null || R == null || L.val != R.val)
            return false;
        return recur(L.left, R.right) && recur(L.right, R.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }
}
