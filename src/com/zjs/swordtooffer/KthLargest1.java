package com.zjs.swordtooffer;

/**
 * @ClassName KthLargest1
 * @Description 剑指Offer54 二叉搜索树的第k大节点 题目链接:https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * 中序遍历法
 * @Author zhangjusheng
 * @Date 2020/11/2 20:13
 * @Version 1.0
 **/
public class KthLargest1 {
    int count = 0;
    int res = 0;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        node1.left = new TreeNode(1);
        node1.right = new TreeNode(4);
        node1.left.right = new TreeNode(2);
        KthLargest1 kthLargest = new KthLargest1();
        System.out.println(kthLargest.kthLargest(node1, 1));
    }

    public int kthLargest(TreeNode root, int k) {
        if (root == null)
            return -1;

        return res;
    }

    public void midTraversal(TreeNode root, int k) {
        if (root == null)
            return;

        midTraversal(root.right, k);
        count++;
        if (count == k) {
            res = root.val;
            return;
        }

        midTraversal(root.left, k);
    }
}
