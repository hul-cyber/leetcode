package com.zjs.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName MyQueue
 * @Description 232. 用栈实现队列 题目链接: https://leetcode-cn.com/problems/implement-queue-using-stacks/
 * @Author hul-cyber
 * @Date 2021/2/23 14:49
 * @Version 1.0
 */
public class MyQueue {

    private Deque<Integer> stackPush;
    private Deque<Integer> stackPop;

    /** Initialize your data structure here. */
    public MyQueue() {
        stackPush = new ArrayDeque<>();
        stackPop = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stackPush.addLast(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        move();
        return stackPop.removeLast();
    }

    /** Get the front element. */
    public int peek() {
        move();
        return stackPop.peekLast();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stackPop.isEmpty() && stackPush.isEmpty();
    }

    private void move() {
        if (!stackPop.isEmpty()) {
            return;
        }
        while (!stackPush.isEmpty()) {
            stackPop.addLast(stackPush.removeLast());
        }
    }
}
