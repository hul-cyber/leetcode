package com.zjs.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName MyStack
 * @Description 225. 用队列实现栈 题目链接: https://leetcode-cn.com/problems/implement-stack-using-queues/
 * @Author hul-cyber
 * @Date 2021/2/23 15:16
 * @Version 1.0
 */
public class MyStack {

    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        move();
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        move();
        int res = queue.poll();
        queue.offer(res);
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    private void move() {
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }
}
