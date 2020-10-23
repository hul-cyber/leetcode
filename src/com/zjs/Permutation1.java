package com.zjs;

import java.util.*;

/**
 * @ClassName Permutation1
 * @Description 剑指Offer 38 字符串的排列 题目链接: https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * 回溯 + 递归
 * @Author zhangjusheng
 * @Date 2020/10/21 23:51
 * @Version 1.0
 **/
public class Permutation1 {
    public static void main(String[] args) {
        Permutation1 permutation = new Permutation1();
        permutation.permutation("kzfxxx");
    }

    public String[] permutation(String s) {
        if (s == null)
            return null;

        List<String> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder(s);
        permutation(list, sb, 0, 0);

        String[] res = new String[list.size()];
        Iterator<String> iterator = list.iterator();

        int index = 0;
        while (iterator.hasNext()) {
            res[index++] = iterator.next();
        }

        return res;
    }


    public void permutation(List list, StringBuilder sb, int str, int begin) {
        if (begin == sb.length()) {
            list.add(sb.toString());
        }

        else {
            HashSet<Character> set = new HashSet<>();
            for (int i = begin; i < sb.length(); i++) {
                Character character = sb.charAt(i);
                if (set.contains(character)) continue;
                set.add(character);

                char c1 = sb.charAt(i);
                char c2 = sb.charAt(begin);

                sb.setCharAt(i, c2);
                sb.setCharAt(begin, c1);

                permutation(list, sb, str, begin + 1);

                c1 = sb.charAt(i);
                c2 = sb.charAt(begin);

                sb.setCharAt(i, c2);
                sb.setCharAt(begin, c1);

            }
        }
    }
}
