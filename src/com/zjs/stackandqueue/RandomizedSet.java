package com.zjs.stackandqueue;

import java.util.*;

/**
 * @ClassName RandomizedSet
 * @Description 380. 常数时间插入、删除和获取随机元素 题目链接: https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * 哈希表 + 动态数组
 * @Author hul-cyber
 * @Date 2021/2/19 22:15
 * @Version 1.0
 */
public class RandomizedSet {
    Map<Integer, Integer> dict;
    List<Integer> list;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        dict = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (dict.containsKey(val)) {
            return false;
        }
        dict.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!dict.containsKey(val)) {
            return false;
        }
        int temp = list.get(list.size() - 1);
        int pos = dict.get(val);
        list.set(pos, temp);
        dict.put(temp, pos);
        list.remove(list.size() - 1);
        dict.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        int randomNum = random.nextInt(list.size());
        return list.get(randomNum);
    }
}
