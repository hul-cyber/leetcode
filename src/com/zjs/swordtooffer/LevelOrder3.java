package com.zjs.swordtooffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName LevelOrder3
 * @Description 剑指Offer 32-2 从上到下打印二叉树2 题目链接:https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * BFS
 * @Author zhangjusheng
 * @Date 2020/10/13 21:35
 * @Version 1.0
 **/
public class LevelOrder3 {
    public List<List<Integer>> levelOrder(LevelOrder1.TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }

        List<List<Integer>> list1 = new ArrayList<>();
        Queue<LevelOrder1.TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (q.size() != 0) {
            List<Integer> list2 = new ArrayList<>();
            LevelOrder1.TreeNode node = null;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                node = q.poll();
                list2.add(node.val);
                if (node != null && node.left != null)
                    q.offer(node.left);
                if (node != null && node.right != null)
                    q.offer(node.right);
            }
            list1.add(list2);
        }

        return list1;
    }
}
