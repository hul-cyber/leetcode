package com.zjs.search;

import java.util.*;

/**
 * @ClassName RestoreIpAddresses
 * @Description 93. 复原IP地址 题目链接: https://leetcode-cn.com/problems/restore-ip-addresses/
 * Backtracking
 * @Author hul-cyber
 * @Date 2021/3/19 8:59
 * @Version 1.0
 */
public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return new ArrayList<String>();
        }
        List<String> ipAddresses = new ArrayList<>();
        restoreIpAddresses(new StringBuilder(), ipAddresses, s, 0);
        return ipAddresses;
    }

    private void restoreIpAddresses(StringBuilder prefix, List<String> ipAddresses, String s, int
            k) {
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0) {
                ipAddresses.add(prefix.toString());
            }
            return;
        }
        for (int i = 0; i < s.length() && i <= 2; i++) {
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            String part = s.substring(0, i + 1);
            int num = Integer.valueOf(part);
            if (num > 255) {
                continue;
            }
            if (prefix.length() != 0) {
                part = "." + part;
            }
            prefix.append(part);
            restoreIpAddresses(prefix, ipAddresses, s.substring(i + 1), k + 1);
            prefix.delete(prefix.length() - part.length(), prefix.length());
        }
    }
}
