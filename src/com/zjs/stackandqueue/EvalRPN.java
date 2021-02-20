package com.zjs.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName EvalRPN
 * @Description 150. 逆波兰表达式的求值 题目链接: https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 * 栈
 * @Author hul-cyber
 * @Date 2021/2/20 14:45
 * @Version 1.0
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int num1 = Integer.valueOf(stack.removeLast());
                int num2 = Integer.valueOf(stack.removeLast());
                // System.out.println(num1);
                // System.out.println(num2);
                switch (token) {
                    case "+":
                        stack.addLast(num2 + num1);
                        break;
                    case "-":
                        stack.addLast(num2 - num1);
                        break;
                    case "*":
                        stack.addLast(num2 * num1);
                        break;
                    case "/":
                        stack.addLast(num2 / num1);
                        break;
                    default:
                        break;
                }
            } else {
                stack.addLast(Integer.valueOf(token));
            }
        }
        return stack.removeLast();
    }

    private boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        } else {
            return false;
        }
    }
}
