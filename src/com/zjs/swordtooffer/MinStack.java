package com.zjs.swordtooffer;

import java.util.Stack;

/**
 * @ClassName MinStack
 * @Description 剑指Offer30 包含min函数的栈 题目描述:https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * 构造一个辅助栈,时间复杂度为O(1) 空间复杂度为O(N)
 * @Author zhangjusheng
 * @Date 2020/10/13 15:40
 * @Version 1.0
 **/
public class MinStack {
    Stack<Integer> A, B;
    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }
    public void push(int x) {
        A.add(x);
        if(B.empty() || B.peek() >= x)
            B.add(x);
    }
    public void pop() {
        if(A.pop().equals(B.peek()))
            B.pop();
    }
    public int top() {
        return A.peek();
    }
    public int min() {
        return B.peek();
    }

}
