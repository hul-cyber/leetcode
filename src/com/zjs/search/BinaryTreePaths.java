package com.zjs.search;

import com.zjs.swordtooffer.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BinaryTreePaths
 * @Description TODO
 * @Author hul-cyber
 * @Date 2021/3/21 0:03
 * @Version 1.0
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList<String>();
        }
        List<String> paths = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        backTracking(root, paths, path);
        return paths;
    }

    private void backTracking(TreeNode node, List<String> paths, StringBuilder path) {
        if (node == null) {
            return;
        }
        if (path.length() != 0) {
            path.append("->").append(node.val);
        } else {
            path.append(node.val);
        }
        if (isLeaf(node)) {
            paths.add(path.toString());
        } else {
            StringBuilder tempPath = new StringBuilder(path.toString());
            backTracking(node.left, paths, path);
            backTracking(node.right, paths, tempPath);
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
