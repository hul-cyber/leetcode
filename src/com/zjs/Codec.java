package com.zjs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Codec
 * @Description 剑指Offer 37 序列化二叉树 题目链接: https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 * @Author zhangjusheng
 * @Date 2020/10/18 17:57
 * @Version 1.0
 **/
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        Integer i = 0;
        Integer indexOfNull = 0;
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder("[");
        //将根节点放入到队列中
        q.add(root);
        while(q.size() != 0) {
            TreeNode node = q.poll();
            if (node == null) {
                sb.append("null,");
            } else {
                i = node.val;
                sb.append(i.toString() + ",");
                q.add(node.left);
                q.add(node.right);
                indexOfNull = sb.length() - 1;
            }
        }
        //删除最后面的"null"
        sb.delete(indexOfNull, sb.length());
        sb.append("]");

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }

        //首先先将首尾去掉
        String subString = data.substring(1, data.length() - 1);
        //将字符串通过","分割开
        String[] datas = subString.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(datas[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (!datas[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(datas[i]));
                q.add(node.left);
            }
            i++;

            if (!datas[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(datas[i]));
                q.add(node.right);
            }
            i++;

            if (i == datas.length)
                break;
        }

        return root;
    }
}