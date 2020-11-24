package com.zjs.swordtooffer;

/**
 * @ClassName IsSubStructure2
 * @Description 剑指Offer26 树的子结构 题目链接:https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * 使用双递归(优化)求解数的子结构 最坏情况下: 时间复杂度O(MN) 空间复杂度O(M) M: 树A的节点数量 N: 树B的节点数量
 * @Author zhangjusheng
 * @Date 2020/10/11 9:56
 * @Version 1.0
 **/
public class IsSubStructure2 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        if (isSubStructureOfTree(A, B)) {
            return true;
        } else {
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }

    public boolean isSubStructureOfTree(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        else if (A == null)
            return false;
        else
        if (A.val == B.val) {
            return isSubStructureOfTree(A.left, B.left) && isSubStructureOfTree(A.right, B.right);
        } else {
            return false;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
