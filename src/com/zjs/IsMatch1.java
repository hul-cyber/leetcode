package com.zjs;

/**
 * @ClassName IsMatch1
 * @Description 递归解决正则表达式匹配
 * @Author zhangjusheng
 * @Date 2020/10/8 14:26
 * @Version 1.0
 **/
public class IsMatch1 {
    /**
     * @Author zhangjusheng
     * @Description 判断正则表达式是否匹配 
     * @Date 14:28 2020/10/8
     * @Param [string, pattern]
     * @return boolean
     **/
    public boolean isMatch(String string, String pattern) {
        if (string == null || pattern == null)
            return false;
        StringBuilder sb = new StringBuilder(string);
        sb.append(0);
        string = sb.toString();
        sb = new StringBuilder(pattern);
        sb.append(0);
        pattern = sb.toString();
        return matchCore(string, pattern, 0, 0);
    }

    private boolean matchCore(String string, String pattern, int stringStart, int patternStart) {
        if (string.charAt(stringStart) == '0' && pattern.charAt(patternStart) == '0') 
            return true;
        
        if (string.charAt(stringStart) != '0' && pattern.charAt(patternStart) == '0')
            return false;

        boolean b = pattern.charAt(patternStart) == string.charAt(stringStart) || (pattern.charAt(patternStart) == '.' &&
                string.charAt(stringStart) != '0');
        if (pattern.charAt(patternStart + 1) == '*') {
            if (b)
                return matchCore(string, pattern, stringStart + 1, patternStart + 2) || matchCore(
                        string, pattern, stringStart, patternStart + 2) || matchCore(string, 
                        pattern, stringStart + 1, patternStart);
            else
                return matchCore(string, pattern, stringStart, patternStart + 2);
        } 
        if (b)
            return matchCore(string, pattern, stringStart + 1, patternStart + 1);
        return false;
    }
}
