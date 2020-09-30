package com.zjs;

public class ReplaceSpace {
    public static void main(String[] args) {

    }

    public static String replaceSpace1(String s) {
        //时间复杂度O(n)
        //创建新的字符串作为替换完成过的字符串
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
