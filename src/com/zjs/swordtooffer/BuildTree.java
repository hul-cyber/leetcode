package com.zjs.swordtooffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    public static void main(String[] args) {
        int[] a = {3,9,20,15,7};
        int[] b = {9,3,15,20,7};
        BuildTree buildTree = new BuildTree();
        buildTree.buildTree(a, b);
    }

    //第一种方法
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        //首先判断两个遍历的结果是否为空
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        //找出根节点
        TreeNode tree = new TreeNode(preorder[0]);
        //确定根节点在中序遍历中的索引
        int rootIndex = -1;
        for(int i = 0; i < inorder.length; i++) {
            if(preorder[0] == inorder[i]) {
                rootIndex = i;
            }
        }
        //左子树元素的个数
        int leftNum = rootIndex;
        //右子树元素的个数
        int rightNum = inorder.length - 1 - rootIndex;
        //构造左子树
        int[] leftPreorder;
        int[] leftInorder;
        //左子树的中序遍历结果
        leftInorder = Arrays.copyOfRange(inorder, 0, leftNum);
        //左子树的前序遍历结果
        leftPreorder = Arrays.copyOfRange(preorder, 1, leftNum);
        tree.left = buildTree1(leftPreorder, leftInorder);
        //构造右子树
        int[] rightPreorder;
        int[] rightInorder;
        //右子树的中序遍历结果
        rightInorder = Arrays.copyOfRange(inorder, rootIndex + 1, rightNum);
        //右子树的前序遍历结果
        rightPreorder = Arrays.copyOfRange(preorder, leftNum + 1, rightNum);
        tree.right = buildTree1(rightPreorder, rightInorder);
        return tree;
    }

    //第二种方法
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        //前序序列的开头比结尾要大,说明序列已经为空
        if (preorderStart > preorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderStart];
        //初始化该树
        TreeNode root = new TreeNode(rootVal);
        //当只有一个元素时
        if (preorderStart == preorderEnd) {
            return root;
        } else {
            //快速获取根节点在中序遍历序列中的位置
            int rootIndex = indexMap.get(rootVal);
            //计算左子树与右子树元素的个数
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            //构造左子树
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            //构造右子树
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
