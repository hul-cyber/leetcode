package com.zjs.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName SimplifyPath
 * @Description 71. 简化路径 题目链接: https://leetcode-cn.com/problems/simplify-path/
 * 栈
 * @Author hul-cyber
 * @Date 2021/2/20 13:15
 * @Version 1.0
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        // 利用"/"将path分割为数组
        String[] dirs = path.split("/");
        if (dirs.length == 0) {
            return "/";
        }
        Deque<String> stack = new ArrayDeque<>();
        for (String dir : dirs) {
            if (dir.equals(".") || dir.equals("")) {
                continue;
            } else if (dir.equals("..")) {
                if (stack.isEmpty()) {
                    continue;
                } else {
                    stack.removeLast();
                }
            } else {
                stack.addLast(dir);
            }
        }
        StringBuilder result = new StringBuilder();
        if (stack.isEmpty()) {
            return "/";
        }
        while (!stack.isEmpty()) {
            result.insert(0, stack.removeLast());
            result.insert(0, "/");
        }
        return result.toString();
    }
}
