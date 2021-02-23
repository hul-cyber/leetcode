package com.zjs.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName MinStack
 * @Description 155. 最小栈 题目链接: https://leetcode-cn.com/problems/min-stack/
 * @Author hul-cyber
 * @Date 2021/2/23 17:02
 * @Version 1.0
 */
public class MinStack {

    private Deque<Integer> data;
    private Deque<Integer> helper;

    /** initialize your data structure here. */
    public MinStack() {
        data = new ArrayDeque<>();
        helper = new ArrayDeque<>();
    }

    public void push(int x) {
        data.addLast(x);
        if (helper.isEmpty() || x <= helper.peekLast()) {
            helper.addLast(x);
        }
    }

    public void pop() {
        if (data.removeLast().equals(helper.peekLast())) {
            helper.removeLast();
        }
    }

    public int top() {
        return data.peekLast();
    }

    public int getMin() {
        return helper.peekLast();
    }
}
