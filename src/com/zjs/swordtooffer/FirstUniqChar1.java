package com.zjs.swordtooffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName FirstUniqChar1
 * @Description 剑指Offer 50 第一个只出现一次的字符 题目链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/
 * 哈希表
 * @Author zhangjusheng
 * @Date 2020/10/30 10:55
 * @Version 1.0
 **/
public class FirstUniqChar1 {
    public static void main(String[] args) {
        FirstUniqChar1 fuc = new FirstUniqChar1();
        System.out.println(fuc.firstUniqChar("abaccdeff"));
    }

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int index = 0;
        int lastNumber = 0;

        while (index < s.length()) {
            lastNumber = map.getOrDefault(s.charAt(index), 0);
            map.put(s.charAt(index), lastNumber + 1);
            index++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 0)
                return s.charAt(i);
        }

        return ' ';
    }

}
