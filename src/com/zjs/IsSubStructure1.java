package com.zjs;

/**
 * @ClassName IsSubStructure1
 * @Description 剑指Offer26 树的子结构 题目链接:https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * 使用双递归(未优化)求解数的子结构 最坏情况下: 时间复杂度O(MN) 空间复杂度O(M) M是A中节点个数 N是B中节点的个数
 * @Author zhangjusheng
 * @Date 2020/10/11 9:51
 * @Version 1.0
 **/
public class IsSubStructure1 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        if (isSubStructureOfTree(A, B)) {
            return true;
        } else {

            if (A.left == null)
                return false;
            else {
                if(isSubStructure(A.left, B))
                    return true;
                else {
                    if (A.right == null)
                        return false;
                    else
                        return isSubStructure(A.right, B);
                }
            }
            //return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
    }

    public boolean isSubStructureOfTree(TreeNode A, TreeNode B) {
        boolean flag = false;
        if (A.val == B.val) {
            //如果两颗树根节点相同
            if (B.left == null) {
                if (B.right == null) {
                    return true;
                } else {
                    if (A.right != null) {
                        return isSubStructureOfTree(A.right, B.right);
                    } else {
                        return false;
                    }
                }
            } else {
                if (A.left != null) {
                    flag = isSubStructureOfTree(A.left, B.left);
                    if (A.right == null)
                        if (B.right == null)
                            return flag;
                        else
                            return false;
                    else
                    if (B.right != null) {
                        return flag && isSubStructureOfTree(A.right, B.right);
                    } else {
                        return flag && true;
                    }
                } else {
                    return false;
                }
            }
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
