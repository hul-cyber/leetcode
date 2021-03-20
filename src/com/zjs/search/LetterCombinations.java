package com.zjs.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LetterCombinations
 * @Description 17. 电话号码的字母组合 题目链接: https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * Backtracking
 * @Author hul-cyber
 * @Date 2021/3/18 23:19
 * @Version 1.0
 */
public class LetterCombinations {

    private static final String[] LETTERS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<String>();
        }
        List<String> combinations = new ArrayList<>();
        letterCombinations(new StringBuilder(), combinations, digits);
        return combinations;
    }

    private void letterCombinations(StringBuilder prefix, List<String> combinations, String digits) {
        if (prefix.length() == digits.length()) {
            combinations.add(prefix.toString());
            return;
        }
        int curNum = Integer.valueOf(digits.charAt(prefix.length()) - '0');
        char[] letters = LETTERS[curNum].toCharArray();
        for (char c : letters) {
            prefix.append(c);
            letterCombinations(prefix, combinations, digits);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}
