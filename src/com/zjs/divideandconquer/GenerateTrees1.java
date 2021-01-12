package com.zjs.divideandconquer;

import com.zjs.swordtooffer.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GenerateTrees1
 * @Description 95. 不同的二叉搜索树 II 题目连接: https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * 分治法(未优化)
 * @Author zhangjusheng
 * @Date 2021/1/12 20:58
 * @Version 1.0
 */
public class GenerateTrees1 {

    public List<TreeNode> generateTrees(int low, int high) {
        List<TreeNode> trees = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            // 创建左子树
            List<TreeNode> left = generateTrees(low, i - 1);
            // 创建右子树
            List<TreeNode> right = generateTrees(i + 1, high);
            // 将左子树与右子树组合到一起
            combineTrees(i, left, right, trees);
        }
        return trees;
    }

    // 将左右子树和根组合在一起
    public void combineTrees(int i, List<TreeNode> left, List<TreeNode> right, List<TreeNode> trees) {
        int sizeOfLeft = left.size();
        int sizeOfRight = right.size();
        if (sizeOfLeft == 0 && sizeOfRight == 0) {
            TreeNode root = new TreeNode(i);
            root.left = null;
            root.right = null;
            trees.add(root);
        } else if (sizeOfLeft == 0 && sizeOfRight != 0) {
            for (TreeNode r : right) {
                TreeNode root = new TreeNode(i);
                root.left = null;
                root.right = r;
                trees.add(root);
            }
        } else if (sizeOfLeft != 0 && sizeOfRight == 0) {
            for (TreeNode l : left) {
                TreeNode root = new TreeNode(i);
                root.left = l;
                root.right = null;
                trees.add(root);
            }
        } else {
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    trees.add(root);
                }
            }
        }
    }
}
