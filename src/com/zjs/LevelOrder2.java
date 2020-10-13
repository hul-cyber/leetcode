package com.zjs;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LevelOrder2
 * @Description 剑指Offer 32-2 从上到下打印二叉树2 题目链接:https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * DFS
 * @Author zhangjusheng
 * @Date 2020/10/13 21:33
 * @Version 1.0
 **/
public class LevelOrder2 {
    public List<List<Integer>> levelOrder(LevelOrder1.TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        levelHelper(list, root, 0);
        return list;
    }

    public void levelHelper(List<List<Integer>> list, LevelOrder1.TreeNode root, int level) {
        if (root == null)
            return;

        if (level >= list.size())
            list.add(new ArrayList<>());

        list.get(level).add(root.val);

        levelHelper(list, root.left, level + 1);
        levelHelper(list, root.right, level + 1);
    }
}
