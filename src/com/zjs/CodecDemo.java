package com.zjs;

/**
 * @ClassName CodecDemo
 * @Description TODO
 * @Author zhangjusheng
 * @Date 2020/10/18 17:59
 * @Version 1.0
 **/
public class CodecDemo {
    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left =  node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        codec.deserialize(codec.serialize(node1));
    }
}
