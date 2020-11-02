package com.zjs;

/**
 * @ClassName DepthBinaryTree2
 * @Description 剑指Offer55-1 二叉树的深度 题目链接:https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof/
 * 另外一种深度优先遍历
 * @Author zhangjusheng
 * @Date 2020/11/2 23:17
 * @Version 1.0
 **/
public class DepthBinaryTree2 {
    int maxDepth = 0;
    int curDepth = 0;

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
