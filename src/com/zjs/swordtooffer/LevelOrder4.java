package com.zjs.swordtooffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LevelOrder4
 * @Description 剑指Offer 32 - 3 从上到下打印二叉树 3 题目链接: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * 双端对列
 * @Author zhangjusheng
 * @Date 2020/10/13 22:49
 * @Version 1.0
 **/
public class LevelOrder4 {
    public List<List<Integer>> levelOrder(LevelOrder1.TreeNode root) {
        if (root == null)
            return new ArrayList<>();

        int level = 0;
        Deque<LevelOrder1.TreeNode> deque = new LinkedList<>();
        List<List<Integer>> list1 = new ArrayList<>();

        deque.offerLast(root);

        while (deque.size() != 0) {
            int size = deque.size();
            List<Integer> list2 = new ArrayList<>();
            LevelOrder1 levelOrder1 = new LevelOrder1();
            LevelOrder1.TreeNode node = levelOrder1.new TreeNode(-1);
            for(int i = 0; i < size; i++) {
                if (level % 2 == 0) {
                    node = deque.pollFirst();
                    if (node.left != null)
                        deque.addLast(node.left);
                    if (node.right != null)
                        deque.addLast(node.right);
                    list2.add(node.val);
                }
                if (level % 2 == 1) {
                    node = deque.pollLast();
                    if (node.right != null)
                        deque.addFirst(node.right);
                    if (node.left != null)
                        deque.addFirst(node.left);
                    list2.add(node.val);
                }
            }
            list1.add(list2);
            level++;
        }

        return list1;
    }
}
