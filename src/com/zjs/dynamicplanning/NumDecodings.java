package com.zjs.dynamicplanning;

/**
 * @ClassName NumDecodings
 * @Description 91. 解码方法 题目链接: https://leetcode-cn.com/problems/decode-ways/
 * 动态规划
 * @Author hul-cyber
 * @Date 2021/3/10 0:04
 * @Version 1.0
 */
public class NumDecodings {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int a = 1;
        int b = 1;
        int res = 0;
        int len = s.length();
        for (int i = 2; i <= len; i++) {
            String tmp = s.substring(i - 2, i);
            if (tmp.compareTo("10") == 0 || tmp.compareTo("20") == 0) {
                res = a;
            } else if (tmp.compareTo("11") >= 0 && tmp.compareTo("26") <= 0) {
                res = a + b;
            } else {
                if (tmp.charAt(1) == '0') {
                    return 0;
                }
                res = b;
            }
            a = b;
            b = res;
        }
        return b;
    }
}
