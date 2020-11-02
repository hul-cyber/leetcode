package com.zjs;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName FirstUniqChar2
 * @Description 剑指Offer 50 第一个只出现一次的字符 题目链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * 有序哈希表
 * @Author zhangjusheng
 * @Date 2020/10/30 11:13
 * @Version 1.0
 **/
public class FirstUniqChar2 {
    public static void main(String[] args) {
        FirstUniqChar2 fuc2 = new FirstUniqChar2();
        System.out.println(fuc2.firstUniqChar("leetcode"));
    }

    public char firstUniqChar(String s) {
        Map<Character, Boolean> dic = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c : sc)
            dic.put(c, !dic.containsKey(c));
        for(Map.Entry<Character, Boolean> d : dic.entrySet()){
            if(d.getValue()) return d.getKey();
        }
        return ' ';
    }
}
