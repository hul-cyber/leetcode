package com.zjs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName LevelOrder1
 * @Description 剑指Offer 32-1 从上到下打印二叉树 题目链接: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * 使用栈来完成层次遍历
 * @Author zhangjusheng
 * @Date 2020/10/13 21:29
 * @Version 1.0
 **/
public class LevelOrder1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];

        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new LinkedList<>();

        q.offer(root);
        while (q.size() != 0) {
            TreeNode node = q.poll();
            list.add(node.val);
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
