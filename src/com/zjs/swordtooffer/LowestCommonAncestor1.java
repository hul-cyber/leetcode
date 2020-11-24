package com.zjs.swordtooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LowestCommonAncestor1
 * @Description 剑指Offer 68-1 二叉搜索树的最近公共祖先 题目链接: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/
 * 深度优先遍历
 * @Author zhangjusheng
 * @Date 2020/11/23 11:11
 * @Version 1.0
 */
public class LowestCommonAncestor1 {
    // 用来遍历的序列
    List<TreeNode> listTransversal = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 存储到节点p的路径
        List<TreeNode> pList = new ArrayList<>();
        // 存储到节点q的路径
        List<TreeNode> qList = new ArrayList<>();
        dfs(root, pList, qList, p, q);
        // 遍历两个列表找出它们的共同祖先
        int index = 0;
        TreeNode ancestor = new TreeNode(-1);
        while (index < pList.size() && index < qList.size()) {
            if (pList.get(index) == qList.get(index)) {
                ancestor = pList.get(index);
                index++;
            } else {
                break;
            }
        }
        return ancestor;
    }
    // 深度遍历搜索
    void dfs(TreeNode root, List pList, List qList, TreeNode p, TreeNode q) {
        if (root == null)
            return;
        listTransversal.add(root);
        if (root.val == p.val) {
            // 如果遍历到了p节点,将之前所有的元素全部都添加到pList
            for (TreeNode node : listTransversal)
                pList.add(node);
        }
        if (root.val == q.val) {
            // 如果遍历到了q节点,将之前所有的元素全部添加到qList
            for (TreeNode node : listTransversal)
                qList.add(node);
        }
        // 如果两个节点已经全部遍历到,直接返回
        if (pList.size() != 0 && qList.size() != 0)
            return;
        dfs(root.left, pList, qList, p, q);
        dfs(root.right, pList, qList, p, q);
        // 如果遍历完之后没有发现,那么就要把该元素从当前的遍历列表中移出去
        listTransversal.remove(root);
    }
}