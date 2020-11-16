package com.zjs;

/**
 * @ClassName ReverseLeftWords1
 * @Description 剑指Offer 58 - II 左旋转字符串 题目链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * 申请一个新的空间,用来存储调整后的字符串,空间换时间
 * @Author zhangjusheng
 * @Date 2020/11/11 16:52
 * @Version 1.0
 **/
public class ReverseLeftWords1 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder front = new StringBuilder();
        StringBuilder latter = new StringBuilder();

        //将前n个字符先存储起来
        for (int i = 0; i < n; i++) {
            latter.append(s.charAt(i));
        }
        //将剩余的字符存储起来
        for (int j = n; j < s.length(); j++) {
            front.append(s.charAt(j));
        }

        //将两个字符拼接起来
        return front.append(latter).toString();
    }
}
